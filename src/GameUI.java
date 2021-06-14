import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI extends JFrame{
    private JPanel mainWindow;
    private JButton EndGame;
    private JButton FG;
    private JButton Run;
    private JButton Pass;
    private JButton Punt;
    private JLabel StatusBar;
    private JLabel LastPlay;
    private JLabel PosessionIndicator;
    private JLabel Scoreboard;
    private JLabel Clock;
    private JButton Debug1;
    private JButton Debug2;
    static Game game = new Game();
    static GameUI gui = new GameUI("Java Football sim :(", game);
    public GameUI(String title, Game game){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainWindow);
        this.pack();
        EndGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.sendInput("endgame");
                game.playPicked = true;
            }
        });
        Debug1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        FG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(simulator.fieldGoal(gui, game)){
                    if(game.hasBall == game.Blues){
                        game.Bluescore += 3;
                    }
                    else{
                        game.Redscore += 3;
                    }
                    game.flipPosessions();
                    game.ball = 20;
                }
            }
        });
        Run.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.yardageGain = (simulator.runPlay(gui,game, game.hasBall.rb,game.defense.lb, game.defense.dt, game.defense.cb));
                game.ball += (int) game.yardageGain;
                game.postPlay(17, gui);
                if (game.ball > 100){
                    gui.setLastPlay("Touchdown rush by " + game.hasBall.rb.name+"!");
                    if(game.hasBall == game.Blues){
                        game.Bluescore += 7;
                        game.Blues.rb.td++;
                    }
                    else{
                        game.Redscore += 7;
                    }

                    game.flipPosessions();
                    game.ball = 20;
                }
                else if (game.ball < 0){
                    gui.setLastPlay("Safety by " + game.defense.dt.name + "!");
                    if(game.defense == game.Reds){
                        game.Redscore += 2;

                    }
                    else{
                        game.Bluescore += 2;
                    }
                    game.flipPosessions();
                    game.ball = 30;
                }
                setGraphics();
            }
        });
        Pass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.yardageGain = (simulator.passPlay(gui,game, game.hasBall.qb, game.hasBall.wr, game.defense.cb, game.defense.dt));
                game.ball += (int) game.yardageGain;
                game.postPlay(17, gui);
                if (game.ball > 100){
                    gui.setLastPlay(game.hasBall.qb.name + " touchdown throw to " + game.hasBall.wr.name + "!");
                    game.hasBall.qb.td++;
                    game.hasBall.wr.td++;
                    if (game.hasBall == game.Blues){
                        game.Bluescore += 7;
                    }
                    else{
                        game.Redscore += 7;
                    }

                    game.flipPosessions();
                    game.ball = 20;
                }
                setGraphics();
            }

        });
        Punt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simulator.punt(gui, game);
                game.flipPosessions();
            }
        });
        Debug2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Debug2.setText(":(");
            }
        });
        EndGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.endGame();
            }
        });
    }
    public static void main(String[] args){
        gui.setVisible(true);
        ImportTeams.initializeTeam(game.Reds, "Reds","Tom Brady", "Leonard Fournette", "Mike Evans", "Lavonte David", "Ndamukong Suh", "Carlton Davis");
        ImportTeams.initializeTeam(game.Blues, "Blues","Mac Jones", "Damien Harris", "Nelson Agholor", "Donta Hightower", "Vince Wilfork", "Stephon Gilmore");
        game.ball = 20;
        game.Reds.name = "Reds";
        game.Blues.name = "Blues";
        while(game.inGame){
            if (game.RedBall){
                game.redPosession(game, gui);
            }
            else{
                game.bluePosession(game, gui);
            }
        }
    }
    public void setScoreboard(String txt){
        Scoreboard.setText(txt);
    }
    public void setStatusBar(int down, int togo, String visualbar, int ball){
        StatusBar.setText(down + " and " + togo + "   " + visualbar + "   Ball:" + ball);
    }
    public void setLastPlay(String txt){
        LastPlay.setText(txt);
    }
    public void setPosessionIndicator(String txt){
        PosessionIndicator.setText(txt);
    }
    public void setDebug2(String text){
        Debug2.setText(text);
    }
    public void setGraphics(){
        gui.Clock.setText(((int)(game.gameClock/60))+":"+(game.gameClock%60)+" " + game.quarter + " quarter. ");
        gui.Scoreboard.setText(game.Reds.name + ": " + game.Redscore + "  |||  " + game.Blues.name + ":" + game.Bluescore);
        String[] visualBar = {"<", "=","=","=","=","=","=","=","=","=",">"};
        int ballIndex = ((int) game.ball/10);
        if (ballIndex > 10){
            ballIndex = 10;
        }
        else if (ballIndex < 0){
            ballIndex = 0;
        }
        visualBar[ballIndex] = "|";
        gui.setStatusBar(game.down,game.togo,String.join("=",visualBar),game.ball);
        gui.PosessionIndicator.setText(game.hasBall.name + " Ball");
    }
}
