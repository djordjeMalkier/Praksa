package tamara.zadaci;

import java.util.Scanner;

public class RedKolonaSaMaxSumom {
    //red ili kolona koja ima najvecu sumu elemenata
    public static void main(String[] args) {
        //unosenje matrice
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite velicinu matrice: ");
        int velicina = ulaz.nextInt();
        int[][] matrica = new int[velicina][velicina];
        System.out.println("Unesite elemente: ");

        for (int i = 0; i < velicina; i++) {
            for (int j = 0; j < velicina; j++) {
                matrica[i][j] = ulaz.nextInt();
            }
        }

        prikaziMatricu(matrica, velicina);

        int maxSumaRed = 0;
        int maxSumaKolona = 0;

        //kolona
        int sumaKolona = 0;

        int[] maxNizKolona = new int[velicina];

        for (int i = 0; i < velicina; i++) {
            sumaKolona = 0;
            int[] nizKolona = new int[velicina];
            for (int j = 0; j < velicina; j++) {
                sumaKolona += matrica[j][i];
                nizKolona[j] = matrica[j][i];
            }
            if(maxSumaKolona <= sumaKolona) {
                maxSumaKolona = sumaKolona;
                maxNizKolona = nizKolona;

            }
        }

        //red
        int sumaRed = 0;

        int[] maxNizRed = new int[velicina];

        for (int i = 0; i < velicina; i++) {
            sumaRed = 0;
            int[] nizRed = new int[velicina];
            for (int j = 0; j < velicina; j++) {
                sumaRed += matrica[i][j];
                nizRed[j] = matrica[i][j];
            }
            if(maxSumaRed <= sumaRed) {
                maxSumaRed = sumaRed;
                maxNizRed = nizRed;
            }
        }

        //poredjenje maksimalnih suma i ispis
        if(maxSumaRed > maxSumaKolona) {
            System.out.println("\nNajvecu sumu ima red: ");
            for (int k : maxNizRed) {
                System.out.print(k + " ");
            }
        } else if (maxSumaRed < maxSumaKolona) {
            System.out.println("\nNajvecu sumu ima kolna: ");
            for (int k : maxNizKolona) {
                System.out.print(k + " ");
            }
        } else if(maxSumaRed == maxSumaKolona) {
            System.out.println("\nIstu najvecu sumu imaju kolona i red: ");
            System.out.println("\nKolona: ");
            for (int k : maxNizKolona) {
                System.out.print(k + " ");
            }
            System.out.println("\nRed: ");
            for (int k : maxNizRed) {
                System.out.print(k + " ");
            }
        }
    }

    private static void prikaziMatricu(int[][] matrica, int velicina) {
        for (int i = 0; i < velicina; i++) {
            for (int j = 0; j < velicina; j++) {
                System.out.print(matrica[i][j] + " ");
            }
            System.out.println();
        }
    }
}
