package david.zadaci.nedelja02;

public class Zadatak01 {
    public static void main(String[] args) {
        int n = 15;
        trougao(n);
    }

    private static void trougao(int n) {
        int num = 0;
        for (int i = 0; i < n/2-2; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(++num + " ");
            }
            System.out.println();
        }
    }
}
