package tamara.zadaci.nisuIstiException;

import java.io.File;
import java.util.Scanner;

public class UserPassIstiKaoUFajlu {
    public static void main(String[] args) throws Exception {
        File fajl = new File("C:\\Users\\Malkier_1\\Desktop\\fajl.json");

        Scanner skenFajl = new Scanner(fajl);

        String[] stringovi = new String[2];
        int brojacLinija = 0;
        boolean zavrsiPetlju = false;

        String line;

        while (skenFajl.hasNextLine()) {
            line = skenFajl.nextLine();
            if (line.equals("{") || line.equals("}"))
                continue;
            stringovi[brojacLinija++] = line;
        }

        String username = stringovi[0].split(":")[1];
        String password = stringovi[1].split(":")[1];

        String us = username.split("\"")[1];
        String pass = password.split("\"")[1];

        System.out.println(us + " " + pass);

        Scanner ulaz = new Scanner(System.in);


        while(!zavrsiPetlju) {
            System.out.print("Unesi username: ");
            String ime = ulaz.nextLine();
            System.out.println("Unesi password: ");
            String sifra = ulaz.nextLine();

            try {
                if (!ime.equals(us) || !sifra.equals(pass)) {
                    throw new NisuIstiException("Nisu isti.");
                }
                else {
                    zavrsiPetlju = true;
                    System.out.println("Isti su");
                }
            } catch (NisuIstiException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
