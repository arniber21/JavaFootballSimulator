import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public boolean inGame;
    team Reds = new team();
    team Blues = new team();
    int Redscore = 0;
    int Bluescore = 0;
    team winner;
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
        for (team team : Arrays.asList(Reds, Blues)) {
            team.qb.printStats();
            team.rb.printStats();
            team.wr.printStats();
            team.dt.printStats();
            team.lb.printStats();
            team.cb.printStats();
        }


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
    public void posession(Game game, GameUI gui){
        down = 1;
        togo = 10;
        gui.setPosessionIndicator(hasBall.name + " ball!");
        printScore(gui);
        gui.repaint();
        while(gameOver() && RedBall){
            yardageGain = 0;
            liveStats(gui);
            if(inputter.equals("run") && playPicked){
                yardageGain = (simulator.runPlay(gui,game, hasBall.rb,defense.lb, defense.dt, defense.cb));
                ball += (int) yardageGain;
                postPlay(17, gui);
                if (ball > 100){
                    gui.setLastPlay("Touchdown rush by " + hasBall.rb.name+"!");
                    if(hasBall == Blues){
                        Bluescore += 7;
                    }
                    else{
                        Redscore += 7;
                    }
                    hasBall.rb.td++;
                    flipPosessions();
                    ball = 20;
                }
                else if (ball < 0){
                    gui.setLastPlay("Safety by " + defense.dt.name + "!");
                    if(hasBall == Blues){
                        Bluescore += 2;
                    }
                    else{
                        Redscore += 2;
                    }
                    flipPosessions();
                    ball = 30;
                }
                playPicked = false;

            }
            else if(inputter.equals("pass") && playPicked){
                yardageGain = (simulator.passPlay(gui,game, hasBall.qb, hasBall.wr, defense.cb, defense.dt));
                ball += (int) yardageGain;
                if (ball > 100){
                    gui.setLastPlay(hasBall.qb.name + " touchdown throw to " + hasBall.wr.name + "!");
                    hasBall.qb.td++;
                    hasBall.wr.td++;
                    if(hasBall == Blues){
                        Bluescore += 7;
                    }
                    else{
                        Redscore += 7;
                    }
                    flipPosessions();
                    ball = 20;
                }
                playPicked = false;
            }
            else if (inputter.equals("punt") && playPicked){
                simulator.punt(gui,game);
                flipPosessions();
                playPicked = false;
            }
            else if (inputter.equals("fg") && playPicked){
                if(simulator.fieldGoal(gui, game)){
                    if(hasBall == Blues){
                        Bluescore += 3;
                    }
                    else{
                        Redscore += 3;
                    }
                }
                flipPosessions();
                ball = 20;
            }
            else if (inputter.equals("endgame") && playPicked){
                endGame();
            }
        }
        postPlay(17, gui);
    }
    public void possessionAI(Game game, GameUI gui){
        down = 1;
        togo = 10;
        gui.setPosessionIndicator(game.hasBall.name + " Ball!");
        printScore(gui);
        while(gameOver() && RedBall){
            yardageGain = 0;
            liveStats(gui);
            if(hasBall == Blues){
                inputter = AI.pickPlay(game, gameClock,Bluescore,Redscore,down,togo,ball);
            }
            else{
                inputter = AI.pickPlay(game, gameClock,Redscore,Bluescore,down,togo,ball);
            }

            System.out.println(inputter);
            if(inputter.equals("run") && playPicked){
                yardageGain = (simulator.runPlay(gui,game, hasBall.rb,defense.lb, defense.dt, defense.cb));
                ball += (int) yardageGain;
                postPlay(17, gui);
                if (ball > 100){
                    gui.setLastPlay("Touchdown rush by " + hasBall.rb.name+"!");
                    if(hasBall == Blues){
                        Bluescore += 7;
                    }
                    else{
                        Redscore += 7;
                    }
                    hasBall.rb.td++;
                    flipPosessions();
                    ball = 20;
                }
                else if (ball < 0){
                    gui.setLastPlay("Safety by " + defense.dt.name + "!");
                    if(hasBall == Blues){
                        Bluescore += 2;
                    }
                    else{
                        Redscore += 2;
                    }
                    flipPosessions();
                    ball = 30;
                }
                playPicked = false;

            }
            else if(inputter.equals("pass") && playPicked){
                yardageGain = (simulator.passPlay(gui,game, hasBall.qb, hasBall.wr, defense.cb, defense.dt));
                ball += (int) yardageGain;
                if (ball > 100){
                    gui.setLastPlay(hasBall.qb.name + " touchdown throw to " + hasBall.wr.name + "!");
                    hasBall.qb.td++;
                    hasBall.wr.td++;
                    if(hasBall == Blues){
                        Bluescore += 7;
                    }
                    else{
                        Redscore += 7;
                    }
                    flipPosessions();
                    ball = 20;
                    playPicked = false;
                }

            }
            else if (inputter.equals("punt") && playPicked){
                simulator.punt(gui,game);
                flipPosessions();
                playPicked = false;
            }

            else if (inputter.equals("fg") && playPicked){
                if(simulator.fieldGoal(gui, game)){
                    if(hasBall == Blues){
                        Bluescore += 3;
                    }
                    else{
                        Redscore += 3;
                    }
                }
                flipPosessions();
                ball = 20;
                playPicked = false;
            }
            else if (inputter.equals("endgame") && playPicked){
                endGame();
                playPicked = false;
            }
            postPlay(17, gui);
        }

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
        if(Bluescore > Redscore){
            winner = Blues;
        }
        else if(Redscore > Bluescore){
            winner = Reds;
        }
        else{
            winner = null;
        }
        PostGame pg = new PostGame();
        pg.setPostGame(this);
        pg.setStats(this);
        inGame = false;
        printStats();
    }




}
