package mirzad.zadaci;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutacijaLambda {
    public static void main(String[] args) {
        String permutationString = "baab";
        String inputString = "";

        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextLine()){
           inputString = scanner.nextLine();
        } else {
            System.out.println("Pogresan unos!");
            System.exit(0);
        }

        Map<Character,Integer> mapa = IntStream.range(0,permutationString.length()).boxed().collect(Collectors.toMap(permutationString.toLowerCase()::charAt, integer -> 1, (x, y) -> x+1));
        Map<Character,Integer> mapa2 = IntStream.range(0,inputString.length()).boxed().collect(Collectors.toMap(inputString.toLowerCase()::charAt, integer -> 1, (x, y) -> x+1));

       if(mapa.equals(mapa2)) System.out.println("Jeste permutacija.");
       else System.out.println("Nije permutacija.");




    }
}
