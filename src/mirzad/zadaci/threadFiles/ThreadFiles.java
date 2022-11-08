package mirzad.zadaci.threadFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreadFiles {
    public static void main(String[] args) throws IOException {
        char a = 0,last = 1;
        ArrayList<Character> characters = new ArrayList<Character>();
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String line = scanner.next();
            a = line.charAt(0);
            if(characters.contains(a)) break;

            if (line.length() > 1 || (a < 65 || a > 122)){
                System.out.println("Pogresan unos");
                continue;
            }

            String name;

            if(a >= 65 && a <= 90){
                char charName = (char) (a + 32);
                name = String.valueOf(charName ) + String.valueOf( charName);
            } else {
                name = String.valueOf(a);
            }

            characters.add(a);
            FileWriter writer = new FileWriter("C:\\Users\\Malkier_2\\Documents\\Zadaci\\Praksa\\src\\mirzad\\zadaci\\threadFiles\\" + name + ".txt");
            Thread thread = new Thread(new MyThread(a, writer));
            thread.start();
        }
    }
}
