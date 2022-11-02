package david.zadaci.nedelja03;

/*
* potrebno je za matricu unetu sa tastature n*n pronaci sledece sume:
* sume elemenata na glavnoj dijagonali
* na sporednoj dijagonali
* sumu elemenata ispod i iznad i jedne i druge.
* Takodje je potrebno izracunati proizvod svih brojeva koji ne pripadaju ni glavnoj ni sporednoj dijagonali*/

import java.io.IOException;
import java.util.Scanner;

import static david.zadaci.nedelja03.Zadatak01.checkIfNullMatrix;
import static david.zadaci.nedelja03.Zadatak01.showMatrix;

public class Zadatak04 {
    public static void main(String[] args) {
        try {
            int[][] inputMatrix = inputMatrix();
            showMatrix(inputMatrix);
            calculateMatrix(inputMatrix);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void calculateMatrix(int[][] inputMatrix) {
        if(checkIfNullMatrix(inputMatrix)) throw new NullPointerException("Null matrix");

        int sumGlavnaDijagonala = 0, sumSporednaDijagonala = 0;
        int sumIspodGlavne = 0, sumIznadGlavne = 0;
        int sumIspodSporedne = 0, sumIznadSporedne = 0;
        int proizvodNiGlavnaNiSporedna = 1;
        for (int i = 0; i < inputMatrix.length; i++)
            for (int j = 0; j < inputMatrix[i].length; j++) {
                if (i == j) sumGlavnaDijagonala += inputMatrix[i][j];
                if (i + j == inputMatrix.length - 1 ) sumSporednaDijagonala += inputMatrix[i][j];
                if (i > j) sumIspodGlavne += inputMatrix[i][j];
                if (i < j) sumIznadGlavne += inputMatrix[i][j];
                if (i < inputMatrix.length - 1 - j) sumIznadSporedne += inputMatrix[i][j];
                if (i > inputMatrix.length - 1 - j) sumIspodSporedne += inputMatrix[i][j];
                if (i != j && i + j != inputMatrix.length - 1) proizvodNiGlavnaNiSporedna *= inputMatrix[i][j];
            }

        System.out.println("Glavna dijagonala: " + sumGlavnaDijagonala);
        System.out.println("Sporedna dijagonala: " + sumSporednaDijagonala);
        System.out.println("Ispod glavne: " + sumIspodGlavne);
        System.out.println("Iznad glavne: " + sumIznadGlavne);
        System.out.println("Iznad sporedne: " + sumIznadSporedne);
        System.out.println("Ispod sporedne: " + sumIspodSporedne);
        System.out.println("Proizvod van dijagonala: " + proizvodNiGlavnaNiSporedna);
    }

    private static int[][] inputMatrix() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert dimension and matrix elements:");

        if (!sc.hasNextInt()) throw new IOException("Matrix dimension is not number");

        int matrixSize = sc.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++)
            for (int j = 0; j < matrixSize; j++) {
                if (!sc.hasNextInt()) throw new IOException("Matrix element is not number");
                matrix[i][j] = sc.nextInt();
            }
        sc.close();
        return matrix;
    }
}
