package tamara.zadaci;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PronadjiSamoglasnikeUTekstu {
    public static void main(String[] args) throws FileNotFoundException {
        File fajl = new File("C:\\Users\\Malkier_1\\IdeaProjects\\Praksa\\src\\common\\tekst.txt");

        Scanner skenFajl = new Scanner(fajl);

        int brojacSamoglasnika = 0;
        int maxBrojSamoglasnikaURijeci = 0;
        String rijecSaMaxSamoglasnika = " ";

        while (skenFajl.hasNextLine()) {
            String linija = skenFajl.nextLine();
            String[] podjela = linija.split("[ .,!?()/„“]");
            for (String rijec : podjela) {
                int brojSamoglasnikaURijeci = 0;
                for (int i = 0; i < rijec.length(); i++) {
                    if(rijec.toLowerCase().charAt(i) == 'a' || rijec.toLowerCase().charAt(i) == 'e'
                            || rijec.toLowerCase().charAt(i) == 'i' || rijec.toLowerCase().charAt(i) == 'o' || rijec.toLowerCase().charAt(i) == 'u') {
                        brojacSamoglasnika++;
                        brojSamoglasnikaURijeci++;
                    }
                }
                if(brojSamoglasnikaURijeci > maxBrojSamoglasnikaURijeci) {
                    maxBrojSamoglasnikaURijeci = brojSamoglasnikaURijeci;
                    rijecSaMaxSamoglasnika = rijec;
                }

            }
        }
        System.out.println("U tekstu ima ukupno: " + brojacSamoglasnika + " samoglasnika.");
        System.out.println("\nNajvise samoglasnika ima rijec: " + rijecSaMaxSamoglasnika);
        System.out.println("Ona ima: " + brojacSamoglasnika + " samoglasnika.");
    }
}
