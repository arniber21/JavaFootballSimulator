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
                GameUI.playBothSides("default");
            }
        });
    }
    public static void main(String[] args){
        JFrame window = new GameMenu("Java Football Simulator");
        window.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
