package tamara.vjezbanje;

public class NizUObrnutomRedosledu {
    public static void main(String[] args) {
        int[] zadatiNiz = {5, -1, 12, 6, 33};
        int[] obrnutiNiz = new int[zadatiNiz.length];

        int j = 0;
        for (int i = zadatiNiz.length - 1; i >= 0; i--) {
            obrnutiNiz[j++] = zadatiNiz[i];
        }

        System.out.println("Zadati niz: ");
        for (int element : zadatiNiz) {
            System.out.print(element + " ");
        }

        System.out.println("\nObrnuti niz: ");
        for (int element : obrnutiNiz) {
            System.out.print(element + " ");
        }
    }
}
