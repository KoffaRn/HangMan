import java.io.FileNotFoundException;

public class Game {
    Wordlist wl;
    Player player;
    Menu menu;
    Word word;
    int guessesLeft;
    public Game() throws FileNotFoundException {
        wl = new Wordlist();
        menu = new Menu();
        while(true) {
            menu.printMainMenu(this);
        }
    }
    void newGame() throws FileNotFoundException {
        if(player == null) newPlayer();
        guessesLeft = 7;
        if(wl.wordList.size() < 1) {
            System.out.println("Du har inga ord i ordlistan.");
            return;
        }
        word = new Word(wl.randomWord());
        while(true) {
            menu.printGameMenu(this);
        }
    }
    void newPlayer() {
        player = new Player(Helper.takeStringInput("Spelarnamn:"));
    }

    public void guessLetter(char c) throws FileNotFoundException {
        System.out.println("Du har " + guessesLeft + " gissningar kvar.");
        if(guessesLeft > 0) {
            word.guessLetter(c);
            checkWin();
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
