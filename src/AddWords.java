import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class AddWords extends JFrame {
    private JPanel panel1;
    private JTextField txtWordAdd;
    private JButton btnAddWord;
    private JButton btnAddDict;
    public AddWords(Game game) {
        setContentPane(panel1);
        setSize(300,150);
        setTitle("Add a word");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        btnAddDict.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.wl.addDict();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnAddWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.wl.addToList(txtWordAdd.getText());
            }
        });
    }
}
