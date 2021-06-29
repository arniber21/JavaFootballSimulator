import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame{
    private JPanel mainWindow;
    private JLabel Title;
    private JButton BothSides;
    private JList HomeTeam;
    private JList AwayTeam;
    private JButton SimGame;
    private team HomeSelectedTeam;
    private team AwaySelectedTeam;
    private String[] teamList = {
            "Bills","Dolphins","Patriots","Jets",
            "Ravens","Bengals","Browns","Steelers",
            "Texans","Colts","Jaguars","Titans",
            "Broncos","Chiefs","Raiders","Chargers",
            "Cowboys","Giants","Eagles","Redskins",
            "Bears","Lions","Packers","Vikings",
            "Falcons","Panthers","Saints","Buccaneers"
            ,"Cardinals","Rams","49ers","Seahawks"};
    public GameMenu(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainWindow);
        this.pack();
        BothSides.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game game = new Game();
                game.Blues = getSelectedAwayTeam();
                game.Reds = getSelectedHomeTeam();
                GameUI GameGUI = new GameUI("Java Football Sim", game);
                GameGUI.setVisible(true);
                GameGUI.playBothSides("default");
            }
        });
    }
    public static void main(String[] args){
        JFrame window = new GameMenu("Java Football Simulator");
        window.setVisible(true);
        ((GameMenu) window).initializeMenu();
    }
    public void initializeMenu(){
        HomeTeam.setListData(teamList);
        AwayTeam.setListData(teamList);
    }
    public team getSelectedAwayTeam(){
        team Team = new team();
        if(AwayTeam.isSelectionEmpty()){
            Team.name = "Buccaneers";
        }
        else {
            Team.name = teamList[AwayTeam.getSelectedIndex()];
        }

        return Team;
    }
    public team getSelectedHomeTeam(){
        team Team = new team();
        if(AwayTeam.isSelectionEmpty()){
            Team.name = "Patriots";
        }
        else {
            Team.name = teamList[HomeTeam.getSelectedIndex()];
        }
        return Team;
    }

}
