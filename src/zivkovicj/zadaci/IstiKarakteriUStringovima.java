package zivkovicj.zadaci;

import java.util.Arrays;
import java.util.Scanner;

public class IstiKarakteriUStringovima {
    public static void main(String[] args) {
        // program za proveru da li zadati i uneti string imaju iste karaktere
        String text = "abcdef";
        char[] textChar = text.toCharArray();

        System.out.print("Zadati string: ");
        System.out.println(text);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite neki string:");
        String inputText = scanner.nextLine();

        char [] inputChar= inputText.toCharArray();

        if (inputText.isEmpty()){
            System.out.println("Niste uneli inputText");
            return;
        }
        if(textChar.length != inputChar.length){
            System.out.println("Nema iste karaktere.");
            return;
        }
        Arrays.sort(textChar);
        Arrays.sort(inputChar);

        for (int i = 0; i < text.length(); i++) {
            if(textChar[i] != inputChar[i]){
                System.out.println("Nemaju iste karaktere.");
                return;
            }
        }
        System.out.println("Ovaj string ima iste karaktere.");

    }

}
