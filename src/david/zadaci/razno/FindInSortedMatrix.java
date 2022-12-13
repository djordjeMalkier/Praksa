package david.zadaci.razno;

import java.util.Arrays;

public class FindInSortedMatrix {
    public static void main(String[] args) {
        int[][] inputMatrix = {{1,3,7,9,15},
                {2,5,8,17,22},
                {4,7,10,30,40}
        };

        int num = 17;
        int[] index = findInMatrix(inputMatrix, num);
        System.out.println(index[0] + ", " + index[1]);
    }

    private static int[] findInMatrix(int[][] inputMatrix, int key) {
        for (int i = 0; i < inputMatrix.length; i++) {
            int j = Arrays.binarySearch(inputMatrix[i], key);
            if (j >= 0) {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

}
