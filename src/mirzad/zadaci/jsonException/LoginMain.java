package mirzad.zadaci.jsonException;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginMain {
    public static void main(String[] args) throws LoginException {
        Scanner scanner = new Scanner(System.in);
        String[] credentials = new String[2];
        boolean checked = false;

        try{
            credentials = parse("C:\\Users\\Malkier_2\\Documents\\Zadaci\\Praksa\\src\\mirzad\\zadaci\\jsonException\\login.json");
        }catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }


        while (!checked) {
            try {
                checked = insert(scanner, credentials[0], credentials[1]);
            } catch (LoginException exception) {
                System.out.println(exception.getMessage());
            }
        }

        System.out.println("Ulogovani ste.");

    }

    private static boolean insert(Scanner scanner, String username, String password) throws LoginException {
        String insertedUsername = "";
        String insertedPassword = "";

        System.out.println("Unesite username: ");
        insertedUsername = scanner.nextLine();

        System.out.println("Unesite Pasword");
        insertedPassword = scanner.nextLine();

        if(!insertedUsername.equals(username) || !insertedPassword.equals(password)) {
            throw new LoginException("Pogresan password ili username.");
        }

        return true;
    }

    private static String[] parse(String path) throws FileNotFoundException {
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


