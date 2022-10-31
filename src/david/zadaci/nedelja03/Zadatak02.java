package david.zadaci.nedelja03;

import java.util.Arrays;
import static david.zadaci.nedelja03.Zadatak01.*;

public class Zadatak02 {
    public static void main(String[] args) {
        int[][] inputMatrix = {
                {1,10,3},
                {4,5,6},
                {7,8,9}};
        showMatrix(inputMatrix);
        Arrays.stream(RowOrColumnWithMaxSum(inputMatrix)).forEach(System.out::println);
    }

    private static int[] RowOrColumnWithMaxSum(int[][] inputMatrix) {
        if(checkIfNullMatrix(inputMatrix)) throw new NullPointerException("Null matrix");

        int indexOfMaxRow = maxRowInMatrix(inputMatrix);
        int indexOfMaxColumn = maxRowInMatrix(transposeMatrix(inputMatrix));

        if (Arrays.stream(inputMatrix[indexOfMaxRow]).sum() > columnSum(inputMatrix, indexOfMaxColumn))
            return inputMatrix[indexOfMaxRow];
        return column(inputMatrix, indexOfMaxColumn);
    }

    private static int[] column(int[][] inputMatrix, int indexOfMaxColumn) {
        if(checkIfNullMatrix(inputMatrix)) throw new NullPointerException("Null matrix");

        int[] column = new int[inputMatrix.length];
        for (int i = 0; i < inputMatrix.length; i++)
            column[i] = inputMatrix[i][indexOfMaxColumn];

        return column;
    }

    private static int columnSum(int[][] inputMatrix, int indexOfMaxColumn) {
        if(checkIfNullMatrix(inputMatrix)) throw new NullPointerException("Null matrix");

        int sum = 0;
        for (int[] row : inputMatrix)
            sum += row[indexOfMaxColumn];

        return sum;
    }

    private static int maxRowInMatrix(int[][] inputMatrix) {
        if(checkIfNullMatrix(inputMatrix)) throw new NullPointerException("Null matrix");

        int sumRow = 0;
        int indexRow = 0;
        for (int i = 0; i < inputMatrix.length; i++) {
            int currentSum = Arrays.stream(inputMatrix[i]).sum();
            if (currentSum > sumRow) {
                sumRow = currentSum;
                indexRow = i;
            }
        }
        return indexRow;
    }

}
