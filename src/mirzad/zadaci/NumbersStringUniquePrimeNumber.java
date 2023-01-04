package mirzad.zadaci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.exit;

public class NumbersStringUniquePrimeNumber {


    public static void main(String[] args) {
        String numbers = "14115785965";
        if(!numbers.matches("[0-9]+")) {
            System.out.println("Ne sadrzi samo cifre");
            exit(1);
        }
        ArrayList<BigInteger> list = new ArrayList<>();
        HashMap<String, Integer> primeNumbersCount = checkNumbersCount(numbers, list);
        for (BigInteger number : list) {
            if (primeNumbersCount.get(String.valueOf(number)) == 1) System.out.println(number);
            break;
        }
    }

    private static HashMap<String, Integer> checkNumbersCount(String numbers, ArrayList<BigInteger> list) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < numbers.length(); i++){
            for (int j = i; j < numbers.length(); j++) {
                BigInteger number = new BigInteger(numbers.substring(i,j+1));
                if (number.isProbablePrime(1)) {
                    list.add(number);
                    if (!hashMap.containsKey(String.valueOf(number))) {
                        hashMap.put(String.valueOf(number), 1);
                    } else {
                        int count = hashMap.get(String.valueOf(number));
                        hashMap.put(String.valueOf(number), count + 1);
                    }
                }
            }

        }
        return hashMap;
    }
}
