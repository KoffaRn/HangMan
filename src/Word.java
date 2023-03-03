//Class to hold word object and take input from the game class to help with guessing letters and printing
// current word states
public class Word {
    private String word;
    private char[] wordState;

    //Holds object word information and helps game-class with word-logic
    public Word(String word) {
        this.word = word;
        //wordState to hold the state of the current wordState based on guesses, starts as *
        // and for every correct guess, the letters are presented
        wordState = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wordState[i] = '*';
        }
    }

    //Returns the current word for the object as a string
    String getWord() {
        return word;
    }

    //Helps the game-class make letter guesses and updates wordstate
    boolean guessLetter(char c) {
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
        }
        return isInWord;
    }

    // Returns the char[] wordState as a string (how many correct letters the player has so far)
    String getWordState() {
        String str = "";
        for (char c : wordState) str += c;
        return str;
    }
}
