import java.util.Scanner;

import static java.lang.System.in;

public class Menu {
    Game game;
    void printMainMenu(Game game) {
        this.game = game;
        String s = "1. Starta nytt spel. \n" +
                "2. Lägg till ord\n" +
                "3. Ta bort ord \n" +
                "4. Avsluta spel";
        System.out.println(s);
        int choice = Helper.takeIntInput(1, 4, "Ange alternativ:");
        switch(choice) {
            case 1 -> game.newGame();
            case 2 -> game.wl.addToList(Helper.takeStringInput("Ange ord att lägga till:"));
            case 3 -> game.wl.removeFromList(Helper.takeStringInput("Ange ord att ta bort:"));
            case 4 -> System.exit(0);
        }
    }
    void printGameMenu(Game game) {
        String s = "Nuvarande ord: " + game.word.getWordState() + "\n" +
                "1. Gissa en bokstav\n" +
                "2. Gissa ordet\n" +
                "3. Avsluta spel";
        System.out.println(s);
        int choice = Helper.takeIntInput(1, 3, "Ange alternativ:");
        switch (choice) {
            case 1 -> game.word.guessLetter(Helper.takeCharInput("Gissa bokstav:"));
            case 2 -> game.word.guessWord(Helper.takeStringInput("Gissa ord:"));
            case 3 -> System.exit(0);
        }
    }
}