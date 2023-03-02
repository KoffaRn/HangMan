import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Wordlist {
    ArrayList<String> wordList;
    public Wordlist() {
        wordList = new ArrayList<String>();
    }

    void addToList(String word) {
        wordList.add(word);
        System.out.println("Lade till " + word + " i ordlistan.");
    }
    String randomWord() {
        Random rnd = new Random();
        return wordList.get(rnd.nextInt(wordList.size()));
    }
    void removeFromList(String word) {
        if(wordList.contains(word)) wordList.remove(word);
        else System.out.println(word + " finns inte i ordlistan.");
    }

    public void addDict() throws FileNotFoundException {
        FileHandler.readFileAsArray("svenska-ord.txt");
    }
}
