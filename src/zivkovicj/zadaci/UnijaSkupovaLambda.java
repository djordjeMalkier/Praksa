package zivkovicj.zadaci;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnijaSkupovaLambda {
    public static void main(String[] args) {

        /* Unija skupova */

        List<Integer> skup1 = new ArrayList<>();
        List<Integer> skup2 = new ArrayList<>();

        skup1.add(1);
        skup1.add(3);
        skup1.add(5);

        skup2.add(1);
        skup2.add(5);
        skup2.add(2);

        List<Integer> istiElementi = skup1
                .stream()
                .filter(skup2::contains).toList();

        istiElementi.forEach(System.out::println);

    }
}
