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
    private JButton SimPlay;
    private JList RedsRBList;
    private JList BluesRBList;
    private JList RedsWRList;
    private JList BluesWRList;
    static Game game = new Game();
    static GameUI gui = new GameUI("Java Football sim :(", game);
    public GameUI(String title, Game game){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainWindow);
        this.pack();
        EndGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.endGame();
            }
        });
        Debug1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        FG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fieldGoal();
            }
        });
        Run.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RunPlay(game.hasBall.rb);
            }
        });
        Pass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passPlay();
            }
        });
        Punt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                punt();
            }
        });
        SimPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String temp;
                if(game.hasBall == game.Blues){
                    temp = AI.pickPlay(game, game.gameClock, game.Bluescore,game.Redscore,game.down,game.togo,game.ball);
                }
                else{
                    temp = AI.pickPlay(game, game.gameClock, game.Redscore,game.Bluescore,game.down,game.togo,game.ball);
                }
                if(temp.equals("run")){
                    RunPlay((runningBack) player.randomPlayer(new runningBack[]{game.hasBall.rb, game.hasBall.rb2}));
                }
                else if(temp.equals("pass")){
                    passPlay();
                }
                else if(temp.equals("fg")){
                    fieldGoal();
                }
                else if(temp.equals("punt")){
                    punt();
                }

            }
        });
        EndGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.gameClock = -10;
                game.quarter = 5;
                gameOver(game);
                game.endGame();
            }
        });
    }
    public static void main(String[] args){
        playBothSides("default");
    }
    public static void playBothSides(String teams){
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        if(teams.equals("default")){
            ImportTeams.importDefaultTeams(game.Reds, game.Blues);
        }
        gui.setTables();
        game.ball = 20;
        while(game.inGame){
            game.posession(game, gui);
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
    public void setDebug2(){

    }
    public void gameOver(Game game){
        if(game.gameClock < 0 && game.quarter >= 4){
            if(game.Bluescore > game.Redscore){
                game.winner = game.Blues;
            }
            else if(game.Redscore > game.Bluescore){
                game.winner = game.Reds;
            }
            else{
                game.winner = null;
            }
            PostGame pg = new PostGame();
            this.setVisible(false);
            pg.setVisible(true);
            pg.setPostGame(game);
            pg.setStats(game);
            game.inGame = false;

        }
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
    public void RunPlay(runningBack rb){
        runningBack targetRB;
        targetRB = rb;
        gameOver(game);
        if(game.hasBall == game.Reds){
            if(RedsRBList.getSelectedIndex()==1){
                targetRB = game.Reds.rb2;
            }
            else{
                targetRB = game.Reds.rb;
            }
        }
        else{
            if(BluesRBList.getSelectedIndex()==1){
                targetRB = game.Blues.rb2;
            }
            else{
                targetRB = game.Blues.rb;
            }
        }
        game.yardageGain = (simulator.runPlay(gui,game, targetRB,game.defense.lb, game.defense.dt, game.defense.cb));
        game.ball += (int) game.yardageGain;
        game.postPlay(17, gui);
        if (game.ball > 100){
            gui.setLastPlay("Touchdown rush by " + game.hasBall.rb.name+"!");
            if(game.hasBall == game.Blues){
                game.Bluescore += 7;
                targetRB.td++;
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
    public void passPlay(){
        wideReciever targetWR;
        targetWR = game.hasBall.wr;
        gameOver(game);
        if(game.Reds==game.hasBall){

            if(RedsWRList.getSelectedIndex()==1){
                targetWR = game.Reds.wr2;
            }
            else{
                targetWR = game.Reds.wr;
            }
        }
        else if(game.Blues==game.hasBall){
            if(BluesWRList.getSelectedIndex()==1){
                targetWR = game.Blues.wr2;
            }
            else{
                targetWR = game.Blues.wr;
            }
        }
        game.yardageGain = (simulator.passPlay(gui,game, game.hasBall.qb, targetWR, game.defense.cb, game.defense.dt));
        game.ball += (int) game.yardageGain;
        game.postPlay(17, gui);
        if (game.ball > 100){
            gui.setLastPlay(game.hasBall.qb.name + " touchdown throw to " + game.hasBall.wr.name + "!");
            game.hasBall.qb.td++;
            targetWR.td++;
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
    public void punt(){
        gameOver(game);
        simulator.punt(gui, game);
        game.flipPosessions();
        setGraphics();
    }
    public void fieldGoal(){
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
        setGraphics();
    }
    public void setTables(){
        RedsRBList.setListData(new String[] {game.Reds.rb.name,game.Reds.rb2.name});
        RedsWRList.setListData(new String[] {game.Reds.wr.name, game.Reds.wr2.name});
        BluesRBList.setListData(new String[] {game.Blues.rb.name, game.Blues.rb2.name});
        BluesWRList.setListData(new String[] {game.Blues.wr.name, game.Blues.wr2.name});
    }
}
