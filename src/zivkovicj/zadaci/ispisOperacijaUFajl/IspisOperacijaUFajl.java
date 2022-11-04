package zivkovicj.zadaci.ispisOperacijaUFajl;

import java.io.*;
import java.util.Scanner;

public class IspisOperacijaUFajl {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("koliko brojeva hocete da unesete?");
        int n = sc.nextInt();
        System.out.println("Unesite brojeve");
        int[] brojevi = new int[n];
        String path = "C:\\Users\\Malkier_4\\IdeaProjects\\Praksa\\src\\zivkovicj\\zadaci\\ispisOperacijaUFajl\\append.txt";
        File file = new File(path);
        FileWriter fr = new FileWriter(file, true);

        //BufferedWriter br = new BufferedWriter(fr);
        PrintWriter out = new PrintWriter(fr);

        int suma = 0;
        for (int i = 0; i < n; i++) {
            brojevi[i] = sc.nextInt();
            if(brojevi[i] >= 0){
                if(brojevi[i] % 2 == 0) {
                    suma += brojevi[i];
                    out.print("+");
                    out.print((brojevi[i]));
                }
                else{
                    brojevi[i] *= -1;
                    suma += brojevi[i];
                    //out.print("-");
                    out.print((brojevi[i]));
                }

            } else {
                if(brojevi[i] % 2 == 0) {
                    out.print("+(" + brojevi[i] + ")²");
                    brojevi[i] *= brojevi[i];
                    suma += brojevi[i];
                }
                else {
                    out.print("-(" + brojevi[i] + ")²");
                    brojevi[i] *= brojevi[i];
                    brojevi[i] *= -1;
                    suma += brojevi[i];
                }
            }
        }
        //br.close();
        out.println("");
        out.close();
        fr.close();
        System.out.println(suma);

    }
    //kvadrira se negaivan da li je paran ili neparan
}
