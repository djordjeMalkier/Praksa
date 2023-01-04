package mirzad.zadaci;

import java.util.HashMap;

public class NumbersStringUniquePrimeNumber {

    public static void main(String[] args) {
        String numbers = "1234567843423";
        HashMap<Integer, Integer> primeNumbersCount = checkNumbersCount(numbers);

        for (int i = 0; i < numbers.length(); i++){
            int number = Integer.parseInt(String.valueOf(numbers.charAt(i)));
            if(isPrime(number)){
                int count = primeNumbersCount.get(number);
                if (count == 1) {
                    System.out.println(number);
                    break;
                }
            }
        }

    }

    private static HashMap<Integer, Integer> checkNumbersCount(String numbers) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < numbers.length(); i++){
            int number = Integer.parseInt(String.valueOf(numbers.charAt(i)));
                if(!hashMap.containsKey(number)) {
                    hashMap.put(number, 1);
                }else {
                    int count = hashMap.get(number);
                    hashMap.put(number, count + 1);
                }

        }
        return hashMap;
    }

    private static  boolean isPrime(int num)
    {
        if(num<=1)
        {
            return false;
        }
        for(int i=2;i<=num/2;i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;
    }
}
