package tamara.zadaci.postupakUFajl;

import java.io.*;
import java.util.Scanner;

public class NizPozitivnihINegativnihUSumu {
    public static void main(String[] args) throws IOException {
            String path = "C:\\Users\\Malkier_1\\IdeaProjects\\Praksa\\src\\tamara\\zadaci\\postupak.txt";
            FileWriter fw = new FileWriter(path, true);

            Scanner ulaz = new Scanner(System.in);

            System.out.print("Unesi broj clanova: ");
            int brojClanova = ulaz.nextInt();

            int[] zadatiNiz = new int[brojClanova];
            System.out.println("Unesi clanove: ");
            for (int i = 0; i < brojClanova; i++) {
                System.out.print("X[" + i + "]" + ": ");
                zadatiNiz[i] = ulaz.nextInt();
            }

            int suma = 0;

            for (int i = 0; i < zadatiNiz.length; i++) {
                if (zadatiNiz[i] % 2 == 0) {
                    if(zadatiNiz[i] < 0) {
                        if(i == 0) fw.write(" (" + zadatiNiz[i] + ")² ");
                        else fw.write(" +(" + zadatiNiz[i] + ")²" );
                        zadatiNiz[i] *= zadatiNiz[i];
                    }
                    else {
                        if(i == 0) fw.write(zadatiNiz[i]);
                        else fw.write(" + " + zadatiNiz[i]);
                    }
                    suma += zadatiNiz[i];

                } else {
                    if(zadatiNiz[i] < 0) {
                        fw.write(" -(" + zadatiNiz[i] + ")²");
                        zadatiNiz[i] *= zadatiNiz[i];
                    }
                    else fw.write(" - " + zadatiNiz[i]);

                    suma -= zadatiNiz[i];
                }

            }
            fw.write(" = " + suma);
            fw.write("\n");
            System.out.println(suma);
            fw.close();

    }
}
