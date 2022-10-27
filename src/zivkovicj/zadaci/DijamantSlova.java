package zivkovicj.zadaci;

import java.util.Locale;
import java.util.Scanner;

public class DijamantSlova {
    public static void main(String[] args) {

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase(Locale.ROOT).toCharArray();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite broj redova:");
        int rows = scanner.nextInt();

        if (rows <= 0 || rows > 26){
            System.out.println("Mora biti izmedju 0 i 26");
            return;
        }
        // gornji trougao dijamanta
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // leva strana gornjeg trougla
            for (int j = 0; j <= i-1; j++) {
                System.out.print(alphabet[j]);
            }
            // desna strana gornjeg trougla
            for (int j = i; j >= 0; j--) {
                System.out.print(alphabet[j]);
            }
            System.out.println();
        }
        // donji trougao dijamanta
        for (int i = rows-1; i > 0; i--) {
            System.out.print(" ");
            for (int j = 0; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // leva strana donjeg trougla
            for (int j = 0; j <= i -1; j++) {
                System.out.print(alphabet[j]);
            }
            // desna strana donjeg trougla
            for (int j = i-2; j >=0; j--) {
                System.out.print(alphabet[j]);
            }
            System.out.println();
        }
    }
}

