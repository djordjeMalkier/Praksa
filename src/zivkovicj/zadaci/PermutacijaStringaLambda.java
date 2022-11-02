package zivkovicj.zadaci;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutacijaStringaLambda {
    public static void main(String[] args) {
        // program za proveru da li zadati i uneti string imaju iste karaktere
        String firstString = "abcdef";


        System.out.print("Zadati string: ");
        System.out.println(firstString);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite neki string:");
        String inputString = scanner.nextLine();

        Map<Character, Integer> map = IntStream.range(0, firstString.length())
                .boxed()
                .collect(Collectors.toMap(firstString.toLowerCase()::charAt, i -> 1, (x, y) -> x + 1));

        Map<Character, Integer> map2 = IntStream.range(0, inputString.length())
                .boxed()
                .collect(Collectors.toMap(
                inputString.toLowerCase()::charAt, i -> 1, (x, y) -> x + 1));

        if (map.equals(map2)) {
            System.out.println("Stringovi imaju iste karaktere");
        } else {
            System.out.println("Stringovi nemaju iste karaktere");
        }

        if (inputString.isEmpty()) {
            System.out.println("Niste uneli inputText");
            return;
        }

    }
}
