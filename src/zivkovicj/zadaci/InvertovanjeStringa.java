package zivkovicj.zadaci;

import java.util.Scanner;

public class InvertovanjeStringa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite neki string:");

        String tekst = scanner.nextLine();
        StringBuilder obrnutiString = new StringBuilder();

        for (int i = tekst.length()-1; i >=0 ; i--) {
            obrnutiString.append(tekst.charAt(i));
        }
        System.out.println(obrnutiString);
    }
}
