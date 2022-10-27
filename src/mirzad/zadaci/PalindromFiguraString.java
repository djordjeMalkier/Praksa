import java.util.Scanner;

public class Main {
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
        char[] str = new char[]
    }
}