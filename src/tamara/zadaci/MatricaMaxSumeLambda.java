package tamara.zadaci;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatricaMaxSumeLambda {
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

        ulaz.close();

        int sumaGlavne = IntStream.range(0, matrica.length)
                .map(i -> matrica[i][i])
                .sum();

        int sumaSporedne = IntStream.range(0, matrica.length)
                .map(i -> matrica[i][matrica.length-i-1])
                .sum();

        int sumaIspodGlane = IntStream.range(0, matrica.length* matrica.length)
                        .filter(i -> i / matrica.length > i % matrica.length)
                        .map(i -> matrica[i / matrica.length][i % matrica.length])
                        .sum();

        int sumaIznadGlane = IntStream.range(0, matrica.length * matrica.length)
                .filter(i -> i / matrica.length < i % matrica.length)
                .map(i -> matrica[i / matrica.length][i % matrica.length])
                .sum();

        int sumaIznadSporedne = IntStream.range(0, matrica.length * matrica.length)
                .filter(i -> i / matrica.length + i % matrica.length < matrica.length - 1)
                .map(i -> matrica[i / matrica.length][i % matrica.length])
                .sum();

        int sumaIspodSporedne = IntStream.range(0, matrica.length * matrica.length)
                .filter(i -> i / matrica.length + i % matrica.length > matrica.length - 1)
                .map(i -> matrica[i / matrica.length][i % matrica.length])
                .sum();

        int proizvod = IntStream.range(0, matrica.length * matrica.length)
                .filter(i -> i / matrica.length != i % matrica.length)
                .filter(i -> i / matrica.length + i % matrica.length != matrica.length - 1)
                .map(i -> matrica[i / matrica.length][i % matrica.length])
                .reduce(1, (a, b) -> a * b);


        System.out.println("Suma na glavnoj: " + sumaGlavne);
        System.out.println("Suma na sporednoj: " + sumaSporedne);
        System.out.println("Suma ispod glavne: " + sumaIspodGlane);
        System.out.println("Suma iznad glavne: " + sumaIznadGlane);
        System.out.println("Suma iznad sporedne: " + sumaIznadSporedne);
        System.out.println("Suma ispod sporedne: " + sumaIspodSporedne);
        System.out.println("Proizvod: " + proizvod);
    }
}
