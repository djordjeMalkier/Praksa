package zivkovicj.zadaci;

import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumbers {
    public static void main(String[] args) {

        for (int i = 0; i <= 9999; i++) {
            sumDigits(i);
            if (i == sumDigits(i)) {
                System.out.println(i);
            }
        }
    }

    public static List<Integer> getDigits(int number) {
        List<Integer> list = new ArrayList<>();

        while (number != 0) {
            list.add(number % 10);
            number = number / 10;
        }
        return list;
    }

    public static int sumDigits(int number) {
        int sum = 0;
        for (int digit : getDigits(number)) {
            sum += Math.pow(digit, getDigits(number).size());
        }
        return sum;
    }
}
