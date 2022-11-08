package tamara.zadaci.thread;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class KriranjeFajlovaSaBrojevima {
    public static void main(String[] args) throws InterruptedException {
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite slovo: ");
        while (ulaz.hasNext()) {
            System.out.println("Unesite slovo: ");
            char slovo = ulaz.next().trim().charAt(0);
            Thread nit = new Thread(new KreiranjeFajlovaNiti(slovo));
            nit.start();
            nit.join();
        }

    }

    private static class KreiranjeFajlovaNiti implements Runnable {
        char slovo;
        String ostatak;
        KreiranjeFajlovaNiti(char karakter){

            slovo = karakter;
        }
        FileWriter fw;

        @Override
        public void run() {

            if (Character.isUpperCase(slovo)) {
                ostatak = "\\" + slovo + slovo + ".txt";
            } else {
                ostatak = "\\" + slovo + ".txt";
            }

            File fajl = new File("C:\\Users\\Malkier_1\\IdeaProjects\\Praksa\\src\\tamara\\zadaci\\thread" + ostatak);

            try {
                if(fajl.createNewFile()) {
                    fw = new FileWriter("C:\\Users\\Malkier_1\\IdeaProjects\\Praksa\\src\\tamara\\zadaci\\thread" + ostatak);
                    for(int i = 0; i < slovo; i++) {
                        Random rand = new Random();
                        int gornjaGranica = 1000;
                        int broj = rand.nextInt(gornjaGranica);
                        fw.append(broj + " ");

                    }
                    fw.close();
                }
                else {
                    System.out.println("Fajl vec postoji.");
                    File folder = new File("C:\\Users\\Malkier_1\\IdeaProjects\\Praksa\\src\\tamara\\zadaci\\thread");

                    File[] fajlovi = folder.listFiles(new FilenameFilter() {
                        public boolean accept(File folder, String ime) {
                            return ime.toLowerCase().endsWith(".txt");
                        }}
                    );

                    //provjeri da li je prazan
                    ispisiFajlove(fajlovi);
                    exit(0);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        public static void ispisiFajlove(File[] fajlovi) {
            for(File fajl: fajlovi){
                if(fajl.isDirectory()){
                    System.out.println("Direktorijum: " + fajl.getName());
                    ispisiFajlove(Objects.requireNonNull(fajl.listFiles()));
                }

                else {
                    System.out.println("\tFajl: " + fajl.getName());
                }
            }
        }

    }

}
