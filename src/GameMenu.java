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
    public GameMenu(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainWindow);
        this.pack();
        BothSides.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getSelectedHomeTeam();
                getSelectedAwayTeam();
                GameUI.playBothSides("default");
            }
        });
    }
    public static void main(String[] args){
        JFrame window = new GameMenu("Java Football Simulator");
        window.setVisible(true);
        ((GameMenu) window).initializeMenu();
    }
    public void initializeMenu(){
        HomeTeam.setListData(new String[] {
			"Bills","Dolphins","Patriots","Jets",
			"Ravens","Bengals","Browns","Steelers",
			"Texans","Colts","Jaguars","Titans",
			"Broncos","Chiefs","Raiders","Chargers",
			"Cowboys","Giants","Eagles","Redskins",
			"Bears","Lions","Packers","Vikings",
			"Falcons","Panthers","Saints","Buccaneers"
			,"Cardinals","Rams","49ers","Seahawks"}
        );
        AwayTeam.setListData(new String[]{
            "Bills","Dolphins","Patriots","Jets",
            "Ravens","Bengals","Browns","Steelers",
            "Texans","Colts","Jaguars","Titans",
            "Broncos","Chiefs","Raiders","Chargers",
            "Cowboys","Giants","Eagles","Redskins",
            "Bears","Lions","Packers","Vikings",
            "Falcons","Panthers","Saints","Buccaneers"
            ,"Cardinals","Rams","49ers","Seahawks"}
        );    
    }
    public void getSelectedAwayTeam(){

    }
    public void getSelectedHomeTeam(){
        
    }

}
