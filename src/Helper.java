import java.util.Scanner;

import static java.lang.System.in;

//Helper class with useful functions (mostly take inputs of different kinds)
public class Helper {
    static int takeIntInput(int min, int max, String q) {
        Scanner intscanner = new Scanner(in);
        int number;
        do {
            System.out.println(q);
            while(!intscanner.hasNextInt()) {
                System.out.println("Ange ett nummer");
                intscanner.next();
            }
            number = intscanner.nextInt();
        }while(number < min && number > max);
        return number;
    }
    static char takeCharInput(String q) {
        Scanner charscanner = new Scanner(in);
        System.out.println(q);
        String str = charscanner.nextLine();
        if(str.length() == 1) return str.charAt(0);
        else takeCharInput(q);
        return 'c';
    }
    static String takeStringInput(String q) {
        Scanner stringscanner = new Scanner(in);
        System.out.println(q);
        String str = stringscanner.nextLine();
        return str;
    }
}