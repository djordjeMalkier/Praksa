package velickovj.nedelja03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class PozitivanNegativanTekst {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> pozitivneReci=new ArrayList<>();
        List<String> negativneReci=new ArrayList<>();

        pozitivneReci.add("ljubav");
        pozitivneReci.add("sreca");
        negativneReci.add("tuga");
        negativneReci.add("bol");

        Map<String, List<String>> mapa=new HashMap<>();
        mapa.put("POZITIVAN",pozitivneReci);
        mapa.put("NEGATIVAN",negativneReci);

        int brojacPozitivni=0;
        int brojacNegativni=0;
        File file=new File("src/velickovj/nedelja03/pesma.txt");
        Scanner scanner=new Scanner(file);
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.next();
            String line1= line.replaceAll("[().!?,;]", "");
           /* System.out.println(line);*/

            if(contains(mapa,line1.toLowerCase())) {
                if (anyKeyForValue(mapa, line1.toLowerCase()).equals("POZITIVAN"))
                    brojacPozitivni++;
                else if (anyKeyForValue(mapa, line1.toLowerCase()).equals("NEGATIVAN"))
                    brojacNegativni++;
            }


        }
      /* System.out.println(brojacPozitivni);
        System.out.println(brojacNegativni);*/



        if (brojacPozitivni > brojacNegativni)
            System.out.println("Tekst je pozitivan");
        else if(brojacPozitivni<brojacNegativni)
            System.out.println("Tekst je negativan");
        else
            System.out.println("Tekst nije ni pozitivan ni negativan");

    }
    static String anyKeyForValue(Map<String, List<String>> map, String value) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if(entry.getValue().contains(value)) return entry.getKey();
        }
        return null;
    }

    static boolean contains(Map<String, List<String>> map, String value) {
        for (List<String> list : map.values()) {
            if(list.contains(value)) return true;


        }
        return false;
    }
}
