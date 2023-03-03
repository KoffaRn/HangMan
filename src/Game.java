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
        while(true) {  // Loop menu
            String choice = menu.printMainMenu();
            switch (choice) {
                case "newGame" -> newGame();
                case "addToList" -> wl.addToList(Helper.takeStringInput("Vilket ord vill du lägga till: "));
                case "removeFromList" -> wl.removeFromList(Helper.takeStringInput("Vilket ord vill du ta bort: "));
                case "addDict" -> wl.addDict();
            }
        }
    }
    //Function to instantiate a new game
    void newGame() throws FileNotFoundException {
        if(player == null) newPlayer(); // If there is no player object, create one
        guessesLeft = 7; // how many guesses should you have?
        guessedLetters = new ArrayList<>(); // Reset or create array to hold guessed letters
        if(wl.wordList.size() < 1) { // If the list has no words, you cannot play hangman
            System.out.println("Du har inga ord i ordlistan.");
            return;
        }
        word = new Word(wl.randomWord()); // Select a new word from the list
        while(true) { // Loop and print the game menu
            String choice = menu.printGameMenu(guessesLeft, word.getWordState());
            switch(choice) {
                case "guessLetter" -> guessLetter(Helper.takeCharInput("Vilken bokstav vill du gissa på:"));
                case "guessWord" -> guessWord(Helper.takeStringInput("Vilket ord vill du gissa på:"));
                case "playAgain" -> menu.printPlayAgain(word.getWord());
            }
        }
    }
    //Function to create new player object
    void newPlayer() {
        player = new Player(Helper.takeStringInput("Spelarnamn:"));
    }
    //Function to guess a letter

    public void guessLetter(char c) throws FileNotFoundException {
        c = Character.toLowerCase(c);
        //Don't guess if player already guessed the letter
        if(guessedLetters.contains(c)) {
            System.out.println("Du har redan gissat på " + c);
            return;
        }
        //If guesses is over 0, send the guess to word-class to make guess and check if the guess resultet in win
        if(guessesLeft > 0) {
            word.guessLetter(this, c);
            checkWin();
            guessedLetters.add(c);
        }
        //If there is no guesses left, end the game
        else endGame();
    }

    //Function to see if the player has guessed all the correct letters
    private void checkWin() throws FileNotFoundException {
        String currentWord = word.getWordState();
        if(word.getWord().toLowerCase().equals(currentWord)) {
            winGame();
        }
    }

    //Function to guess the entire word
    public void guessWord(String guessWord) throws FileNotFoundException {
        if(word.getWord().toLowerCase().equals(guessWord.toLowerCase())) winGame();
    }

    //Function to run when the player has won the game
    private void winGame() throws FileNotFoundException {
        System.out.println("Grattis " + player.getName() + " vann!");
        player.plusPoint(1);
        System.out.println("Du har " + player.getPoints() + " poäng.");
        String choice = menu.printPlayAgain(word.getWord());
        if(choice.equals("newGame")) newGame();
    }
    //Function to run when the game ends without a win
    private void endGame() throws FileNotFoundException {
        System.out.println("Tyvärr - " + player.getName() + " förlorade!");
        String choice = menu.printPlayAgain(word.getWord());
        if(choice.equals("newGame")) newGame();
    }
}
