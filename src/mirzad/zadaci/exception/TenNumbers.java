package mirzad.zadaci.exception;

import java.util.ArrayList;
import java.util.Scanner;

public class TenNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        int n = 10;

        while (n > 0) {
            try {
                n--;
              addToList(numbersList,scanner);
            } catch (ThreeException e) {
                count++;
                System.out.println(e.toString());
            }
        }

        numbersList.forEach(System.out::println);
        System.out.println("Broj deljivih sa tri: " + count);

    }

    public static void addToList(ArrayList<Integer> list, Scanner scanner) throws ThreeException {
        int a = scanner.nextInt();
        if (a % 3 == 0) {
            throw new ThreeException("Broj je deljiv sa tri!");
        }
        list.add(a);
    }

}
