public class Word {
    private String word;
    private String wordState;
    public Word(String word) {
        this.word = word;
        wordState = "";
        for (int i = 0; i < word.length(); i++) {
            wordState += "_";
        }
    }
    String getWord() {
        return word;
    }
    void guessLetter(char c) {
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == c) {
                System.out.println(c + " fanns i ordet!");
                updateWordState(c);
                return;
            }
            else{
                System.out.println(c + " fanns inte i ordet.");
                return;
            }
        }
    }
    void guessWord(String word) {

    }
    void updateWordState(char c) {
    }

    public String getWordState() {
        return wordState;
    }
}
