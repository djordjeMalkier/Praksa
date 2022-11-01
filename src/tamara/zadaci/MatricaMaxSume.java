package tamara.zadaci;

import java.util.Scanner;

public class MatricaMaxSume {
    //za matricu unetu sa tastature n*n pronaci sledece sume: sume elemenata
    //na glavnoj dijagonali, na sporednoj dijagonali, sumu elemenata ispod i iznad i jedne i druge
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

        int sumaNaGlavnojD = 0;
        int sumaNaSporednojD = 0;

        int sumaIspodGlavne = 0;
        int sumaIznadGlavne = 0;

        int sumaIznadSporedne = 0;
        int sumaIspodSporedne = 0;

        int proizvod = 1;

        for (int i = 0; i < velicina; i++) {
            for (int j = 0; j < velicina; j++) {
                //na glavnoj
                if(i == j)
                    sumaNaGlavnojD += matrica[i][j];
                //na sporednoj
                if(i + j == velicina - 1)
                    sumaNaSporednojD += matrica[i][j];
                //iznad glavne
                if(j > i)
                    sumaIznadGlavne += matrica[i][j];
                //ispod glavne
                if(j < i)
                    sumaIznadGlavne += matrica[i][j];
                //iznad sporedne
                if(i + j < velicina - 1)
                    sumaIznadSporedne += matrica[i][j];
                //ispod sporedne
                if(i + j > velicina - 1)
                    sumaIspodSporedne += matrica[i][j];
                //proizvod
                if(!(i == j) && !(i + j == velicina - 1)) {
                    proizvod *= matrica[i][j];
                }

            }
        }
        System.out.println("\nSuma na glavnoj dijagonali: " + sumaNaGlavnojD);
        System.out.println("\nSuma na sporednoj dijagonali: " + sumaNaSporednojD);
        System.out.println("\nSuma iznad glavne dijagonale: " + sumaIznadGlavne);
        System.out.println("\nSuma ispod glavne dijagonale: " + sumaIspodGlavne);
        System.out.println("\nSuma iznad sporedne dijagonale: " + sumaIznadSporedne);
        System.out.println("\nSuma ispod sporedne dijagonale: " + sumaIspodSporedne);
        System.out.println("\nProizvod: " + proizvod);
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
