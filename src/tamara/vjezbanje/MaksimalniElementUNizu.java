package tamara.vjezbanje;

public class MaksimalniElementUNizu {
    public static void main(String[] args) {
        int[] zadatiNiz = {5, -1, 12, 6, 33};
        int maxElement = zadatiNiz[0];

        for (int j : zadatiNiz)
            if (j >= maxElement)
                maxElement = j;

        System.out.println("Maksimalni element u nizu je: " + maxElement);
    }
}
