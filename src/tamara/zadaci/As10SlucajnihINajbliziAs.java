package tamara.zadaci;

import java.util.Random;

//Napraviti niz od 10 slučajnih prirodnih brojeva manjih od 100 i ispisati ih.
//Naći aritmetičku sredinu niza i odrediti koji je član niza najbliži aritmetičkoj sredini i ispisati ih.
public class As10SlucajnihINajbliziAs {
    public static void main(String[] args) {
        int[] nizSlucajnih = generisiNiz();

        //ispis niza
        for (int broj : nizSlucajnih) {
            System.out.print(broj + " ");
        }

        //ispis aritmeticke sredine
        double ariSredina = aritmetickaSredina(nizSlucajnih);
        System.out.println("\nAritmeticka sredina je: " + ariSredina);

        //ispis najblizg elementa aritmetickoj sredini
        System.out.println("Broj najblizi aritmetickoj sredini je: " + nadjiNajbliziAS(nizSlucajnih, ariSredina));
    }

    private static int nadjiNajbliziAS(int[] nizSlucajnih, double ariSredina) {
        double minRazlika = Integer.MAX_VALUE;
        int zapamceniBroj = nizSlucajnih[0];

        for (int broj : nizSlucajnih) {
            if (Math.abs(ariSredina - broj) < minRazlika) {
                minRazlika = Math.abs(ariSredina - broj);
                zapamceniBroj = broj;
            }
        }

        return  zapamceniBroj;
    }

    private static int[] generisiNiz() {
        Random rand = new Random();
        int[] nizSlucajnih = new int[10];
        for (int i = 0; i < nizSlucajnih.length; i++) {
            nizSlucajnih[i] = rand.nextInt(100);
        }

        return nizSlucajnih;
    }

    private static double aritmetickaSredina(int[] nizSlucajnih) {
        int suma = 0;
        int brojac = 0;
        double ariSredina;

        for (int j : nizSlucajnih) {
            brojac++;
            suma += j;
        }

        ariSredina = (double)suma / brojac;

        return ariSredina;

    }
}
