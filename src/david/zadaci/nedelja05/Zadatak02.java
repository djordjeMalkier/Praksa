package david.zadaci.nedelja05;

import java.util.*;

/*
* za uneseni broj, permutacijom dobiti najveci
*/
public class Zadatak02 {
    public static void main(String[] args) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            int inputNumber;
            if (inputScanner.hasNextInt()) {
                inputNumber = inputScanner.nextInt();
                System.out.println(maxNumberDigitPermutation(inputNumber));
            }
        }
    }

    private static int maxNumberDigitPermutation(int inputNumber) {
        inputNumber = Math.abs(inputNumber);
        List<Integer> listOfDigits = arrayOfDigits(inputNumber);
        Collections.sort(listOfDigits);
        return createNumberFromList(listOfDigits);
    }

    private static int createNumberFromList(List<Integer> listOfDigits) {
        if (listOfDigits == null)
            throw new NullPointerException("Null list");
        int number = 0;
        int prod = 1;
        for (int digit : listOfDigits) {
            number += digit * prod;
            prod *= 10;
        }
        return number;
    }

    private static List<Integer> arrayOfDigits(int inputNumber) {
        List<Integer> listOfDigits = new ArrayList<>();
        while (inputNumber != 0) {
            listOfDigits.add(inputNumber % 10);
            inputNumber /= 10;
        }
        return listOfDigits;
    }
}
