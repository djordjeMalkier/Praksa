package mirzad.zadaci;

import java.util.Scanner;

public class Cifre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(sc.hasNextInt()) {
            int number = sc.nextInt();
            number = Math.abs(number);

            while (number / 10 > 0) {
                number = saberiCifre(number);
            }

            switch (number) {
                case 0 -> System.out.println("NULA");
                case 1 -> System.out.println("JEDAN");
                case 2 -> System.out.println("DVA");
                case 3 -> System.out.println("TRI");
                case 4 -> System.out.println("CETIRI");
                case 5 -> System.out.println("PET");
                case 6 -> System.out.println("SEST");
                case 7 -> System.out.println("SEDAM");
                case 8 -> System.out.println("OSAM");
                case 9 -> System.out.println("DEVET");
            }
        } else System.out.println("Uneli ste pogresno.");

    }

    private static int saberiCifre(int num){
        int newNum = 0;
        while (num>0){
            int digit = num % 10;
            newNum = newNum + digit;
            num = num/10;
        }
        return newNum;
    }
}