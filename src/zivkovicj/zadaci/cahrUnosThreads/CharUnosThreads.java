package zivkovicj.zadaci.cahrUnosThreads;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CharUnosThreads {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        Character temp;
        String path = "C:\\Users\\Malkier_4\\IdeaProjects\\Praksa\\src\\zivkovicj\\zadaci\\cahrUnosThreads";


        //File f = null;

        System.out.println("Unesite karaktere:");

        while (scanner.hasNext()) {
            temp = scanner.next().charAt(0);
            int asciiValue = temp;
            if (Character.isAlphabetic(temp)) {
                if (Character.isLowerCase(temp)) {
                    String pathForLowerCase = path + "\\" + temp + ".txt";
                    Runnable thread = new CharThread(pathForLowerCase);
                    thread.run();
                    randomNumbers(asciiValue, 1, 1000, pathForLowerCase);

                } else {
                    String pathForUpperCase = path + "\\" + Character.toLowerCase(temp)
                            + "" + Character.toLowerCase(temp) + ".txt";
                    Runnable thread = new CharThread(pathForUpperCase);
                    thread.run();
                    randomNumbers(asciiValue, 1, 1000, pathForUpperCase);
                }
            } else {
                System.out.println("Morate uneti slovo");
            }


            System.out.println(asciiValue);
        }
        File fObj = new File(path);
        if(fObj.exists() && fObj.isDirectory())
        {
            File[] a = fObj.listFiles();
// display statements
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
            System.out.println("Displaying Files from the directory : " + fObj);
            System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
// Calling the method
            ispisFajlova(a, 0,0);
        }
    }

    public static void randomNumbers(int number, int from, int to, String path) {

        try (FileWriter fw = new FileWriter(path)) {
            Random randomNumber = new Random();
            randomNumber
                    .ints(number, from, to).forEach(x -> {
                        try {
                            fw.write(x + ",\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void ispisFajlova(File[] a, int i, int lvl) throws IOException {

        if(i == a.length)
        {
            return;
        }
// checking if the encountered object is a file or not
        if(a[i].isFile())
        {
            System.out.println(a[i].getName());
        }
// recursively printing files from the directory
// i + 1 means look for the next file
        ispisFajlova(a, i + 1, lvl);

    }
}