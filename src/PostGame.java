import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PostGame extends JFrame{

    private JPanel PostGame;
    private JTable passingStats;
    private JLabel GameScore;
    private JTable rushingStats;
    private JTable recievingStats;
    private JTable defensiveStats;
    public PostGame(){
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PostGame);
        this.pack();
    }
    public static void main(String[] args){
        JFrame window = new PostGame();
        window.setVisible(true);
    }
    public void setPostGame(Game game){
        if(game.winner==null){
            GameScore.setText("Tie " + game.Bluescore + " to " + game.Redscore);
        }
        else{
            GameScore.setText(game.winner.name + " wins " + game.Bluescore + " to " + game.Redscore);
        }
    }
    public void setStats(Game game){
        String[][] passStats = {
                {"team", "Name", "Completions", "Attempts","Yards", "Touchdowns", "Interceptions", "YPA", "Completion Percentage"},
                {game.Blues.name, game.Blues.qb.name, String.valueOf(game.Blues.qb.completions),String.valueOf(game.Blues.qb.attempts), String.valueOf(game.Blues.qb.yards), String.valueOf(game.Blues.qb.td), String.valueOf(game.Blues.qb.interceptions), String.valueOf(game.Blues.qb.yards/game.Blues.qb.attempts), String.valueOf(100*game.Blues.qb.completions/game.Blues.qb.attempts)},
                {game.Reds.name, game.Reds.qb.name, String.valueOf(game.Reds.qb.completions), String.valueOf(game.Reds.qb.attempts),String.valueOf(game.Reds.qb.yards), String.valueOf(game.Reds.qb.td), String.valueOf(game.Reds.qb.interceptions), String.valueOf(game.Reds.qb.yards/game.Reds.qb.attempts), String.valueOf(100*game.Reds.qb.completions/game.Reds.qb.attempts)}
        };
        String[][] rushStats = {
                {"team","Name", "Attempts", "Yards", "YPA","Touchdowns"},
                {game.Blues.name, game.Blues.rb.name,String.valueOf(game.Blues.rb.attempts), String.valueOf(game.Blues.rb.yards), String.valueOf(game.Blues.rb.yards/game.Blues.rb.attempts)},
                {game.Reds.name,game.Reds.rb.name,String.valueOf(game.Reds.rb.attempts), String.valueOf(game.Reds.rb.yards), String.valueOf(game.Reds.rb.yards/game.Reds.rb.attempts)},
                {game.Blues.name, game.Blues.rb2.name,String.valueOf(game.Blues.rb2.attempts), String.valueOf(game.Blues.rb2.yards), String.valueOf(game.Blues.rb2.yards/game.Blues.rb2.attempts)},
                {game.Reds.name,game.Reds.rb2.name,String.valueOf(game.Reds.rb2.attempts), String.valueOf(game.Reds.rb2.yards), String.valueOf(game.Reds.rb2.yards/game.Reds.rb2.attempts)},
                {game.Blues.name, game.Blues.rb3.name,String.valueOf(game.Blues.rb3.attempts), String.valueOf(game.Blues.rb3.yards), String.valueOf(game.Blues.rb3.yards/game.Blues.rb3.attempts)},
                {game.Reds.name,game.Reds.rb3.name,String.valueOf(game.Reds.rb3.attempts), String.valueOf(game.Reds.rb3.yards), String.valueOf(game.Reds.rb3.yards/game.Reds.rb3.attempts)},
                {game.Blues.name,game.Blues.qb.name,String.valueOf(game.Blues.qb.attempts),String.valueOf(game.Blues.qb.yards), String.valueOf(game.Blues.qb.yards/game.Blues.qb.attempts)},
                {game.Blues.name,game.Blues.qb.name,String.valueOf(game.Reds.qb.attempts),String.valueOf(game.Reds.qb.yards), String.valueOf(game.Reds.qb.yards/game.Reds.qb.attempts)}
        };
        String [][] recieveStats = {
                {"team","Name", "Catches", "Yards", "Touchdowns"},
                {game.Blues.name, game.Blues.wr.name, String.valueOf(game.Blues.wr.receptions), String.valueOf(game.Blues.wr.yards), String.valueOf(game.Blues.wr.td)},
                {game.Reds.name, game.Reds.wr.name, String.valueOf(game.Reds.wr.receptions), String.valueOf(game.Reds.wr.yards), String.valueOf(game.Reds.wr.td)},
                {game.Blues.name, game.Blues.wr2.name, String.valueOf(game.Blues.wr2.receptions), String.valueOf(game.Blues.wr2.yards), String.valueOf(game.Blues.wr2.td)},
                {game.Reds.name, game.Reds.wr2.name, String.valueOf(game.Reds.wr2.receptions), String.valueOf(game.Reds.wr2.yards), String.valueOf(game.Reds.wr2.td)},
                {game.Blues.name, game.Blues.wr3.name, String.valueOf(game.Blues.wr3.receptions), String.valueOf(game.Blues.wr3.yards), String.valueOf(game.Blues.wr3.td)},
                {game.Reds.name, game.Reds.wr3.name, String.valueOf(game.Reds.wr3.receptions), String.valueOf(game.Reds.wr3.yards), String.valueOf(game.Reds.wr3.td)},
                {game.Blues.name, game.Blues.wr4.name, String.valueOf(game.Blues.wr4.receptions), String.valueOf(game.Blues.wr4.yards), String.valueOf(game.Blues.wr4.td)},
                {game.Reds.name, game.Reds.wr4.name, String.valueOf(game.Reds.wr4.receptions), String.valueOf(game.Reds.wr4.yards), String.valueOf(game.Reds.wr4.td)},
                {game.Blues.name, game.Blues.wr5.name, String.valueOf(game.Blues.wr5.receptions), String.valueOf(game.Blues.wr5.yards), String.valueOf(game.Blues.wr5.td)},
                {game.Reds.name, game.Reds.wr5.name, String.valueOf(game.Reds.wr5.receptions), String.valueOf(game.Reds.wr5.yards), String.valueOf(game.Reds.wr5.td)},
                {game.Blues.name, game.Blues.wr6.name, String.valueOf(game.Blues.wr6.receptions), String.valueOf(game.Blues.wr6.yards), String.valueOf(game.Blues.wr6.td)},
                {game.Reds.name, game.Reds.wr6.name, String.valueOf(game.Reds.wr6.receptions), String.valueOf(game.Reds.wr6.yards), String.valueOf(game.Reds.wr6.td)},
        };
        String [][] defenceStats = {
                {"team","Name", "Tackles","TFLs", "Sacks", "Deflections", "Interceptions"},
                {game.Blues.name, game.Blues.lb.name, String.valueOf(game.Blues.lb.tackles),"","","",""},
                {game.Blues.name, game.Blues.dt.name, "", String.valueOf(game.Blues.dt.tfl), String.valueOf(game.Blues.dt.sack), "", ""},
                {game.Blues.name, game.Blues.cb.name, "","","",String.valueOf(game.Blues.cb.passdefelctions), String.valueOf(game.Blues.cb.interceptions)},
                {game.Reds.name, game.Reds.lb.name, String.valueOf(game.Reds.lb.tackles),"","","",""},
                {game.Reds.name, game.Reds.dt.name, "", String.valueOf(game.Reds.dt.tfl), String.valueOf(game.Reds.dt.sack), "", ""},
                {game.Reds.name, game.Reds.cb.name, "","","",String.valueOf(game.Reds.cb.passdefelctions), String.valueOf(game.Reds.cb.interceptions)}

        };
        DefaultTableModel passing = new DefaultTableModel();
        DefaultTableModel rushing = new DefaultTableModel();
        DefaultTableModel recieving = new DefaultTableModel();
        DefaultTableModel defense = new DefaultTableModel();
        setTable(passing,passStats, passingStats);
        setTable(rushing,rushStats, rushingStats);
        setTable(recieving,recieveStats, recievingStats);
        setTable(defense,defenceStats, defensiveStats);

    }
    public void setTable(DefaultTableModel passing, String[][] passStats, JTable passingStats){
        passing.setColumnCount(passStats[0].length);
        passing.setRowCount(passStats.length);
        for(int i = 0; i < passStats.length; i++){
            for(int j = 0; j < passStats[i].length; j++){
                passing.setValueAt(passStats[i][j],i,j);
            }
        }
        passingStats.setModel(passing);
    }

}
