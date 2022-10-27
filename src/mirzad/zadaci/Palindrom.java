import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        if(inputString.isEmpty()) return;

        inputString.toLowerCase();

        char[] chars = inputString.toCharArray();

        int n,a;
        a = inputString.length() / 2;
        n = inputString.length() - 1;

        for (int i = 0; i < a; i++){
            if (chars[i] != chars[n--]) {
                System.out.println("Nije palindrom.");
                return;
            }
        }
        System.out.println("Jeste palindrom.");
        scanner.close();
    }
}