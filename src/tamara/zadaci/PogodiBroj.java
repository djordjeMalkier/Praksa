package tamara.zadaci;

import java.util.Random;
import java.util.Scanner;

public class PogodiBroj {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomBroj = rand.nextInt(1000);
        System.out.println("Random broj: " + randomBroj);
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite broj: ");
        int brojPokusaja = 0;
        int broj = -1;

        while (broj != randomBroj) {
            String neki = ulaz.next();
            try {
                broj = Integer.parseInt(neki);
                if (broj > randomBroj) {
                    System.out.println("Broj je veci.");
                    brojPokusaja++;
                }

                else if (broj < randomBroj) {
                    System.out.println("Broj je manji.");
                    brojPokusaja++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Pogresan unos.");
                brojPokusaja++;
            }

        }

        System.out.println("Pogodile ste broj iz: " + ++brojPokusaja + " pokusaja.");
    }
}
