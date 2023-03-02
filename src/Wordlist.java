import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Class to hold wordlist objects, logic to add words to list. Take input from a dictionary-file to wordlist,
x
public class Wordlist {
    ArrayList<String> wordList;
    public Wordlist() {
        wordList = new ArrayList<String>();
    }
//Add user input word to string
    void addToList(String word) {
        wordList.add(word);
        System.out.println("Lade till " + word + " i ordlistan.");
    }
    // Generate a random word
    String randomWord() {
        Random rnd = new Random();
        return wordList.get(rnd.nextInt(wordList.size()));
    }
    //Remove a word (if it exists) from the wordlist
    void removeFromList(String word) {
        if(wordList.contains(word)) wordList.remove(word);
        else System.out.println(word + " finns inte i ordlistan.");
    }
    // Add a dictionary file to the wordlist
    //TODO: Expand to more wordlists, languages etc.
    public void addDict() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("svenska-ord.txt"));
        while(sc.hasNext()) {
            wordList.add(sc.nextLine());
        }
    }
}
