package tamara.zadaci;

import java.math.BigInteger;

public class PrviProstBrojUStringu {
    public static void main(String[] args) {
        String zadatiString = "15619338422195";

        System.out.println(prviProstKojiSeNePonavlja(zadatiString));
    }
    public static String prviProstKojiSeNePonavlja(String zadatiString) {
        for (int i = 1; i <= zadatiString.length(); i++) {
            for (int j = 0; j <= zadatiString.length() - i; j++) {
                String podNiz = zadatiString.substring(j, j + i);
                if (daLiJeBroj(podNiz)) {
                    BigInteger broj = new BigInteger(podNiz);
                    if (broj.isProbablePrime(99)) {
                        if (!zadatiString.substring(0, j)
                                .concat(zadatiString.substring(j + i))
                                .contains(podNiz)) {
                            System.out.println(zadatiString.substring(0, j));
                            System.out.println(zadatiString.substring(j + i));
                            return podNiz;
                        }
                    }
                }
            }
        }
        return "Nema prostih brojeva koji se ne ponavljaju.";
    }
    public static boolean daLiJeBroj(String podNiz) {
        for (char cifra : podNiz.toCharArray()) {
            if (!Character.isDigit(cifra)) {
                return false;
            }
        }
        return true;
    }
}
