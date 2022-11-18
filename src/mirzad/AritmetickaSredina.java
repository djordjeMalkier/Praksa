package mirzad;

import java.util.Random;

public class AritmetickaSredina {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 10;
        int[] numbersArray = new int[n];
        int i = 0;
        int maxDistance = 100;

        while (n>0){
            int number = random.nextInt(100);
            numbersArray[i++] = number;
            n--;
            System.out.print(number + " ");
        }

        int sum = 0;

        for (i = 0; i < 10; i++){
            sum += numbersArray[i];
        }

        sum = sum / 10;
        System.out.println("\nArithmetic mean is: " + sum);

        int bestNumber = numbersArray[0]; //The number closest to sum

        for (i = 0; i < 10; i++){
            int distance = Math.abs(sum - numbersArray[i]);
            if(distance < maxDistance) {
                maxDistance = distance;
                bestNumber = numbersArray[i];
            }
        }

        System.out.println("The closest number is: " + bestNumber);
    }
}
