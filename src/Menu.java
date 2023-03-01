import java.io.FileNotFoundException;

public class Menu {
    Game game;
    void printMainMenu(Game game) throws FileNotFoundException {
        this.game = game;
        String s = "1. Starta nytt spel.\n" +
                "2. Lägg till ord till ordlistan\n" +
                "3. Ta bort ord från ordlistan\n" +
                "4. Lägg till en svensk ordlista \n" +
                "5. Avsluta spel";
        System.out.println(s);
        int choice = Helper.takeIntInput(1, 4, "Ange alternativ:");
        switch(choice) {
            case 1 -> game.newGame();
            case 2 -> game.wl.addToList(Helper.takeStringInput("Ange ord att lägga till:"));
            case 3 -> game.wl.removeFromList(Helper.takeStringInput("Ange ord att ta bort:"));
            case 4 -> game.wl.addDict();
            case 5 -> System.exit(0);
        }
    }
    void printGameMenu(Game game) throws FileNotFoundException {
        String s = "Nuvarande ord: " + game.word.getWordState() + "\n" +
                "Du har " + game.guessesLeft + " gissningar kvar.\n" +
                "1. Gissa en bokstav\n" +
                "2. Gissa ordet\n" +
                "3. Avsluta spel";
        System.out.println(s);
        int choice = Helper.takeIntInput(1, 3, "Ange alternativ:");
        switch (choice) {
            case 1 -> game.guessLetter(Helper.takeCharInput("Gissa bokstav:"));
            case 2 -> game.guessWord(Helper.takeStringInput("Gissa ord:"));
            case 3 -> printPlayAgain(game);
        }
    }

    void printPlayAgain(Game game) throws FileNotFoundException {
        String s = "Du vann! \n" +
                "Vill du spela igen? \n" +
                "1. Ja\n" +
                "2. Nej";
        System.out.println(s);
        int choice = Helper.takeIntInput(1, 2, "Ange val:");
        switch(choice) {
            case 1 -> game.newGame();
            case 2 -> System.exit(0);
        }
    }
}