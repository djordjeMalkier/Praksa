package zivkovicj.zadaci.textFileZadatak;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TextFileZadatak {
    public static void main(String[] args) {

        String path = "C:\\Users\\Malkier_4\\IdeaProjects\\Praksa\\src\\zivkovicj\\zadaci\\textFileZadatak\\kredencijali.json";
        String[] niz = new String[2];

        try{
            niz = credentials(path);

        }catch (NotValidCredentialsException | FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        System.out.println(niz[0]);
        System.out.println(niz[1]);
    }
    public static String[] credentials(String path) throws NotValidCredentialsException, FileNotFoundException {
        File file = new File(path);

        Scanner scanner = new Scanner(file);

        String[] stringovi = new String[2];
        int i = 0;
        String line;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("{") || line.equals("}"))
                continue;
            stringovi[i++] = line;
        }

        String username = stringovi[0].split(":")[1];
        String password = stringovi[1].split(":")[1];

        String[] strings = new String[2];

        strings[0] = username.split("\"")[1];
        strings[1] = password.split("\"")[1];
        scanner.close();
        return strings;

    }

}
