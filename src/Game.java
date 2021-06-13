import java.util.Scanner;

public class Game {
    public boolean inGame;
    team Reds = new team();
    team Blues = new team();
    int Redscore = 0;
    int Bluescore = 0;
    boolean RedBall = true;
    boolean BlueBall = false;
    team recieveAtHalf = Blues;
    public int ball = 0;
    public int gameClock = 900;
    public int quarter = 1;
    public int down = 1;
    public int togo = 10;
    public double yardageGain = 0;
    public Scanner input = new Scanner(System.in);

    public void printStats(){
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
    }
    public void printScore(){
        System.out.println(Reds.name + ": " + Redscore + "  |||  " + Blues.name + ":" + Bluescore);
    }
    public void liveStats(){
        String[] visualBar = {"<", "=","=","=","=","=","=","=","=","=",">"};
        int ballIndex = ((int) ball/10);
        if (ballIndex > 10){
            ballIndex = 10;
        }
        else if (ballIndex < 0){
            ballIndex = 0;
        }
        visualBar[ballIndex] = "|";
        System.out.println("Ball at the " + ball + " yard line. ");
        System.out.println(String.join("=",visualBar));
        System.out.println(down + " and " + togo);
    }
    public boolean gameOver(){
        if(gameClock < 0 && quarter >= 4){
            return false;
        }
        else{
            return true;
        }
    }
    public void setGameClock(int a){
        gameClock -= a;
        if (gameClock < 0 && quarter >= 4){
            endGame();
        }
        else if (gameClock < 0){
            nextQuarter();
            if(quarter == 3){
                System.out.println("Halftime!");
                System.out.println("Halftime stats: ");
                printStats();
                if(recieveAtHalf == Blues){
                    BlueBall = true;
                    RedBall = false;
                }
                else{
                    BlueBall = false;
                    RedBall = true;
                }
                ball = 20;
            }
        }
    }
    public void printGameClock(){
        System.out.println(((int)(gameClock/60))+":"+(gameClock%60)+" left in the " + quarter + " quarter. ");
    }
    public void postPlay(int a){
        setDowns();
        printDowns();
        setGameClock(a);
        printGameClock();
    }
    public void setDowns(){
        down++;
        togo -= yardageGain;
        if (togo <= 0){
            togo = 10;
            down = 1;
        }
        if (down > 4){
            System.out.println("turnover on downs!");
            flipPosessions();
            ball = Math.abs(100-ball);
        }
    }
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void printDowns(){
        System.out.println(down + " and " + togo);
    }
    public void redPossessionAI(Game game){
        down = 1;
        togo = 10;
        System.out.println(Reds.name +" Ball!");
        printScore();
        while(gameOver() && RedBall){
            yardageGain = 0;
            liveStats();
            String inputter = AI.pickPlay(gameClock,Bluescore,Redscore,down,togo,ball);
            System.out.println(inputter);
            if(inputter.equals("run")){
                yardageGain = (simulator.runPlay(game, Reds.rb,Blues.lb, Blues.dt, Blues.cb));
                ball += (int) yardageGain;
                postPlay(17);
                if (ball > 100){
                    System.out.println("Touchdown rush by " + Reds.rb.name+"!");
                    Redscore += 7;
                    Reds.rb.td++;
                    flipPosessions();
                    ball = 20;
                }
                else if (ball < 0){
                    System.out.println("Safety by " + Blues.dt.name + "!");
                    Bluescore += 2;
                    flipPosessions();
                    ball = 30;
                }

            }
            else if(inputter.equals("pass")){
                yardageGain = (simulator.passPlay(game, Reds.qb, Reds.wr, Blues.cb, Blues.dt));
                ball += (int) yardageGain;
                if (ball > 100){
                    System.out.println(Reds.qb.name + " touchdown throw to " + Reds.wr.name + "!");
                    Reds.qb.td++;
                    Reds.wr.td++;
                    Redscore += 7;
                    flipPosessions();
                    ball = 20;
                }
            }
            else if (inputter.equals("punt")){
                simulator.punt(game);
                flipPosessions();
            }
            else if (inputter.equals("fg")){
                if(simulator.fieldGoal(game)){
                    Redscore += 3;
                }
                flipPosessions();
                ball = 20;
            }
            else if (inputter.equals("endgame")){
                endGame();
            }
            postPlay(17);
        }

    }
    public void redPosession(Game game){
        down = 1;
        togo = 10;
        System.out.println(Reds.name + " ball!");
        printScore();
        while(gameOver() && RedBall){
            yardageGain = 0;
            liveStats();
            System.out.println("pass or run? ");
            String inputter = input.next();
            System.out.println(inputter);
            if(inputter.equals("run")){
                yardageGain = (simulator.runPlay(game, Reds.rb,Blues.lb, Blues.dt, Blues.cb));
                ball += (int) yardageGain;
                postPlay(17);
                if (ball > 100){
                    System.out.println("Touchdown rush by " + Reds.rb.name+"!");
                    Redscore += 7;
                    Reds.rb.td++;
                    flipPosessions();
                    ball = 20;
                }
                else if (ball < 0){
                    System.out.println("Safety by " + Blues.dt.name + "!");
                    Bluescore += 2;
                    flipPosessions();
                    ball = 30;
                }

            }
            else if(inputter.equals("pass")){
                yardageGain = (simulator.passPlay(game, Reds.qb, Reds.wr, Blues.cb, Blues.dt));
                ball += (int) yardageGain;
                if (ball > 100){
                    System.out.println(Reds.qb.name + " touchdown throw to " + Reds.wr.name + "!");
                    Reds.qb.td++;
                    Reds.wr.td++;
                    Redscore += 7;
                    flipPosessions();
                    ball = 20;
                }
            }
            else if (inputter.equals("punt")){
                simulator.punt(game);
                flipPosessions();
            }
            else if (inputter.equals("fg")){
                if(simulator.fieldGoal(game)){
                    Redscore += 3;
                }
                flipPosessions();
                ball = 20;
            }
            else if (inputter.equals("endgame")){
                endGame();
            }
        }
        postPlay(17);
    }
    public void bluePossessionAI(Game game){
        down = 1;
        togo = 10;
        System.out.println(Blues.name + " ball!");
        printScore();
        while(gameOver() && BlueBall){
            yardageGain = 0;
            liveStats();
            String inputter = AI.pickPlay(gameClock,Redscore,Bluescore,down,togo,ball);
            System.out.println(inputter);
            if(inputter.equals("run")){
                yardageGain = (simulator.runPlay(game, Blues.rb,Reds.lb, Reds.dt, Reds.cb));
                ball += (int) yardageGain;
                postPlay(17);
                if (ball > 100){
                    System.out.println("Touchdown rush by " + Blues.rb.name+"!");
                    Bluescore += 7;
                    Blues.rb.td++;
                    flipPosessions();
                    ball = 20;
                }
                else if (ball < 0){
                    System.out.println("Safety by " + Reds.dt.name + "!");
                    Redscore += 2;
                    flipPosessions();
                    ball = 30;
                }

            }
            else if(inputter.equals("pass")){
                yardageGain = (simulator.passPlay(game, Blues.qb, Blues.wr, Reds.cb, Reds.dt));
                ball += (int) yardageGain;
                if (ball > 100){
                    System.out.println(Blues.qb.name + " touchdown throw to " + Blues.wr.name + "!");
                    Blues.qb.td++;
                    Blues.wr.td++;
                    Bluescore += 7;
                    flipPosessions();
                    ball = 20;
                }
            }
            else if (inputter.equals("punt")){
                simulator.punt(game);
                flipPosessions();
            }
            else if (inputter.equals("fg")){
                if(simulator.fieldGoal(game)){
                    Bluescore += 3;
                }
                flipPosessions();
                ball = 20;
            }
            else if (inputter.equals("endgame")){
                endGame();
            }
            postPlay(17);
        }

    }

