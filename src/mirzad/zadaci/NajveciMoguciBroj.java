package mirzad.zadaci;

import java.util.*;

public class NajveciMoguciBroj {
    public static void main(String[] args) {
        System.out.println("Give a number:");
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        if(scanner.hasNextInt()){
            number = scanner.nextInt();
        }else {
            System.out.println("Invalid input, must be a number.");
            return;
        }

        int n = 0;
        List<Integer> digits = new ArrayList<>();

        while (number > 0){
            digits.add(number%10);
            number = number/10;
        }

        int maxNumber = 0;
        n = digits.size();
        while (n-- > 0) {
            int a = Collections.max(digits);
            digits.remove((Integer) a);
            maxNumber = maxNumber * 10 + a;
        }

        System.out.println(maxNumber);

    }
}
