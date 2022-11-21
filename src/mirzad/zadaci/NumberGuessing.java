package mirzad.zadaci;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Random random = new Random();
        int guess = random.nextInt(100);

        Scanner scanner = new Scanner(System.in);
        int guessed = -1;
        int count = 0;

        while (guessed != guess) {
            System.out.println();
            System.out.println("Unesite nagadjanje.");
            if(scanner.hasNextInt()) {
                guessed = scanner.nextInt();
                count++;
            } else {
                System.out.println("Pogresan unos.");
            }

            if(guess > guessed) System.out.println("Broj je veci od unesenog.");
            else if (guess< guessed) System.out.println("Broj je manji od unesenog.");

        }
        System.out.println("POGODILI STE! " + count);
    }
}
