package david.zadaci.nedelja05;

import java.util.Arrays;
import java.util.Random;

/*
* Napraviti niz od 10 slučajnih prirodnih brojeva manjih od 100 i ispisati ih.
* Naći aritmetičku sredinu niza i odrediti koji je član niza najbliži aritmetičkoj sredini i ispisati ih.
* */
public class Zadatak01 {
    public static void main(String[] args) {
        int[] generatedArray = generateArray10intsSmallerThan100();
        Arrays.stream(generatedArray).forEach(System.out::println);
        float mean = mean(generatedArray);
        System.out.println("Mean: " + mean);
        System.out.println(generatedArray[indexClosestToMean(generatedArray, mean)]);
    }

    private static int indexClosestToMean(int[] generatedArray, float mean) {
        if (generatedArray == null)
            throw new NullPointerException("Null array");

        float dist = Math.abs(generatedArray[0] - mean);
        int indexOfClosest = 0;
        for (int i = 0; i < generatedArray.length; i++) {
            float newDist = Math.abs(generatedArray[i] - mean);
            if (newDist < dist) {
                dist = newDist;
                indexOfClosest = i;
            }
        }
        return indexOfClosest;
    }

    private static float mean(int[] generatedArray) {
        if (generatedArray == null)
            throw new NullPointerException("Null array");
        if (generatedArray.length == 0)
            throw new ArithmeticException("Divide by zero");
        return (float)Arrays.stream(generatedArray).sum() / generatedArray.length;
    }

    private static int[] generateArray10intsSmallerThan100() {
        Random random = new Random();
        return random.ints(10, 1, 100).toArray();
    }
}
