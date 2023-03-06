import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Game {
    Wordlist wl;
    Player player;
    Menu menu;
    Word word;
    int guessesLeft;
    ArrayList<Character> guessedLetters;
    public Game() throws FileNotFoundException {
        //GUI gui = new GUI(this);
        wl = new Wordlist();
        menu = new Menu();
        while(true) {
            menu.printMainMenu(this);
        }
    }
    void newGame() throws FileNotFoundException {
        if(wl.wordList.size() < 1) {
            System.out.println("Du har inga ord i ordlistan.");
            return;
        }
        if(player == null) newPlayer(Helper.takeStringInput("Ange spelarnamn:"));
        guessesLeft = 7;
        guessedLetters = new ArrayList<>();
        word = wl.randomWord();
        while(true) {
            menu.printGameMenu(this);
        }
    }
    void newPlayer(String name) {
        player = new Player(name);
    }

    public void guessLetter(char c) throws FileNotFoundException {
        if(guessedLetters.contains(c)) {
            System.out.println("Du har redan gissat på " + c);
            return;
        }
        if(guessesLeft > 0) {
            word.guessLetter(this, c);
            checkWin();
            guessedLetters.add(c);
        }
        else endGame();
    }

    private void checkWin() throws FileNotFoundException {
        String currentWord = word.getWordState();
        if(word.getWord().equals(currentWord)) {
            winGame();
        }
    }

    public void guessWord(String guessWord) throws FileNotFoundException {
        if(word.getWord().equals(guessWord)) winGame();
    }

    private void winGame() throws FileNotFoundException {
        System.out.println("Grattis " + player.getName() + " vann!");
        System.out.println("Ordet var " + word.getWord() + ".");
        player.plusPoint(1);
        System.out.println("Du har " + player.getPoints() + " poäng.");
        menu.printPlayAgain(this);
    }
    private void endGame() throws FileNotFoundException {
        System.out.println("Tyvärr - " + player.getName() + " förlorade!");
        System.out.println("Ordet var " + word.getWord() + ".");
        menu.printPlayAgain(this);
    }
}
