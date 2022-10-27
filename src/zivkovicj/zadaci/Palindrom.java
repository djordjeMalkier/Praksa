package zivkovicj.zadaci;

import java.util.Arrays;
import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite neki string:");

        String tekst = scanner.nextLine();
        StringBuilder obrnutiString = new StringBuilder();

        for (int i = tekst.length()-1; i >=0 ; i--) {
            obrnutiString.append(tekst.charAt(i));
        }
        if(tekst.toLowerCase().equals(obrnutiString.toString())){
            System.out.println(tekst + " je palindrom");
        } else {
            System.out.println(tekst + " nije palindrom");
        }// invertujemo string

    }
}
