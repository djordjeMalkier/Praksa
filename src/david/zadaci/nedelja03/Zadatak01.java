package david.zadaci.nedelja03;
/*
* Transponovanje matrice
* */
public class Zadatak01 {
    public static void main(String[] args) {
        int[][] inputMatrix = {
                {1,2,3,-1},
                {4,5,6,-1},
                {7,8,9,-1}};
        showMatrix(inputMatrix);
        int[][] transposedMatrix = transposeMatrix(inputMatrix);
        showMatrix(transposedMatrix);
    }

    public static void showMatrix(int[][] inputMatrix) {
        if(checkIfNullMatrix(inputMatrix)) throw new NullPointerException("Null matrix");

        for (int[] row: inputMatrix) {
            for (int element : row)
                System.out.print(element + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static boolean checkIfNullMatrix(int[][] inputMatrix) {
        if (inputMatrix == null) return true;
        for (int[] row: inputMatrix)
            if (row == null) return true;

        return false;
    }

    public static int[][] transposeMatrix(int[][] inputMatrix) {
        if(checkIfNullMatrix(inputMatrix)) throw new NullPointerException("Null matrix");
        int rowLen = inputMatrix[0].length;
        int[][] transposedMatrix = new int[rowLen][inputMatrix.length];

        for (int i = 0; i < inputMatrix.length; i++) {
            if (inputMatrix[i].length != rowLen) throw new IndexOutOfBoundsException("Invalid matrix: row len");
            for (int j = 0; j < inputMatrix[i].length; j++)
                transposedMatrix[j][i] = inputMatrix[i][j];
        }
        return transposedMatrix;
    }
}
