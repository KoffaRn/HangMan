import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlayer extends JFrame {
    private JPanel newPlayerPanel;
    private JButton btnNewPlayer;
    private JTextField txtPlayerName;

    public NewPlayer(Game game) {
        setContentPane(newPlayerPanel);
        setSize(150, 150);
        setTitle("New player");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        btnNewPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.player = new Player(txtPlayerName.getText());
                System.out.println(game.player.getName());
                NewPlayer.super.setVisible(false);
            }
        });
    }
}
