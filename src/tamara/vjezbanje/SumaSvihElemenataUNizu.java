package tamara.vjezbanje;

public class SumaSvihElemenataUNizu {
    public static void main(String[] args) {
        int[] zadatiNiz = {5, -1, 12, 6, 3};
        int suma = 0;

        for (int j : zadatiNiz)
            suma += j;

        System.out.println("Suma svih elemenata je: " + suma);
    }
}
