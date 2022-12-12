package david.zadaci.razno;

import java.util.ArrayList;
import java.util.List;

//svi armstrongovi brojevi do 4-cifenih (ukljucujuci)
public class ArmstrongNumbers {
    public static void main(String[] args) {
        armstrongNumbersList(9999).forEach(System.out::println);
    }

    private static List<Integer> armstrongNumbersList(int n) {
        List<Integer> armstrongList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> digits = digits(i);

            int digitSum = digits.stream()
                    .map(num -> (int) Math.pow(num, digits.size()))
                    .reduce(0, Integer::sum);

            if (digitSum == i)
                armstrongList.add(i);
        }
        return armstrongList;
    }

    private static List<Integer> digits(int num) {
        List<Integer> digitList = new ArrayList<>();
        while (num != 0) {
            digitList.add(num % 10);
            num /= 10;
        }
        return digitList;
    }
}
