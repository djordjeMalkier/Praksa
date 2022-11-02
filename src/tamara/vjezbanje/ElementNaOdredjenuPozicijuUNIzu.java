package tamara.vjezbanje;

import java.util.Scanner;

public class ElementNaOdredjenuPozicijuUNIzu {
    public static void main(String[] args) {
        int[] zadatiNiz = {5, -1, 12, 6, 32};
        Scanner unos = new Scanner(System.in);

        int element = 0;
        System.out.println("Unesite element: ");
        if(unos.hasNextInt()) {
            element = unos.nextInt();
        } else
            System.err.println("Morate unijeti cijeli broj.");

        int pozicija = 0;
        System.out.println("Unesite poziciju: ");
        if(unos.hasNextInt()) {
            pozicija = unos.nextInt();
        } else
            System.err.println("Morate unijeti cijeli broj u intervalu [0 - " + zadatiNiz.length + "]");

        unos.close();

        if(pozicija < 0 || pozicija > zadatiNiz.length) {
            System.err.println("Pozicija mora biti u intervalu [0 - " + zadatiNiz.length + "]");
            return;
        }

        int[] noviNiz = new int[zadatiNiz.length + 1];

        for (int i = 0; i < noviNiz.length; i++) {
            if (i < pozicija) {
                noviNiz[i] = zadatiNiz[i];
            } else if (i == pozicija) {
                noviNiz[i] = element;
            } else
                noviNiz[i] = zadatiNiz[i - 1];

        }

        System.out.println("Zadati niz: ");
        for (int k: zadatiNiz) {
            System.out.print(k + " ");
        }

        System.out.println("\n\nNovi niz: ");
        for (int k : noviNiz) {
            System.out.print(k + " ");
        }
    }
}
