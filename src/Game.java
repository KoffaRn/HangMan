import java.util.Scanner;

import static java.lang.System.in;

public class Game {
    Wordlist wl;
    Player player;
    Menu menu;
    Word word;
    public Game() {
        wl = new Wordlist();
        menu = new Menu();
        while(true) {
            menu.printMainMenu(this);
        }
    }
    void newGame() {
        if(wl.wordList.size() < 1) {
            System.out.println("Du har inga ord i ordlistan.");
            return;
        }
        player = new Player(Helper.takeStringInput("Namn:"));
        word = new Word(wl.randomWord());
        while(true) {
            menu.printGameMenu(this);
        }

    }
}
