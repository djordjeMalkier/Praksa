package david.zadaci.nedelja03;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
* Za dva stringa proverava da li imaju isti skup reci preko lambda izraza
* */
public class Zadatak05 {
    public static void main(String[] args) {
        String str1 = "aba", str2 = "Baa";
        Map<Character, Integer> map1= makeMap(str1);
        Map<Character, Integer> map2 = makeMap(str2);
        System.out.println(map1.equals(map2));
    }

    private static Map<Character, Integer> makeMap(String inputString) {
        return IntStream.range(0, inputString.length())
                .boxed()
                .collect(Collectors.toMap(inputString.toLowerCase()::charAt, i -> 1, (a, b) -> a + 1));
    }
}
