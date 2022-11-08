package zivkovicj.zadaci;

import java.io.*;

public class Samoglasnici {
    public static void main(String[] args) {

        FileInputStream stream = null;
        try {
            stream = new FileInputStream("C:\\Users\\Malkier_4\\IdeaProjects\\Praksa\\src\\common\\tekst.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String strLine;
        int counter2 = 0;
        int max = 0;
        String recSaNajviseSamoglasnika = "";

        try {
            while ((strLine = reader.readLine()) != null) {
                String[] words = strLine.split("[ ,!?()„.“]");
                for (String s : words) {
                    int counter = 0;
                    for (int j = 0; j < s.length(); j++) {
                        char karakter = s.charAt(j);
                        if (karakter == 'a' || karakter == 'e' || karakter == 'i' || karakter == 'o'
                                || karakter == 'u' || karakter == 'A' || karakter == 'E' || karakter == 'I' || karakter == 'O'
                                || karakter == 'U') {
                            counter2++;
                            counter++;
                        }
                    }
                    if (counter > max) {
                        max = counter;
                        recSaNajviseSamoglasnika = s;
                    }
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
        System.out.println("Broj samoglasnika u tekstu: " + counter2);
        System.out.println("Rec sa najvise samoglasnika: " + recSaNajviseSamoglasnika);
    }
}
