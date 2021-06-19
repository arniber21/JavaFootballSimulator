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
                passPlay(game.hasBall.wr);
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
                    RunPlay((runningBack) player.randomPlayer(new runningBack[]{game.hasBall.rb, game.hasBall.rb2, game.hasBall.rb3}));
                }
                else if(temp.equals("pass")){
                    passPlay((wideReciever) player.randomPlayer(new wideReciever[]{game.hasBall.wr,game.hasBall.wr2,game.hasBall.wr3,game.hasBall.wr4,game.hasBall.wr5,game.hasBall.wr6}));
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
        setTables();
    }
    public void RunPlay(runningBack rb){
        runningBack targetRB;
        targetRB = rb;
        gameOver(game);
        if(game.hasBall == game.Reds){
            if(RedsRBList.getSelectedIndex()==1){
                targetRB = game.Reds.rb2;
                game.Reds.rb.stamina += 5;
                game.Reds.rb3.stamina += 5;
            }
            else if(RedsRBList.getSelectedIndex()==2){
                game.Reds.rb.stamina += 5;
                game.Reds.rb2.stamina += 5;
                targetRB = game.Reds.rb3;
            }
            else if(RedsRBList.getSelectedIndex()==0){
                game.Reds.rb3.stamina += 5;
                game.Reds.rb2.stamina += 5;
                targetRB = game.Reds.rb;
            }
        }
        else{
            if(BluesRBList.getSelectedIndex()==1){
                targetRB = game.Blues.rb2;
                game.Blues.rb.stamina += 5;
                game.Blues.rb3.stamina += 5;
            }
            else if(BluesRBList.getSelectedIndex()==2){
                game.Blues.rb.stamina += 5;
                game.Blues.rb2.stamina += 5;
                targetRB = game.Blues.rb3;
            }
            else if(BluesRBList.getSelectedIndex()==0){
                game.Blues.rb3.stamina += 5;
                game.Blues.rb2.stamina += 5;
                targetRB = game.Blues.rb;
            }
        }
        targetRB.elusive *= targetRB.stamina/100;
        targetRB.speed *= targetRB.stamina/100;
        targetRB.power *= targetRB.stamina/100;
        game.Reds.rb.setStamina();
        game.Reds.rb2.setStamina();
        game.Reds.rb3.setStamina();
        game.Blues.rb.setStamina();
        game.Blues.rb2.setStamina();
        game.Blues.rb3.setStamina();
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
    public void passPlay(wideReciever wr){
        wideReciever targetWR;
        targetWR = wr;
        gameOver(game);
        if(game.Reds==game.hasBall){

            if(RedsWRList.getSelectedIndex()==1){
                game.Reds.wr.stamina += 5;
                targetWR = game.Reds.wr2;
                game.Reds.wr3.stamina += 5;
                game.Reds.wr4.stamina += 5;
                game.Reds.wr5.stamina += 5;
                game.Reds.wr6.stamina += 5;
            }
            else if(RedsWRList.getSelectedIndex()==2){
                game.Reds.wr.stamina += 5;
                game.Reds.wr2.stamina += 5;
                targetWR  = game.Reds.wr3;
                game.Reds.wr4.stamina += 5;
                game.Reds.wr5.stamina += 5;
                game.Reds.wr6.stamina += 5;

            }
            else if(RedsWRList.getSelectedIndex()==3){
                game.Reds.wr.stamina += 5;
                game.Reds.wr2.stamina += 5;
                game.Reds.wr3.stamina += 5;
                targetWR  = game.Reds.wr4;
                game.Reds.wr5.stamina += 5;
                game.Reds.wr6.stamina += 5;

            }
            else if(RedsWRList.getSelectedIndex()==4){
                game.Reds.wr.stamina += 5;
                game.Reds.wr2.stamina += 5;
                game.Reds.wr3.stamina += 5;
                game.Reds.wr4.stamina += 5;
                targetWR  = game.Reds.wr5;
                game.Reds.wr6.stamina += 5;
            }
            else if(RedsWRList.getSelectedIndex()==5){
                game.Reds.wr.stamina += 5;
                game.Reds.wr2.stamina += 5;
                game.Reds.wr3.stamina += 5;
                game.Reds.wr4.stamina += 5;
                game.Reds.wr5.stamina += 5;
                targetWR  = game.Reds.wr6;
            }
            else if(RedsWRList.getSelectedIndex()==0){
                targetWR = game.Reds.wr;
                game.Reds.wr2.stamina += 5;
                game.Reds.wr3.stamina += 5;
                game.Reds.wr4.stamina += 5;
                game.Reds.wr5.stamina += 5;
                game.Reds.wr6.stamina += 5;
            }
        }
        else{
            if(BluesWRList.getSelectedIndex()==1){
                game.Blues.wr.stamina += 5;
                targetWR = game.Blues.wr2;
                game.Blues.wr3.stamina += 5;
                game.Blues.wr4.stamina += 5;
                game.Blues.wr5.stamina += 5;
                game.Blues.wr6.stamina += 5;
            }
            else if(BluesWRList.getSelectedIndex()==2){
                game.Blues.wr.stamina += 5;
                game.Blues.wr2.stamina += 5;
                targetWR  = game.Blues.wr3;
                game.Blues.wr4.stamina += 5;
                game.Blues.wr5.stamina += 5;
                game.Blues.wr6.stamina += 5;

            }
            else if(BluesWRList.getSelectedIndex()==3){
                game.Blues.wr.stamina += 5;
                game.Blues.wr2.stamina += 5;
                game.Blues.wr3.stamina += 5;
                targetWR  = game.Blues.wr4;
                game.Blues.wr5.stamina += 5;
                game.Blues.wr6.stamina += 5;

            }
            else if(BluesWRList.getSelectedIndex()==4){
                game.Blues.wr.stamina += 5;
                game.Blues.wr2.stamina += 5;
                game.Blues.wr3.stamina += 5;
                game.Blues.wr4.stamina += 5;
                targetWR  = game.Blues.wr5;
                game.Blues.wr6.stamina += 5;
            }
            else if(BluesWRList.getSelectedIndex()==5){
                game.Blues.wr.stamina += 5;
                game.Blues.wr2.stamina += 5;
                game.Blues.wr3.stamina += 5;
                game.Blues.wr4.stamina += 5;
                game.Blues.wr5.stamina += 5;
                targetWR  = game.Blues.wr6;
            }
            else if(BluesWRList.getSelectedIndex()==0){
                targetWR = game.Blues.wr;
                game.Blues.wr2.stamina += 5;
                game.Blues.wr3.stamina += 5;
                game.Blues.wr4.stamina += 5;
                game.Blues.wr5.stamina += 5;
                game.Blues.wr6.stamina += 5;
            }
        }
        targetWR.catching *= targetWR.stamina/100;
        targetWR.routerunning *= targetWR.stamina/100;
        game.Reds.wr.setStamina();
        game.Reds.wr2.setStamina();
        game.Reds.wr3.setStamina();
        game.Reds.wr4.setStamina();
        game.Reds.wr5.setStamina();
        game.Reds.wr6.setStamina();
        game.Blues.wr.setStamina();
        game.Blues.wr2.setStamina();
        game.Blues.wr3.setStamina();
        game.Blues.wr4.setStamina();
        game.Blues.wr5.setStamina();
        game.Blues.wr6.setStamina();
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
        RedsRBList.setListData(new String[] {(game.Reds.rb.name + "      Stamina: " + game.Reds.rb.stamina),game.Reds.rb2.name + "      Stamina: " + game.Reds.rb2.stamina, game.Reds.rb3.name + "      Stamina: " + game.Reds.rb3.stamina});
        RedsWRList.setListData(new String[] {game.Reds.wr.name + "      Stamina: " + game.Reds.wr.stamina, game.Reds.wr2.name + "      Stamina: " + game.Reds.wr2.stamina, game.Reds.wr3.name + "      Stamina: " + game.Reds.wr3.stamina, game.Reds.wr4.name + "      Stamina: " + game.Reds.wr4.stamina, game.Reds.wr5.name + "      Stamina: " + game.Reds.wr5.stamina, game.Reds.wr6.name + "      Stamina: " + game.Reds.wr6.stamina});
        BluesRBList.setListData(new String[] {(game.Blues.rb.name + "      Stamina: " + game.Blues.rb.stamina),game.Blues.rb2.name + "      Stamina: " + game.Blues.rb2.stamina, game.Blues.rb3.name + "      Stamina: " + game.Blues.rb3.stamina});
        BluesWRList.setListData(new String[] {game.Blues.wr.name + "      Stamina: " + game.Blues.wr.stamina, game.Blues.wr2.name + "      Stamina: " + game.Blues.wr2.stamina, game.Blues.wr3.name + "      Stamina: " + game.Blues.wr3.stamina, game.Blues.wr4.name + "      Stamina: " + game.Blues.wr4.stamina, game.Blues.wr5.name + "      Stamina: " + game.Blues.wr5.stamina, game.Blues.wr6.name + "      Stamina: " + game.Blues.wr6.stamina});
    }
}
