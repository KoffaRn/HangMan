import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Wordlist {
    ArrayList<Word> wordList;
    public Wordlist() {
        wordList = new ArrayList<Word>();
    }

    void addToList(String stringWord) {
        wordList.add(new Word(stringWord));
        System.out.println("Lade till " + stringWord + " i ordlistan.");
    }
    Word randomWord() {
        Random rnd = new Random();
        return wordList.get(rnd.nextInt(wordList.size()));
    }
    void removeFromList(String word) {
        boolean removed = false;
        for(int i = 0; i < wordList.size(); i++) {
            if(wordList.get(i).getWord().equals(word)) {
                wordList.remove(i);
                removed = true;
            }
        }
        if(removed) System.out.println("Tog bort " + word + " från listan.");
        else System.out.println(word + " fanns inte i ordlistan.");
    }

    public void addDict() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("svenska-ord.txt"));
        while(sc.hasNext()) {
            wordList.add(new Word(sc.next()));
        }
    }
}
