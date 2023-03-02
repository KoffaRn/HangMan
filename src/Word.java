//Class to hold word object and take input from the game class to help with guessing letters and printing
// current word states
public class Word {
    private String word;
    private char[] wordState;
    Game game;

    //Holds object word information
    public Word(String word) {
        this.word = word;
        wordState = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wordState[i] = '*';
        }
    }

    //Returns the current word for the object as a string
    String getWord() {
        return word;
    }

    //Helps the game-class make letter guesses
    void guessLetter(Game game, char c) {
        boolean isInWord = false;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == c) {
                isInWord = true;
                wordState[i] = c;
            }
        }
        if(isInWord) System.out.println(c + " fanns i ordet!");
        else {
            System.out.println(c + " fanns inte i ordet!");
            game.guessesLeft--;
        }
    }

    // Prints the wordState (how many correct letters the player has so far)
    public String getWordState() {
        String str = "";
        for (char c : wordState) str += c;
        return str;
    }
}
