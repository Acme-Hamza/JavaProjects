
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RockPaperScissorGUI rockPaperScissorGUI = new RockPaperScissorGUI();
            
            
            // display the GUI
            rockPaperScissorGUI.setVisible(true);
        });
    }
}