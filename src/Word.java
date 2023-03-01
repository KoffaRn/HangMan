public class Word {
    private String word;
    private char[] wordState;
    Game game;
    public Word(String word) {
        this.game = game;
        this.word = word;
        wordState = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wordState[i] = '*';
        }
    }
    String getWord() {
        return word;
    }
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

    public String getWordState() {
        String str = "";
        for (char c : wordState) str += c;
        return str;
    }
}
