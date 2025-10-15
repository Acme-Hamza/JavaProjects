
import java.awt.*;
import javax.swing.*;
import javax.swing.SwingConstants;
import java.util.Random;
// import static javax.swing.SwingConstants.NORTH_WEST;


public class RockPaperScissorGUI extends JFrame{
    Random random = new Random();
    private int playerChoice = -1; // -1 indicates no choice made yet
    private boolean confirmChoice = false;
    public int playerScore = 0;
    public int computerScore = 0;


    public RockPaperScissorGUI() {
        setTitle("Rock Paper Scissors Game");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

    // Layout: welcome at top, result & score center, buttons at bottom
    JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

    JLabel label = new JLabel("Welcome to Rock Paper Scissors!");
    label.setVerticalAlignment(SwingConstants.TOP);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setFont(label.getFont().deriveFont(Font.BOLD, 20f));

    // Result and score area (stacked)
    JLabel resultLabel = new JLabel("Make your choice and confirm!");
    resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
    resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel Score = new JLabel("<html>" + "Player Score: " + playerScore + "<br/>" + " Computer Score: " + computerScore + "</html>");
    Score.setHorizontalAlignment(SwingConstants.CENTER);
    Score.setAlignmentX(Component.CENTER_ALIGNMENT);

    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
    centerPanel.add(Box.createVerticalStrut(10));
    centerPanel.add(resultLabel);
    centerPanel.add(Box.createVerticalStrut(8));
    centerPanel.add(Score);

    // Buttons for choices (bottom)
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 12));
    JButton rockButton = new JButton("Rock");
    JButton paperButton = new JButton("Paper");
    JButton scissorsButton = new JButton("Scissors");
    JButton confirmButton = new JButton("Confirm Choice");
    buttonPanel.add(rockButton);
    buttonPanel.add(paperButton);
    buttonPanel.add(scissorsButton);
    buttonPanel.add(confirmButton);

        // Add action listeners to buttons (functionality to be implemented)
        rockButton.addActionListener(e -> playerChoice = 0);
        paperButton.addActionListener(e -> playerChoice = 1);
        scissorsButton.addActionListener(e -> playerChoice = 2);
        confirmButton.addActionListener(e -> {
            // Ensure player picked something
            if (playerChoice < 0) {
                resultLabel.setText("Please choose Rock, Paper or Scissors before confirming.");
                return;
            }
            confirmChoice = true;
            int randomNumber = random.nextInt(3); // 0, 1, or 2
            String[] choices = {"Rock", "Paper", "Scissors"};
            String computerChoice = choices[randomNumber];
            String playerChoiceStr = choices[playerChoice];
            String result;
            if (playerChoice == randomNumber) {
                result = "It's a tie!";
            } else if ((playerChoice == 0 && randomNumber == 2) ||
                       (playerChoice == 1 && randomNumber == 0) ||
                       (playerChoice == 2 && randomNumber == 1)) {
                result = "You win!";
                playerScore++;
            } else {
                result = "Computer wins!";
                computerScore++;
            }
            resultLabel.setText("You chose " + playerChoiceStr + ". Computer chose " + computerChoice + ". " + result);
            Score.setText("<html>" + "Player Score: " + playerScore + "<br/>" + " Computer Score: " + computerScore + "</html>");
            confirmChoice = false; // Reset for next round
        });


    mainPanel.add(label, BorderLayout.NORTH);
    mainPanel.add(centerPanel, BorderLayout.CENTER);
    mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    add(mainPanel);
        
        setVisible(true);
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

}