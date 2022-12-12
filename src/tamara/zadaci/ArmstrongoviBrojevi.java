package tamara.zadaci;

public class ArmstrongoviBrojevi {
    public static void main(String[] args) {
        int sumaCifara = 0;
        int brojacCifara = 0;
        int cifra;

        for (int i = 0; i <= 9999; i++) {
            int broj = i;
            int zadatiBroj = i;
            int broj2 = i;

            while(broj != 0) {
                broj /= 10;
                brojacCifara++;
            }

            while(broj2 != 0) {
                cifra = broj2 % 10;
                sumaCifara = (int) (sumaCifara + Math.pow(cifra, brojacCifara));
                broj2 /= 10;
            }

            if (sumaCifara == zadatiBroj) {
                System.out.print(zadatiBroj + " ");
            }

            brojacCifara = 0;
            sumaCifara = 0;
        }
    }
}
