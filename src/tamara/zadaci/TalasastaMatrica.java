package tamara.zadaci;

import java.util.Scanner;

public class TalasastaMatrica {
    public static void main(String[] args) {
        //unosenje matrice
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite broj redova matrice: ");
        int red = ulaz.nextInt();
        System.out.println("Unesite broj kolona matrice: ");
        int kolona = ulaz.nextInt();
        int[][] matrica = new int[red][kolona];
        System.out.println("Unesite elemente: ");

        for (int i = 0; i < red; i++) {
            for (int j = 0; j < kolona; j++) {
                matrica[i][j] = ulaz.nextInt();
            }
        }

        prikaziMatricu(matrica, red, kolona);

        for (int j = 0; j < kolona; j++) {
            for (int i = 0; i < red; i++) {
                System.out.print(matrica[i][j] + " ");
            }
            if(j + 1 < kolona) {
                j++;
                for (int i = red - 1; i >= 0; i--) {
                    System.out.print(matrica[i][j] + " ");
                }
            }
        }
    }

    private static void prikaziMatricu(int[][] matrica, int red, int kolona) {
        for (int i = 0; i < red; i++) {
            for (int j = 0; j < kolona; j++) {
                System.out.print(matrica[i][j] + " ");
            }
            System.out.println();
        }
    }
}
