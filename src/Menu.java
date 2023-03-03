// Class to handle the printing of menus and call appropriate functions
public class Menu {
    String printMainMenu() {
        String s = """
                1. Starta nytt spel.
                2. Lägg till ord till ordlistan
                3. Ta bort ord från ordlistan
                4. Lägg till en svensk ordlista\s
                5. Avsluta spel""";
        System.out.println(s);
        int choice = Helper.takeIntInput(1, 4, "Ange alternativ:");
        switch(choice) {
            case 1 -> {
                return "newGame";
            }
            case 2 -> {
                return "addToList";
            }
            case 3 -> {
                return "removeFromList";
            }
            case 4 -> {
                return "addDict";
            }
            case 5 -> System.exit(0);
        }
        return null;
    }
    String printGameMenu(int guessesLeft, String wordState)  {
        String s = "Nuvarande ord: " + wordState + "\n";
                if(guessesLeft == 0) s += "Sista chansen nu! \n";
                else s += "Du har " + guessesLeft + " gissningar kvar.\n";
                s += """
                        1. Gissa en bokstav
                        2. Gissa ordet
                        3. Avsluta spel""";
        System.out.println(s);
        int choice = Helper.takeIntInput(1, 3, "Ange alternativ:");
        switch (choice) {
            case 1 -> {
                return "guessLetter";
            }
            case 2 -> {
                return "guessWord";
            }
            case 3 -> {
                return "playAgain";
            }
        }
        return null;
    }

    String printPlayAgain(String word) {
        String s = "Ordet var " + word + ". Vill du spela igen? \n" +
                "1. Ja\n" +
                "2. Nej\n";
        System.out.println(s);
        int choice = Helper.takeIntInput(1, 2, "Ange val:");
        switch(choice) {
            case 1 -> {
                return "newGame";
            }
            case 2 -> System.exit(0);
            }
        return null;
    }
}