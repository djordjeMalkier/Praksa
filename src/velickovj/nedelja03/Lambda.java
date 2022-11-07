package velickovj.nedelja03;


import java.util.Map;
import java.util.Scanner;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambda {
    public static void main(String[] args) {
        String s1="jovanaaa";
        Scanner scanner = new Scanner(System.in);
        String s2=scanner.next();
        if(daLiJePermutacija(s1,s2))
            System.out.println("String "+s2+" jeste permutacija stringa "+s1);
        else
            System.out.println("String "+s2+" nije permutacija stringa "+s1);
        scanner.close();
    }



    public static boolean daLiJePermutacija(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;

        Map<Character, Integer> prviString= IntStream
                .range(0,s1.length())
                .boxed()
                .collect(Collectors.toMap(s1.toLowerCase()::charAt, i->1,(x, y)->x+1));
        Map<Character, Integer> drugiString= IntStream
                .range(0,s2.length())
                .boxed()
                .collect(Collectors.toMap(s2.toLowerCase()::charAt, i->1,(x, y)->x+1));

        return prviString.equals(drugiString);
    }
}
