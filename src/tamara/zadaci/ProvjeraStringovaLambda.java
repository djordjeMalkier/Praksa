package tamara.zadaci;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProvjeraStringovaLambda {
    public static void main(String[] args) {
        String s1 = "Lak";
        Scanner ulaz = new Scanner(System.in);
        System.out.print("Unesi string: ");
        String s2 = ulaz.next();

        ulaz.close();

                                                                                                        //duzi nacin pravljenja lambda izraza
        Map<Character, Integer> mapa1 = IntStream.range(0, s1.length()).boxed().collect(Collectors.toMap(i -> s1.toLowerCase().charAt(i),  i -> 1, (x, y) -> x+1));
                                                                                                        //duzi nacin pravljenja lambda izraza
        Map<Character, Integer> mapa2 = IntStream.range(0, s2.length()).boxed().collect(Collectors.toMap(s2.toLowerCase() :: charAt, i -> 1, (x, y) -> x+1));

        if(mapa1.equals(mapa2)) {
            System.out.println("String: " + s2 + " JESTE permutacija stringa: " + s1);
        } else
            System.out.println("String: " + s2 + " NIJE permutacija stringa: " + s1);

    }
}
