package tamara.vjezbanje;

public class AritmetickaSredinaElemenataUNizu {
    public static void main(String[] args) {
        int[] zadatiNiz = {5, -1, 12, 6, 32};
        int suma = 0;
        int brojac = 0;
        double ariSredina;

        for (int j : zadatiNiz) {
            brojac++;
            suma += j;
        }

        ariSredina = (double)suma / brojac;

        System.out.println("Aritmeticka sredina je: " + ariSredina);
    }
}
