package mirzad.zadaci.parsiranjePozitivanFajl;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParsiranjeMain {
    public static void main(String[] args) {
        ArrayList<String> words = getValues();
        int positiveCount = 0;
        int negativeCount = 0;
        int notFound = 0;

        ArrayList<String> positives = new ArrayList<>();
        addPositiveWords(positives);

        ArrayList<String> negatives = new ArrayList<>();
        addNegativeWords(negatives);

        Map<String,ArrayList<String>> positiveAndNegative = new HashMap<>();

        positiveAndNegative.put("Pozitivne", positives);
        positiveAndNegative.put("Negativne", negatives);

        for (String word : words){
                int a = checkWord(word,positiveAndNegative.get("Pozitivne"),positiveAndNegative.get("Negativne"));
                if (a > 0) positiveCount++;
                else if (a < 0) negativeCount++;
                else notFound++;
        }

        System.out.println(
                "Broj pozitivnih: " + positiveCount +
                "\nBroj negativnih: " + negativeCount +
                "\nNije nadjeno: " + notFound
        );

        if (positiveCount > negativeCount) System.out.println("Ima vise pozitivnih reci!");
        else System.out.println("Vise je negativnih reci.");


    }

    public static ArrayList<String> getValues() {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream("C:\\Users\\Malkier_2\\Documents\\Zadaci\\Praksa\\src\\mirzad\\zadaci\\parsiranjePozitivanFajl\\tekst");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String strLine;
        ArrayList<String> lines = new ArrayList<String>();
        try {
            while ((strLine = reader.readLine()) != null) {
                String [] words = strLine.split(" ");
                lines.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static void addPositiveWords(ArrayList<String> list){
        list.add("lep");
        list.add("srecan");
        list.add("dobro");
        list.add("Moët");

    }
    private static void addNegativeWords(ArrayList<String> list){
        list.add("tuzno");
        list.add("tugujem");
        list.add("ubila");
        list.add("laz");

    }

    private static int checkWord(String word, ArrayList<String> positives, ArrayList<String> negatives){
        for (String test : positives){
            if(word.toLowerCase().contains(test.toLowerCase())) {
                return 1;
            }

        }

        for (String test : negatives){
            if(word.toLowerCase().contains(test.toLowerCase())) {
                return -1;
            }
        }

        return 0;
    }
}
