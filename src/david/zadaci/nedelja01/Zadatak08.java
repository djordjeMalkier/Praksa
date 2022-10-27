package david.zadaci.nedelja01;

import java.util.Scanner;

public class Zadatak08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            try {
                System.out.println(digitToString(sumToOneDigit(sc.nextInt())));
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Invalid number");
            }
        }
        sc.close();
    }

    private static String digitToString(int num) throws IndexOutOfBoundsException {
        return switch (num) {
            case 0 -> "nula";
            case 1 -> "jedan";
            case 2 -> "dva";
            case 3 -> "tri";
            case 4 -> "ceriti";
            case 5 -> "pet";
            case 6 -> "sest";
            case 7 -> "sedam";
            case 8 -> "osam";
            case 9 -> "devet";
            default -> throw new IndexOutOfBoundsException("Number is not a digit");
        };
    }

    private static int sumToOneDigit(int num) {
        num = Math.abs(num);
        while (num >= 10)
            num = sumOfDigits(num);
        return num;
    }

    private static int sumOfDigits(int num) {
        num = Math.abs(num);
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
