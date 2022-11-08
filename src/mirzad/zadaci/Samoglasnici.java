package mirzad.zadaci;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Samoglasnici {
    public static void main(String[] args) throws FileNotFoundException {

        File text = new File("src/common/tekst.txt");
        Scanner sc = new Scanner(text);
       // sc.useDelimiter(" ");
        int max = 0;
        int sum = 0;
        String maxWord = "";
        char[] chars;

        while (sc.hasNext()){
            int count = 0;
            String word = sc.next();
            word = word.replaceAll("[ .,!?()„“:;]", "");

            chars = word.toLowerCase().toCharArray();

            for (char aChar : chars) {
                if (aChar == 'a' || aChar == 'e' || aChar == 'i' || aChar == 'o' || aChar == 'u') {
                    count++;
                }
            }

            sum += count;

            if (count > max) {
                max = count;
                System.out.println(word);
                maxWord = word;
            }

        }

        System.out.println(maxWord);
        System.out.println(sum);

    }
}
