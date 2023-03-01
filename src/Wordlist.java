import java.util.ArrayList;
import java.util.Random;

public class Wordlist {
    ArrayList<String> wordList;
    public Wordlist() {
        wordList = new ArrayList<String>();
    }

    void addToList(String word) {
        wordList.add(word);
    }
    String randomWord() {
        Random rnd = new Random();
        return wordList.get(rnd.nextInt(wordList.size()));
    }
    void removeFromList(String word) {
        if(wordList.contains(word)) wordList.remove(word);
        else System.out.println("Ordet finns inte");
    }
}
