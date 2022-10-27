package tamara.zadaci;

public class Dijamant {
    public static void main(String[] args) {
        int num = 26;
        char c = 'A';

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
                if(j <= i-1)
                   System.out.print(c++);
                else
                    System.out.print(c--);
            }

            System.out.println();
            c = 'A';
        }

        for (int i = num - 1; i > 0; i--) {

            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i * 2 - 1; j++) {
                if(j <= i-1)
                    System.out.print(c++);
                else
                    System.out.print(c--);
            }

            System.out.println();
            c = 'A';
        }
    }
}
