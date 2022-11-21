package tamara.zadaci;

import java.util.Scanner;

public class ZbirDvaBrojaNajbliziBrojuN {
    public static void main(String[] args) {
        int[] zadatiNiz = {5, 4, 3, 8, 10, 11};
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite broj: ");
        int brojSaTastature = ulaz.nextInt();
        ulaz.close();

        int sumaDvaBroja;
        int minRazlika = Integer.MAX_VALUE;
        int broj1 = zadatiNiz[0];
        int broj2 = zadatiNiz[1];

        for (int i = 0; i < zadatiNiz.length-1; i++) {
            int razlika;

            for (int j = i + 1; j < zadatiNiz.length; j++) {
                sumaDvaBroja = zadatiNiz[i] + zadatiNiz[j];
                razlika = Math.abs(sumaDvaBroja - brojSaTastature);

                if(razlika < minRazlika) {
                    minRazlika = razlika;
                    broj1 = zadatiNiz[i];
                    broj2 = zadatiNiz[j];
                }
            }
        }

        System.out.println("Udaljenost od zadatog broja je: " + minRazlika + ". Par brojeva je: " + broj1 + " i " + broj2);

    }
}
