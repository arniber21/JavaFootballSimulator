import java.util.Arrays;
import java.util.Scanner;

public class Game {
    static team Reds = new team();
    static team Blues = new team();
    public static int ball = 0;
    public static int gameClock = 900;
    public static int quarter = 1;
    public static int down = 1;
    public static int togo = 10;
    public static double yardageGain = 0;
    public static Scanner input = new Scanner(System.in);



    public static void main(String[] args) {

    }
    public static void initializeGame(){

        int ball = 20;
        Reds.name = "Reds";
        Blues.name = "Blues";
        Reds.possesion = true;
        Reds.recieveAtHalf = false;
        Blues.recieveAtHalf = true;
        Blues.possesion = false;
        Reds.score = 0;
        Blues.score = 0;
        // New running back named Reds.rb

        Reds.rb.name = "Leonard Fournette";
        Reds.rb.speed = 90;
        Reds.rb.elusive = 20;
        Reds.rb.power = 10;
        // New linebacker named Reds.lb

        Reds.lb.name = "Lavonte David";
        Reds.lb.playmake = 70;
        Reds.lb.power = 70;

        // New DT named Reds.nt
        Reds.dt.name = "Ndamukong Suh";
        Reds.dt.power = 70;
        Reds.dt.playmake = 80;
        // New DB named Reds.cb

        Reds.cb.name = "Carlton Davis";
        Reds.cb.coverage = 60;
        Reds.cb.playmake = 30;
        // New QB named Reds.qb
        Reds.qb.name = "Tom Brady";
        Reds.qb.thp = 60;
        Reds.qb.tha = 90;
        Reds.qb.mob = 20;

        // New WR named Reds.wr
        Reds.wr.name = "Chris Godwin";
        Reds.wr.catching = 80;
        Reds.wr.routerunning = 30;



        Blues.rb.name = "Damien Harris";
        Blues.rb.speed = 90;
        Blues.rb.elusive = 20;
        Blues.rb.power = 10;
        // New linebacker named Blues.lb

        Blues.lb.name = "Donta Hightower";
        Blues.lb.playmake = 80;
        Blues.lb.power = 90;
        // New DT named Blues.nt
        Blues.dt.name = "Davon Godchaux";
        Blues.dt.power = 70;
        Blues.dt.playmake = 80;
        // New DB named Blues.cb

        Blues.cb.name = "Stephon Gilmore";
        Blues.cb.coverage = 100;
        Blues.cb.playmake = 80;
        // New QB named Blues.qb
        Blues.qb.name = "Cam Newton";
        Blues.qb.thp = 100;
        Blues.qb.tha = 90;
        Blues.qb.mob = 20;
        // New WR named Blues.wr
        Blues.wr.name = "Nelson Agholor";
        Blues.wr.catching = 100;
        Blues.wr.routerunning = 30;

    }
    public static void printScore(){
        System.out.println("Reds: " + Reds.score + "  |||  Blues: " + Blues.score);
    }
    public static void liveStats(){
        String[] visualBar = {"<", "=","=","=","=","=","=","=","=","=",">"};
        visualBar[((int) ball/10)] = "||";
        System.out.println("Ball at the " + ball + " yard line. ");
        System.out.println(Arrays.toString(visualBar));
        System.out.println(down + " and " + togo);
    }
    public static void setGameClock(int a){
        gameClock -= a;
        if (gameClock < 0){
            nextQuarter();
            if(quarter == 3){
                flipPosessions();
            }
        }
    }
    public static void printGameClock(){
        System.out.println(gameClock+" left in the " + quarter + " quarter. ");
    }
    public static void postPlay(int a){
        setDowns();
        printDowns();
        setGameClock(a);
        printGameClock();
    }
    public static void setDowns(){
        down++;
        togo -= yardageGain;
        if (togo <= 0){
            togo = 10;
            down = 1;
        }
        if (down > 4){
            System.out.println("turnover on downs!");
            flipPosessions();
        }
    }
    public static void printDowns(){
        System.out.println(down + " and " + togo);
    }
    public static void redPosession(){
        ball = 20;
        down = 1;
        togo = 10;
        System.out.println("Reds Ball!");
        printScore();
        while(true && Reds.possesion){
            yardageGain = 0;
            liveStats();
            System.out.println("pass or run? ");
            String inputter = input.next();
            System.out.println(inputter);
            if(inputter.equals("run")){
                yardageGain = (simulator.runPlay(Reds.rb,Blues.lb, Blues.dt, Blues.cb));
                ball += (int) yardageGain;
                postPlay(30);
                if (ball > 100){
                    System.out.println("Touchdown rush by " + Reds.rb.name+"!");
                    Reds.score += 7;
                    Reds.rb.td++;
                    flipPosessions();
                }
                else if (ball < 0){
                    System.out.println("Safety by " + Blues.dt.name + "!");
                    Blues.score += 2;
                    flipPosessions();
                }

            }
            else if(inputter.equals("pass")){
                yardageGain = (simulator.passPlay(Reds.qb, Reds.wr, Blues.cb, Blues.dt));
                ball += (int) yardageGain;
                if (ball > 100){
                    System.out.println(Reds.qb.name + " touchdown throw to " + Reds.wr.name + "!");
                    Reds.qb.td++;
                    Reds.wr.td++;
                    Reds.score += 7;
                    flipPosessions();
                }
                postPlay(10);
            }
            else if (inputter.equals("endgame")){
                endGame();
            }
        }
    }
    public static void bluePossession(){
        ball = 20;
        down = 1;
        togo = 10;
        System.out.println("Blues Ball!");
        printScore();
        while(true && Blues.possesion){
            yardageGain = 0;
            liveStats();
            System.out.println("pass or run? ");
            String inputter = input.next();
            System.out.println(inputter);
            if(inputter.equals("run")){
                yardageGain = (simulator.runPlay(Blues.rb,Reds.lb, Reds.dt, Reds.cb));
                ball += (int) yardageGain;
                postPlay(30);
                if (ball > 100){
                    System.out.println("Touchdown rush by " + Blues.rb.name+"!");
                    Blues.score += 7;
                    Blues.rb.td++;
                    flipPosessions();
                }
                else if (ball < 0){
                    System.out.println("Safety by " + Reds.dt.name + "!");
                    Reds.score += 2;
                    flipPosessions();
                    flipPosessions();
                }

            }
            else if(inputter.equals("pass")){
                yardageGain = (simulator.passPlay(Blues.qb, Blues.wr, Reds.cb, Reds.dt));
                ball += (int) yardageGain;
                if (ball > 100){
                    System.out.println(Blues.qb.name + " touchdown throw to " + Blues.wr.name + "!");
                    Blues.qb.td++;
                    Blues.wr.td++;
                    Blues.score += 7;
                    flipPosessions();
                }
                postPlay(10);
            }
            else if (inputter.equals("endgame")){
                endGame();
            }
        }
    }
    public static void flipPosessions(){
        if (Reds.possesion){
            Blues.possesion = true;
            Reds.possesion = false;
        }
        else{
            Blues.possesion = false;
            Reds.possesion = true;
        }
    }
    public static void nextQuarter(){
        quarter++;
        gameClock = 900;
        if (quarter > 4){
            endGame();
        }
    }
    public static void endGame(){
        if(Reds.score > Blues.score){
            System.out.println("Reds win!");
        }
        else if (Blues.score > Reds.score){
            System.out.println("Blues win!");
        }
        else{
            System.out.println("Tie!");
        }
        System.out.println("Blues scored " + Blues.score);
        System.out.println("Reds scored " + Reds.score);
        Reds.qb.printStats();
        Reds.rb.printStats();
        Reds.wr.printStats();
        Reds.dt.printStats();
        Reds.lb.printStats();
        Reds.cb.printStats();


        Blues.qb.printStats();
        Blues.rb.printStats();
        Blues.wr.printStats();
        Blues.dt.printStats();
        Blues.lb.printStats();
        Blues.cb.printStats();
        System.exit(0);
    }



}
