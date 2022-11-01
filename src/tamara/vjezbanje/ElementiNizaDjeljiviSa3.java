package tamara.vjezbanje;

public class ElementiNizaDjeljiviSa3 {
    public static void main(String[] args) {
        int[] zadatiNiz = {5, -1, 12, 6, 33};
        int brojac = 0;

        System.out.println("Brojem 3 su djeljivi elementi: ");
        for (int j : zadatiNiz) {
            if (j % 3 == 0) {
                brojac++;
                System.out.print(j + " ");
            }
        }

        if (brojac == 0)
            System.out.println("Ne postoji element koji je djeljiv brojem 3.");
    }
}
