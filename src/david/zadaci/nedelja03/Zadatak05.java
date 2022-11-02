package david.zadaci.nedelja03;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Zadatak05 {
    public static void main(String[] args) {
        String str1 = "aba", str2 = "Baa";
        Map<Character, Integer> map1 = IntStream.range(0, str1.length())
                .boxed()
                .collect(Collectors.toMap(str1.toLowerCase()::charAt, i -> 1, (a, b) -> a + 1));
        Map<Character, Integer> map2 = IntStream.range(0, str2.length())
                .boxed()
                .collect(Collectors.toMap(str2.toLowerCase()::charAt, i -> 1, (a, b) -> a + 1));

        System.out.println(map1.equals(map2));
    }
}
