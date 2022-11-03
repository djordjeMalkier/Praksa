package velickovj.nedelja03;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UsernamePassword {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("src/velickovj/nedelja03/usernamepassword");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.next());

        }
        scanner.close();
    }
}
