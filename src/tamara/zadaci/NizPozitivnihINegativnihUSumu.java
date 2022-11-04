package tamara.zadaci;

import java.io.*;
import java.util.Scanner;

public class NizPozitivnihINegativnihUSumu {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Malkier_1\\IdeaProjects\\Praksa\\src\\tamara\\zadaci\\postupak.txt";
        FileWriter fw = new FileWriter(path, true);

        PrintWriter pw = new PrintWriter(fw);

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
            if (zadatiNiz[i] < 0) {

                if (zadatiNiz[i] % 2 == 0) {
                    if(i == 0) pw.print("(" + zadatiNiz[i] + ")²");
                    else pw.print("+(" + zadatiNiz[i] + ")²");
                    zadatiNiz[i] *= zadatiNiz[i];
                    suma += zadatiNiz[i];
                } else {
                    pw.print("-(" + zadatiNiz[i] + ")²");
                    zadatiNiz[i] *= zadatiNiz[i];
                    suma -= zadatiNiz[i];
                }
            } else{
                if (zadatiNiz[i] % 2 == 0) {
                    suma += zadatiNiz[i];
                    if(i == 0) pw.print(zadatiNiz[i]);
                    else pw.print("+" + zadatiNiz[i]);
                } else {
                    suma -= zadatiNiz[i];
                    pw.print("-" + zadatiNiz[i]);
                }
            }

        }

        pw.println();
        System.out.println(suma);
        pw.close();
        fw.close();


    }
}
