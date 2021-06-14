import javax.swing.*;
import java.util.Scanner;

public class Game {
    public boolean inGame;
    team Reds = new team();
    team Blues = new team();
    int Redscore = 0;
    int Bluescore = 0;
    boolean RedBall = true;
    boolean BlueBall = false;
    team hasBall = Reds;
    team defense = Blues;
    team recieveAtHalf = Blues;
    public int ball = 0;
    public int gameClock = 900;
    public int quarter = 1;
    public int down = 1;
    public int togo = 10;
    public double yardageGain = 0;
    public boolean playPicked = false;
    public Scanner input = new Scanner(System.in);
    String inputter;
    public void sendInput(String inputToSend){
        inputter = inputToSend;
    }
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
    public void printScore(GameUI gui){
        gui.setScoreboard("hi");
    }
    public void liveStats(GameUI gui){

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
    public void printGameClock(GameUI gui){

    }
    public void postPlay(int a, GameUI gui){
        setDowns();
        setGameClock(a);
        printGameClock(gui);
        gui.getContentPane().repaint();
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
    public void redPossessionAI(Game game, GameUI gui){
        down = 1;
        togo = 10;
        gui.setPosessionIndicator(game.Reds.name + " Ball!");
        printScore(gui);
        while(gameOver() && RedBall){
            yardageGain = 0;
            liveStats(gui);
            inputter = AI.pickPlay(game, gameClock,Bluescore,Redscore,down,togo,ball);
            System.out.println(inputter);
            if(inputter.equals("run") && playPicked == true){
                yardageGain = (simulator.runPlay(gui,game, Reds.rb,Blues.lb, Blues.dt, Blues.cb));
                ball += (int) yardageGain;
                postPlay(17, gui);
                if (ball > 100){
                    gui.setLastPlay("Touchdown rush by " + Reds.rb.name+"!");
                    Redscore += 7;
                    Reds.rb.td++;
                    flipPosessions();
                    ball = 20;
                }
                else if (ball < 0){
                    gui.setLastPlay("Safety by " + Blues.dt.name + "!");
                    Bluescore += 2;
                    flipPosessions();
                    ball = 30;
                }
                playPicked = false;

            }
            else if(inputter.equals("pass") && playPicked == true){
                yardageGain = (simulator.passPlay(gui,game, Reds.qb, Reds.wr, Blues.cb, Blues.dt));
                ball += (int) yardageGain;
                if (ball > 100){
                    gui.setLastPlay(Reds.qb.name + " touchdown throw to " + Reds.wr.name + "!");
                    Reds.qb.td++;
                    Reds.wr.td++;
                    Redscore += 7;
                    flipPosessions();
                    ball = 20;
                    playPicked = false;
                }

            }
            else if (inputter.equals("punt") && playPicked == true){
                simulator.punt(gui,game);
                flipPosessions();
                playPicked = false;
            }

            else if (inputter.equals("fg") && playPicked == true){
                if(simulator.fieldGoal(gui, game)){
                    Redscore += 3;
                }
                flipPosessions();
                ball = 20;
                playPicked = false;
            }
            else if (inputter.equals("endgame") && playPicked == true){
                endGame();
                playPicked = false;
            }
            postPlay(17, gui);
        }

    }
    public void redPosession(Game game, GameUI gui){
        down = 1;
        togo = 10;
        gui.setPosessionIndicator(Reds.name + " ball!");
        printScore(gui);
        gui.repaint();
        while(gameOver() && RedBall){
            yardageGain = 0;
            liveStats(gui);
            if(inputter.equals("run") && playPicked == true){
                yardageGain = (simulator.runPlay(gui,game, Reds.rb,Blues.lb, Blues.dt, Blues.cb));
                ball += (int) yardageGain;
                postPlay(17, gui);
                if (ball > 100){
                    gui.setLastPlay("Touchdown rush by " + Reds.rb.name+"!");
                    Redscore += 7;
                    Reds.rb.td++;
                    flipPosessions();
                    ball = 20;
                }
                else if (ball < 0){
                    gui.setLastPlay("Safety by " + Blues.dt.name + "!");
                    Bluescore += 2;
                    flipPosessions();
                    ball = 30;
                }
                playPicked = false;

            }
            else if(inputter.equals("pass") && playPicked == true){
                yardageGain = (simulator.passPlay(gui,game, Reds.qb, Reds.wr, Blues.cb, Blues.dt));
                ball += (int) yardageGain;
                if (ball > 100){
                    gui.setLastPlay(Reds.qb.name + " touchdown throw to " + Reds.wr.name + "!");
                    Reds.qb.td++;
                    Reds.wr.td++;
                    Redscore += 7;
                    flipPosessions();
                    ball = 20;
                }
                playPicked = false;
            }
            else if (inputter.equals("punt") && playPicked == true){
                simulator.punt(gui,game);
                flipPosessions();
                playPicked = false;
            }
            else if (inputter.equals("fg") && playPicked == true){
                if(simulator.fieldGoal(gui, game)){
                    Redscore += 3;
                }
                flipPosessions();
                ball = 20;
                playPicked = false;
            }
            else if (inputter.equals("endgame") && playPicked == true){
                endGame();
                playPicked = false;
            }
        }
        postPlay(17, gui);
    }
    public void bluePossessionAI(Game game, GameUI gui){
        down = 1;
        togo = 10;
        gui.setPosessionIndicator(game.Blues.name + " Ball!");
        printScore(gui);
        while(gameOver() && BlueBall){
            yardageGain = 0;
            liveStats(gui);
            inputter = AI.pickPlay(game, gameClock,Redscore,Bluescore,down,togo,ball);
            postPlay(17, gui);
        }

    }

    public void bluePosession(Game game, GameUI gui){
        down = 1;
        togo = 10;
        gui.setPosessionIndicator(Blues.name + " ball!");
        printScore(gui);
        while(gameOver() && BlueBall){
            yardageGain = 0;
            liveStats(gui);
            if(inputter.equals("run") && playPicked == true){
                yardageGain = (simulator.runPlay(gui,game, Blues.rb,Reds.lb, Reds.dt, Reds.cb));
                ball += (int) yardageGain;
                postPlay(17, gui);
                if (ball > 100){
                    gui.setLastPlay("Touchdown rush by " + Blues.rb.name+"!");
                    Bluescore += 7;
                    Blues.rb.td++;
                    flipPosessions();
                    ball = 20;
                }
                else if (ball < 0){
                    gui.setLastPlay("Safety by " + Reds.dt.name + "!");
                    Redscore += 2;
                    flipPosessions();
                    ball = 30;
                }
                playPicked = false;

            }
            else if(inputter.equals("pass") && playPicked == true){
                yardageGain = (simulator.passPlay(gui,game, Blues.qb, Blues.wr, Reds.cb, Reds.dt));
                ball += (int) yardageGain;
                if (ball > 100){
                    gui.setLastPlay(Blues.qb.name + " touchdown throw to " + Blues.wr.name + "!");
                    Blues.qb.td++;
                    Blues.wr.td++;
                    Bluescore += 7;
                    flipPosessions();
                    ball = 20;
                }
                playPicked = false;
            }
            else if (inputter.equals("punt") && playPicked == true){
                simulator.punt(gui,game);
                flipPosessions();
                playPicked = false;
            }
            else if (inputter.equals("fg") && playPicked == true){
                if(simulator.fieldGoal(gui, game)){
                    Bluescore += 3;
                }
                flipPosessions();
                ball = 20;
                playPicked = false;
            }
            else if (inputter.equals("endgame") && playPicked == true){
                endGame();
                playPicked = false;
            }
        }
        postPlay(17, gui);
    }
    public void flipPosessions(){
        RedBall = !RedBall;
        BlueBall = !BlueBall;
        if(hasBall == Reds){
            hasBall = Blues;
            defense = Reds;
        }
        else{
            hasBall = Reds;
            defense = Blues;
        }

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
    public void debug2(GameUI gui){
        gui.setDebug2("This works please");
    }



}
