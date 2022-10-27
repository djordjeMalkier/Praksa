package zivkovicj.zadaci;

import java.util.Scanner;

public class SaberiCifreDoJednocifrenog {
    public static void main(String[] args) {
        // program koji sabira sve cifre dok se ne dobije jednocifreni broj koji se ispisuje recima
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite neki broj:");

        int number = scanner.nextInt();

        while (number > 9){
            number = sumDigits(number);
            System.out.print(display(number));
        }
    }

    public static int sumDigits(int number){
        int sum = 0;

        while (number > 0){
            sum += number % 10;
            number /= 10;
        }
        return  sum;
    }
    public static String display(int number){
        return switch (number) {
            case 1 -> "Jedan";
            case 2 -> "Dva";
            case 3 -> "Tri";
            case 4 -> "Cetiri";
            case 5 -> "Pet";
            case 6 -> "Sest";
            case 7 -> "Sedam";
            case 8 -> "Osam";
            case 9 -> "Devet";
            default -> "";
        };
    }

}
