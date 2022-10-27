package permutationMap;

import java.util.*;

public class PermutationMap {
    public static void main(String[] args) {
        String permutationString = "baab";
        boolean flag = true;

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        if (permutationString.length() != inputString.length()) {
            System.out.println("Nije permutacija");
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < inputString.length(); i++) {
            if (map.containsKey(inputString.charAt(i)))
                map.put(inputString.charAt(i), map.get(inputString.charAt(i)) + 1);
            else map.put(inputString.charAt(i), 1);
            if (map.containsKey(permutationString.charAt(i)))
                map.put(permutationString.charAt(i), map.get(permutationString.charAt(i)) - 1);
            else map.put(permutationString.charAt(i), 1);

        }

        Collection<Integer> list = map.values();
        Iterator iterator = list.iterator();

        // Prolazi se kroz mapu i trazi se ako postoji vrednost koja nije 0!
    }
}
