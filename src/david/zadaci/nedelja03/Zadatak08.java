package david.zadaci.nedelja03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
* Provera username i password iz fajla
* */
public class Zadatak08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input username and password:");

        Map<String, String> userNameAndPassword = null;
        try {
            userNameAndPassword = readUserAndPassFromFile(
                    "C:\\Users\\Malkier_3\\IdeaProjects\\Praksa\\src\\david\\zadaci\\nedelja03\\user.json");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        String inputUser, inputPass;
        boolean endRead = false;

        while (!endRead){
            try {
                inputUser = readLine(scanner);
                inputPass = readLine(scanner);
                checkUserAndPassword(userNameAndPassword, inputUser, inputPass);
                System.out.println("Success!");
                endRead = true;
            } catch (InputValue iv) {
                System.err.println(iv.getMessage());
            } catch (NoSuchElementException nse) {
                endRead = true;
                System.err.println(nse.getMessage());
            }
        }
        scanner.close();
    }

    private static String readLine(Scanner scanner) throws NoSuchElementException {
        if(!scanner.hasNextLine())
            throw new NoSuchElementException("Line not found");
        return scanner.nextLine();
    }

    private static void checkUserAndPassword(Map<String, String> userNameAndPassword,
                                             String inputUser,
                                             String inputPass)
                                        throws InputValue {

        if (!inputUser.equals(userNameAndPassword.get("userName")))
            throw new InputValue("User name is not valid");

        if (!inputPass.equals(userNameAndPassword.get("password")))
            throw new InputValue("User password is not valid");
    }

    private static Map<String, String> readUserAndPassFromFile(String path) throws FileNotFoundException {
        Map<String, String> inputMapUserPass = new HashMap<>();
        try {
            Scanner reader = new Scanner(new File(path));
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] splitLine = data.split(":");
                if (splitLine.length == 2) {
                    String user = splitLine[0].replace('"', ' ').replace(',',' ').trim();
                    String pass = splitLine[1].replace('"', ' ').replace(',',' ').trim();
                    if (user.equals("userName") || user.equals("password"))
                        inputMapUserPass.put(user, pass);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + path + " not found");
        }
        return inputMapUserPass;
    }
}
