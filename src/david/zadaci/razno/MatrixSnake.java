package david.zadaci.razno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static david.zadaci.nedelja03.Zadatak01.showMatrix;

public class MatrixSnake {
    public static void main(String[] args) {
        int[][] inputMatrix = {{1,2,3,4},
                {5,6,7,8},
        };

        showMatrix(inputMatrix);
        printSnakeMatrix(inputMatrix).forEach(x -> System.out.print(x + " "));
        System.out.println();
        printDiagonalMatrix(inputMatrix).forEach(x -> System.out.print(x + " "));
    }

    private static List<Integer> printDiagonalMatrix(int[][] inputMatrix) {
        List<Integer> elements = new ArrayList<>();

        for (int i = 0; i < inputMatrix[0].length; i++) {
            if (i % 2 == 0)
                elements.addAll(getDiagonalK(i, inputMatrix));
            else {
                List<Integer> reversed = getDiagonalK(i, inputMatrix);
                Collections.reverse(reversed);
                elements.addAll(reversed);
            }
        }
        return elements;
    }

    private static List<Integer> getDiagonalK(int k, int[][] inputMatrix) {
        List<Integer> elements = new ArrayList<>();

        for (int i = 0; i < inputMatrix.length; i++)
            for (int j = 0; j < inputMatrix[i].length; j++)
                if (j == i + k)
                    elements.add(inputMatrix[i][j]);

        return elements;
    }

    private static List<Integer> printSnakeMatrix(int[][] inputMatrix) {
        List<Integer> elements = new ArrayList<>();
        boolean reverse = false;

        for (int j = 0; j < inputMatrix[0].length; j++) {
            if (reverse) {
                for (int i = inputMatrix.length - 1; i >= 0; i--)
                    elements.add(inputMatrix[i][j]);
            }
            else {
                for (int i = 0; i < inputMatrix.length; i++)
                    elements.add(inputMatrix[i][j]);
            }
            reverse = !reverse;
        }
        return elements;
    }
}
