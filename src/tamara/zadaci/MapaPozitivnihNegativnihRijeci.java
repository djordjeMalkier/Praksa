package tamara.zadaci;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MapaPozitivnihNegativnihRijeci {
    public static void main(String[] args) throws IOException {
        Map<String, List<String>> pozitivneNegativneRijeci = new HashMap<>();
        pozitivneNegativneRijeci.put("pozitivne", new ArrayList<>(Arrays.asList("mladog", "leto", "srcu", "pevaj")));
        pozitivneNegativneRijeci.put("negativne", new ArrayList<>(Arrays.asList("hladno", "ubila", "lutam", "pijan", "tuzno")));
        File fajl = new File("C:\\Users\\Malkier_1\\Desktop\\rijeci.txt");

        Scanner skenFajl = new Scanner(fajl);

        String linija;
        int brojacPozitivnih = 0;
        int brojacNegativnih = 0;

        while (skenFajl.hasNextLine()) {
            linija = skenFajl.nextLine();
            String[] podjela = linija.split("[ .,!?()/]");
            for (String rijec : podjela) {
                if(pozitivneNegativneRijeci.get("pozitivne").contains(rijec.toLowerCase()))
                    brojacPozitivnih++;
                if(pozitivneNegativneRijeci.get("negativne").contains(rijec.toLowerCase()))
                    brojacNegativnih++;
            }
        }

        if(brojacNegativnih > brojacPozitivnih) {
            System.out.println("Ima vise negativnih rijeci.");
            System.out.println(brojacNegativnih);
            System.out.println(brojacPozitivnih);
        }
        else if(brojacPozitivnih > brojacNegativnih) {
            System.out.println("Vise ima pozitivnih rijeci.");
            System.out.println(brojacNegativnih);
            System.out.println(brojacPozitivnih);
        }
        else
            System.out.println("Ima jednak broj pozitivnih i negativnih rijeci.");
    }
}
