package david.zadaci.nedelja04.CharacterFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/*
* unosi se karakter (novi tred)
* za svaki se kreira fajl sa nazivom tog karaktera
* A - aa.txt, a - a.txt
* U fajl se upisuje niz random brojeva u opsegu (1..1000), duzine ASCII vrednosti slova (A - 65 random brojeva)
* program se prekida kada se unese isti karakter
* i ispisuje se lista fajlova
* */
public class Zadatak02 {

    private static final String currentPath = "C:\\Users\\Malkier_3\\IdeaProjects\\Praksa\\src\\david\\zadaci\\nedelja04\\CharacterFile";


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNext())
                throw new InputMismatchException("Input error");

            char inputChar = scanner.next().charAt(0);
            System.out.println(fileExists(inputChar));

            try (FileWriter fileWriter = new FileWriter(pathToFile(inputChar))) {
                WriteMessageToFile writer = new WriteMessageToFile(fileWriter, inputChar);
                writer.run();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (InputMismatchException ime) {
            System.err.println(ime.getMessage());
        }
    }

    private static String pathToFile(char inputChar) {
        String path;
        if (Character.isLowerCase(inputChar))
            path = inputChar + ".txt";
        else
            path = Character.toLowerCase(inputChar) + "" + Character.toLowerCase(inputChar) + ".txt";

        return currentPath + "\\" + path;
    }

    private static boolean fileExists(char inputChar) {
        File file = new File(currentPath);
        if (file.listFiles() == null) return false;

        for (File f : Objects.requireNonNull(file.listFiles())) {
            System.out.println(f);
            if (f.isFile()) {
                String fileName = f.getName().split("\\.")[0];
                if (fileName.length() == 2)
                    return fileName.charAt(0) == inputChar && fileName.charAt(1) == inputChar;
                else if (fileName.length() == 1)
                    return fileName.charAt(0) == inputChar;
            }
        }
        return false;
    }
}
