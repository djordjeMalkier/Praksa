package tamara.zadaci;

public class NajmanjiProstDesetocifren {
    public static void main(String[] args) {
        boolean prost;
        for (long i = 1000000000L; i <= 9999999999L; i++) {
            prost = true;
            long korijen = Math.round(Math.sqrt(i));
            for (int j = 2; j < korijen; j++)
                    if (i % j == 0) {
                    prost = false;
                    break;
                }
            if (prost) {
                System.out.print("Najmanji prost broj je: " + i);
                return;
            }
        }
    }
}
