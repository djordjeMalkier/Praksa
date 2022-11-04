package zivkovicj.zadaci.pozitivneNegativneReci;

import zivkovicj.zadaci.textFileZadatak.NotValidCredentialsException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PozitivneNegativneReci {
    public static void main(String[] args) {

        String path = "C:\\Users\\Malkier_4\\IdeaProjects\\Praksa\\src\\zivkovicj\\zadaci\\pozitivneNegativneReci\\pozitiveNegativne.txt";

        Map<String, List<String>> mapaStringova = new HashMap<>();
        List<String> listaPozitivnih = new ArrayList<>(Arrays.asList("ljubav", "sreca", "radost"));
        mapaStringova.put("pozitivne", listaPozitivnih);
        List<String> listaNegativnih = new ArrayList<>(Arrays.asList("tuga", "bol", "plac"));
        mapaStringova.put("negativne", listaNegativnih);

        getValues(mapaStringova);
    }

    public static void getValues(Map<String, List<String>> mapaStringova) {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream("C:\\Users\\Malkier_4\\IdeaProjects\\Praksa\\src\\zivkovicj\\zadaci\\pozitivneNegativneReci\\pozitiveNegativne.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String strLine;
        ArrayList<String> lines = new ArrayList<String>();
        int counter1 = 0;
        int counter2 = 0;
        try {
            while ((strLine = reader.readLine()) != null) {
                strLine.replaceAll("[,!?()]", "");
                List<String> pozitivne = mapaStringova.get("pozitivne");
                List<String> negativne = mapaStringova.get("negativne");

                String[] words = strLine.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (pozitivne.contains(words[i])) {
                        counter1++;
                    } else if (negativne.contains(words[i])) {
                        counter2++;
                    }
                }

                if (counter1 > counter2) {
                    System.out.println("Ima vise pozitivnih:" + counter1);
                } else if (counter1 < counter2) {
                    System.out.println("Ima vise negativnih:" + counter2);
                } else {
                    System.out.println("Isto");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
