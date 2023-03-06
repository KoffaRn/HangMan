import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements ActionListener {
    private Game game; // a reference to your Game object
    private JPanel mainMenuPanel; // a panel for the main menu
    private JPanel gameMenuPanel; // a panel for the game menu
    private JLabel messageLabel; // a label for displaying messages
    private JLabel wordLabel; // a label for displaying the word state
    private JLabel guessedLettersLabel; // a label for displaying the guessed letters
    private JButton newGameButton; // a button for starting a new game
    private JButton guessLetterButton; // a button for guessing a letter
    private JButton guessWordButton; // a button for guessing a word
    private JTextField letterField; // a text field for entering a letter
    private JTextField wordField; // a text field for entering a word

    public GUI(Game game) {
        this.game = game; // assign the Game object to the field

        this.setSize(500, 500); // set the size of the frame
        this.setTitle("Hangman"); // set the title of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set what happens when you close the frame

        mainMenuPanel = new JPanel(); // create a new panel for the main menu
        gameMenuPanel = new JPanel(); // create another panel for the game menu

        messageLabel = new JLabel("Welcome to Hangman!"); // create a new label with some text
        wordLabel = new JLabel(""); // create another label with empty text
        guessedLettersLabel = new JLabel(""); // create another label with empty text

        newGameButton = new JButton("New Game");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}