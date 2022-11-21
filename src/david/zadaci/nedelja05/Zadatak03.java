package david.zadaci.nedelja05;

import java.util.Scanner;

/*
* za neki zadati niz, i broj N unet sa tastature
* potrebno je pronaci par brojeva cija je suma najbliza broju N
* */
public class Zadatak03 {
    public static void main(String[] args) {
        int[] inputArray = {5, 4, 3, 8, 10, 11};
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt())
                return;
            int givenSum = scanner.nextInt();
            int[] result = pairWithApproxSum(inputArray, givenSum);
            System.out.println(result[0] + ", " + result[1]);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static int[] pairWithApproxSum(int[] inputArray, int givenSum) {
        if (inputArray == null)
            throw new NullPointerException("Null array");

        if (inputArray.length < 2)
            throw new ArrayIndexOutOfBoundsException("Array must have at least 2 elements");

        int[] pairWithApproxSum = new int[2];

        int indFirst = 0, indSecond = 0;
        int currentSum = inputArray[indFirst] + inputArray[indSecond];
        int minDist = Math.abs(givenSum - currentSum);
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i+1; j < inputArray.length; j++) {
                currentSum = inputArray[i] + inputArray[j];
                if (Math.abs(givenSum - currentSum) < minDist) {
                    minDist = Math.abs(givenSum - currentSum);
                    indFirst = i;
                    indSecond = j;
                }
            }
        }

        pairWithApproxSum[0] = inputArray[indFirst];
        pairWithApproxSum[1] = inputArray[indSecond];
        return pairWithApproxSum;
    }

}
