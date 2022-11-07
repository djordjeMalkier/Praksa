package mirzad.zadaci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnijaDvaNiza {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7,8};
        Integer[] array2 = {3,4,5,8};

       List<Integer> list = new ArrayList<>(Arrays.asList(array));
       List<Integer> list2 = new ArrayList<>(Arrays.asList(array2));

        List<Integer> zajednicka = list.stream().filter(list2::contains).toList();

        System.out.println(zajednicka);

    }
}
