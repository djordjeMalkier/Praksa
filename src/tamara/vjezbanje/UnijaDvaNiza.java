package tamara.vjezbanje;

import java.util.ArrayList;
import java.util.List;

public class UnijaDvaNiza {
    public static void main(String[] args) {
        int[] zadatiNiz1 = {4, 5, 8, -3, 12, -4, 4};
        int[] zadatiNiz2 = {10, -8, -3, 12, 12, 4};
        List<Integer> unijaNizova = new ArrayList<>();

        for (int elNiza1 : zadatiNiz1) {
            if(!unijaNizova.contains(elNiza1))
                unijaNizova.add(elNiza1);
        }

        for (int elNiza2 : zadatiNiz2) {
            if (!unijaNizova.contains(elNiza2))
                unijaNizova.add(elNiza2);
        }

        System.out.println("Unija: " + unijaNizova);
    }
}
