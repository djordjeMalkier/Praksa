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

        int[] maxRow = maxRowInMatrix(inputMatrix);
        int[] maxColumn = maxRowInMatrix(transposeMatrix(inputMatrix));

        return (Arrays.stream(maxRow).sum() > Arrays.stream(maxColumn).sum()) ? maxRow : maxColumn;
    }

    private static int[] maxRowInMatrix(int[][] inputMatrix) {
        if(checkIfNullMatrix(inputMatrix)) throw new NullPointerException("Null matrix");

        int[] maxRow = inputMatrix[0];
        int sumRow = Arrays.stream(maxRow).sum();
        for (int[] row : inputMatrix) {
            int currentSum = Arrays.stream(row).sum();
            if (currentSum > sumRow) {
                sumRow = currentSum;
                maxRow = row;
            }
        }
        return maxRow;
    }
}
