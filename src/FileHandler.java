import javax.swing.text.Document;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    ArrayList<String> arrToReturn;

    static ArrayList<String> readFileAsArray(String file) throws FileNotFoundException {
        ArrayList<String> arrToReturn = new ArrayList<>();
        Scanner sc = new Scanner(new File(file));
        while(sc.hasNext()) {
            arrToReturn.add(sc.nextLine());
        }
        return arrToReturn;
    }
    static void writeHighScore(String playerName, int score) throws IOException {
        File highScore = new File("highscore.txt");
        ArrayList<String> arrayListHighScore = readFileAsArray("highscore.txt");
        String[][] arrHighScore = new String[arrayListHighScore.size()][];
        for (int i = 0; i < arrayListHighScore.size(); i++) {
            arrayListHighScore.get(i).split(" ");
        }
        
        try {
            highScore.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner sc = new Scanner(highScore);
        FileWriter fw = new FileWriter("highscore.txt");


        if(arrHighScore.length == 0) {
            fw.write(score + " " + playerName);
        }
        else if(arrHighScore.length < 2) {

        }
    }

}
