package zivkovicj.zadaci;

import java.math.BigInteger;
import java.util.*;

public class NoDuplicatePrimeNumberInString {
    public static void main(String[] args) {
        // imamo string gde su karakteri brojevi, treba naci prvi prost broj koji se ne ponavlja u tom stringu
        String stringOfNumbers = "14115785965";
        List<Integer> primeNumbers = new ArrayList<>();
        if (isNumeric(stringOfNumbers)) {
            for (int i = 0; i < stringOfNumbers.length(); i++) {
                for (int j = i; j < stringOfNumbers.length(); j++) {
                    BigInteger brojevi = new BigInteger(stringOfNumbers.substring(i, j + 1));
                    if (isPrime(brojevi.intValue())) {
                        primeNumbers.add(brojevi.intValue());
                    }
                }
            }
        }


        System.out.println("Primarni brojevi " + primeNumbers);
        System.out.println("Prvi primarni broj koji se ne ponavlja: " + firstNonRepeating(primeNumbers));
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int firstNonRepeating(List<Integer> list) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : list) {
            int count = counts.getOrDefault(num, 0);
            counts.put(num, count + 1);
        }
        for (int num : list) {
            if (counts.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
