import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame{
    private JPanel mainWindow;
    private JLabel Title;
    private JButton BothSides;
    private JButton OneSide;
    private JButton SimGame;
    private JButton SimSeason;
    private JButton GenerationSim;

    public GameMenu(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainWindow);
        this.pack();
        BothSides.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game game = new Game();
                ImportTeams.initializeTeam(game.Reds, "Reds","Tom Brady", "Leonard Fournette", "Mike Evans", "Lavonte David", "Ndamukong Suh", "Carlton Davis");
                ImportTeams.initializeTeam(game.Blues, "Blues","Mac Jones", "Damien Harris", "Nelson Agholor", "Donta Hightower", "Vince Wilfork", "Stephon Gilmore");
                game.ball = 20;
                game.Reds.name = "Reds";
                game.Blues.name = "Blues";
                GameUI gui = new GameUI("not funny", game);
                mainWindow.setVisible(false);
                gui.setVisible(true);
            }
        });
    }
    public static void main(String[] args){
        JFrame window = new GameMenu("Java Football Simulator");
        window.setVisible(true);
    }
}
