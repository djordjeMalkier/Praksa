package david.zadaci.nedelja03.zadatak09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/* String - Lista
* Mapa kljuc pozitivan, kljuc negativan, vrednost lista stringova
* U fajl imamo tekst
* Procitati fajl
* i videti da li ima vise pozitivnih ili negativnih
* */
public class Zadatak09 {
    public static void main(String[] args) {
        Map<String, List<String>> positiveAndNegativeWords = new HashMap<>();
        positiveAndNegativeWords.put("positive", new ArrayList<>(Arrays.asList("ljubav", "nada", "vera", "lepih", "divnom")));
        positiveAndNegativeWords.put("negative", new ArrayList<>(Arrays.asList("patnja", "mrznja", "smrt")));
        String pathToFile = "C:\\Users\\Malkier_3\\IdeaProjects\\Praksa\\src\\david\\zadaci\\nedelja03\\zadatak09\\tekst.txt";

        try {
            if(isTextPositive(positiveAndNegativeWords, readWordsFromFile(pathToFile)))
                System.out.println("There are more positive words");
            else
                System.out.println("There are more negative words");
        } catch (FileNotFoundException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean isTextPositive(Map<String, List<String>> positiveAndNegativeWords, List<String> words)
                           throws NullPointerException {

        if (positiveAndNegativeWords == null)
            throw new NullPointerException("Map with positive and negative words is null");
        if (words == null)
            throw new NullPointerException("Input text is null");

        int positiveWords = 0, negativeWords = 0;
        for (String word : words) {
            if (positiveAndNegativeWords.get("positive").contains(word))
                positiveWords++;
            else if (positiveAndNegativeWords.get("negative").contains(word))
                negativeWords++;
        }
        return positiveWords > negativeWords;
    }


    private static  List<String> readWordsFromFile(String path) throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File(path));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] splitLineBySpace = line.split(" ");
                for (String word : splitLineBySpace)
                    words.add(word.replaceAll("[.!?,()]", "")
                                  .toLowerCase());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + " not found");
        }
        return words;
    }
}
