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
        wl = new Wordlist(); // Instantiate game wordlist
        menu = new Menu(); // instantiate game menu
        new NewGameGUI();
    }
    //Function to instantiate a new game session
    void newGame() throws FileNotFoundException {
        if(wl.wordList.size() < 1) { // If the list has no words, you cannot play hangman
            System.out.println("Du har inga ord i ordlistan.");
            return;
        }
        if(player == null) newPlayer(); // If there is no player object, create one
        guessesLeft = 7; // how many guesses should you have?
        guessedLetters = new ArrayList<>(); // Reset or create array to hold guessed letters
        word = new Word(wl.randomWord()); // Select a new word from the list
        while(true) { // Loop and print the game menu
            switch(menu.printGameMenu(guessesLeft, word.getWordState())) {
                case "guessLetter" -> guessLetter(Helper.takeCharInput("Vilken bokstav vill du gissa på:"));
                case "guessWord" -> guessWord(Helper.takeStringInput("Vilket ord vill du gissa på:"));
                case "playAgain" -> playAgain();
                default -> menu.printGameMenu(guessesLeft, word.getWordState());
            }
        }
    }
    //Function to create new player object
    void newPlayer() {
        player = new Player(Helper.takeStringInput("Spelarnamn:"));
    }
    //Function to guess a letter, takes help from Word.guessLetter
    public void guessLetter(char c) throws FileNotFoundException {
        c = Character.toLowerCase(c);
        //Don't guess if player already guessed the letter
        if(guessedLetters.contains(c)) {
            System.out.println("Du har redan gissat på " + c);
            return;
        }
        //If guesses is over 0, send the guess to word-class to make guess and check if the guess resultet in win
        if(guessesLeft > 0) {
            if(word.guessLetter(c)) {
                System.out.println(c + " fanns i ordet!");
            }
            else {
                System.out.println(c + " fanns inte i ordet.");
                guessesLeft -= 1;
            }
            checkWin();
            guessedLetters.add(c);
        }
        //If there is no guesses left, end the game
        else endGame();
    }

    //Function to see if the player has guessed all the correct letters (won the game session)
    private void checkWin() throws FileNotFoundException {
        String currentWord = word.getWordState();
        if(word.getWord().toLowerCase().equals(currentWord)) {
            winGame();
        }
    }

    //Function to guess the entire word and run winGame if its the right word
    public void guessWord(String guessWord) throws FileNotFoundException {
        if(word.getWord().equalsIgnoreCase(guessWord)) winGame();
    }

    //Function to run when the player has won the game
    private void winGame() throws FileNotFoundException {
        System.out.println("Grattis " + player.getName() + " vann!");
        player.plusPoint(1);
        System.out.println("Du har " + player.getPoints() + " poäng.");
        playAgain();
    }
    //Do the user want to play again after wingame, endgame or exit game
    private void playAgain() throws FileNotFoundException {
        switch (menu.printPlayAgain(word.getWord())) {
            case "newGame" -> newGame();
            default -> menu.printPlayAgain(word.getWord());
        }
    }

    //Function to run when the game ends with a loss
    private void endGame() throws FileNotFoundException {
        System.out.println("Tyvärr - " + player.getName() + " förlorade!");
        playAgain();
    }
}
