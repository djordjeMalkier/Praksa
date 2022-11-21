package zivkovicj;

public class ProstBroj {
    public static void main(String[] args) {
        //najmanji desetocifreni prost broj
        // 1000000000 - 9999999999
        long smallest = 1000000000L;
        long biggest = 9999999999L;
        for (long i = smallest; i <= biggest; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    private static boolean isPrime(long n) {
        long count = 0;
        if (n < 2) {
            return false;
        }
        for (long i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
