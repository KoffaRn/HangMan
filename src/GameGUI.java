import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class GameGUI  extends JFrame {
    private JLabel txtGuessField;
    private JLabel lblWordState;
    private JButton btnGuess;
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton newGameButton;
    private JLabel lblMessage;
    private JButton btnAddWord;

    public GameGUI(Game game) {
        setContentPane(mainPanel);
        setTitle("Hangman");
        setSize(400, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(game.player == null) {
                    new NewPlayer(game);
                }
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.newGame();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.guiGuess(txtGuessField.getText());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    void printMsg(String msg) {
        lblMessage.setText(msg);
    }
    void updateWordState(String str) {
        lblWordState.setText(str);
    }
}
