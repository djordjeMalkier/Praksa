package zivkovicj.zadaci;

public class NoDuplicates {
    public static void main(String[] args) {
        // program koji ispisuje sve brojeve koji se pojavljajuju samo jednom i broj koji se pojavljuje najvise puta
        int[] arr = {1, 2, 2, 1, 4, 5, 6, 5, 15, 5, 8, 5};

        int max = 0;
        int mostRepeatedElement = 0;

        System.out.print("Brojevi koji se ne ponavljaju: ");
        for (int i : arr) {
            int brojac = 0;
            for (int j : arr) {
                if (i == j) {
                    brojac++;
                }
            }
            // print one koji nisu duplikati
            if (brojac == 1) {
                System.out.print(i + " ");
            }
            // max broj ponavljanja
            if (brojac > max) {
                max = brojac;
                mostRepeatedElement = i;
            }
        }
        System.out.println();
        System.out.println("Broj sa najvise ponavljanja: " + mostRepeatedElement);
    }
}
