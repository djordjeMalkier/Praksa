package david.zadaci.nedelja03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zadatak06 {
    public static void main(String[] args) {
        List<Integer> firstArray = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> secondArray = new ArrayList<>(Arrays.asList(2,3,5,6,7));

        List<Integer> tmp = firstArray.stream()
                .filter(e -> !secondArray.contains(e))
                .toList();

        secondArray.addAll(tmp);

        secondArray.forEach(System.out::println);
    }
}
