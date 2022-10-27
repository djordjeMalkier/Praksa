import java.util.Scanner;

public class PalindromFigura {
    public static void main(String[] args) {
        System.out.println("Unesite zeljeno slovo: ");
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        if(a.length() > 1) {
            System.out.println("Unesite samo jedno slovo!");
            return;
        }

        char ch = a.toCharArray()[0];
        if (ch - 64 < 1 || ch - 64 > 26) {
            System.out.println("Mora biti veliko slovo!");
            return;
        }
        draw((ch - 64)*2);
    }

    private static void draw(int n){
        char ch = 'A', empty = ' ';
        int count = 0, count2 = 1;

        for (int i = 1; i <= n; i++) {
            if (i <= n / 2) {
                for (int j = 1; j <= n - 1; j++) {
                    if (j < n / 2 - count || j > n / 2 + count) {
                        System.out.print(empty);
                    }
                    else {
                        System.out.print(ch);
                        if (j >= n/2 ) ch--;
                        else ch++;
                    }
                }
                ch = 'A';
                count++;
                System.out.println();
            }
            else {
                ch = 'A';
                for (int j = 1; j <= n-1 ;j++){
                    if(j <= count2 || j >= n - count2) System.out.print(empty);
                    else {
                        System.out.print(ch);
                        if (j >= n/2 ) ch--;
                        else ch++;
                    }
                }
                ch = 'A';
                count2+=1;
                System.out.println();
            }
        }
    }
}