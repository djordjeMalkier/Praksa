package david.zadaci.nedelja04;

/*Najmanji desetocifren prost broj*/
public class Zadatak01 {
    public static void main(String[] args) {
        System.out.println(najmanjiDesetocifrenProst());
    }

    private static long najmanjiDesetocifrenProst() {
        for (long i = 1000000000L; i <= 9999999999L; i++) {
            if (isPrime(i))
                return i;
        }
        return -1;
    }

    private static boolean isPrime(long number) {
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
