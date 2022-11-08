package zivkovicj.zadaci;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Random randomNumber = new Random();
        int broj = randomNumber.nextInt(1, 1000);
        System.out.println(broj);
        System.out.println(guessTheNumber(broj));

    }

    public static int guessTheNumber(int zadatiBroj) {
        int guess = 0;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        while (zadatiBroj != guess) {
            System.out.println("Unesite broj:");
            guess = scanner.nextInt();
            if (zadatiBroj == guess) {
                System.out.println("POGODAK!!!");
            } else if (zadatiBroj > guess) {
                System.out.println("Vas broj je manji od zadatog");
                counter++;
            } else {
                System.out.println("Vas broj je veci od zadatog");
                counter++;
            }
        }
        return counter;
    }
}
