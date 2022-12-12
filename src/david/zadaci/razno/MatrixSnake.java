package david.zadaci.razno;

import java.util.ArrayList;
import java.util.List;

import static david.zadaci.nedelja03.Zadatak01.showMatrix;

public class MatrixSnake {
    public static void main(String[] args) {
        int[][] inputMatrix = {{1,2,3},
                {4,5,6},
                {7,8,9},
                {10, 11, 12}
        };

        showMatrix(inputMatrix);
        printSnakeMatrix(inputMatrix).forEach(x -> System.out.print(x + " "));
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
