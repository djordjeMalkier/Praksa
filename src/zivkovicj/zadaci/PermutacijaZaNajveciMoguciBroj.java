package zivkovicj.zadaci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class PermutacijaZaNajveciMoguciBroj {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite neki broj:");
        int number = scanner.nextInt();
        int length = Integer.toString(number).length();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            list.add(number % 10);
            number /= 10;
        }

        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int digit: list){
            sb.append(digit);
        }

        System.out.println("Najveci moguci broj: " + sb);

    }
}