    public void bluePosession(Game game){
        down = 1;
        togo = 10;
        System.out.println(Blues.name + " ball!");
        printScore();
        while(gameOver() && BlueBall){
            yardageGain = 0;
            liveStats();
            System.out.println("pass or run? ");
            String inputter = input.next();
            System.out.println(inputter);
            if(inputter.equals("run")){
                yardageGain = (simulator.runPlay(game, Blues.rb,Reds.lb, Reds.dt, Reds.cb));
                ball += (int) yardageGain;
                postPlay(17);
                if (ball > 100){
                    System.out.println("Touchdown rush by " + Blues.rb.name+"!");
                    Bluescore += 7;
                    Blues.rb.td++;
                    flipPosessions();
                    ball = 20;
                }
                else if (ball < 0){
                    System.out.println("Safety by " + Reds.dt.name + "!");
                    Redscore += 2;
                    flipPosessions();
                    ball = 30;
                }

            }
            else if(inputter.equals("pass")){
                yardageGain = (simulator.passPlay(game, Blues.qb, Blues.wr, Reds.cb, Reds.dt));
                ball += (int) yardageGain;
                if (ball > 100){
                    System.out.println(Blues.qb.name + " touchdown throw to " + Blues.wr.name + "!");
                    Blues.qb.td++;
                    Blues.wr.td++;
                    Bluescore += 7;
                    flipPosessions();
                    ball = 20;
                }
            }
            else if (inputter.equals("punt")){
                simulator.punt(game);
                flipPosessions();
            }
            else if (inputter.equals("fg")){
                if(simulator.fieldGoal(game)){
                    Bluescore += 3;
                }
                flipPosessions();
                ball = 20;
            }
            else if (inputter.equals("endgame")){
                endGame();
            }
        }
        postPlay(17);
    }
    public void flipPosessions(){
        RedBall = !RedBall;
        BlueBall = !BlueBall;
        down = 1;
        togo = 10;

    }
    public void nextQuarter(){
        quarter++;
        gameClock = 900;
        if (quarter > 4){
            endGame();
        }
    }
    public void endGame(){
        inGame = false;
        if(Redscore > Bluescore){
            System.out.println(Reds.name + " win!");
        }
        else if (Bluescore > Redscore){
            System.out.println(Blues.name + " win!");
        }
        else{
            System.out.println("Tie!");
        }
        System.out.println(Blues.name + " scored " + Bluescore);
        System.out.println(Reds.name + " Reds scored " + Redscore);
        System.out.println("End of game stats: ");
        printStats();
    }



}
