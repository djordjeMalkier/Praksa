package velickovj.nedelja04;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;
import static velickovj.nedelja03.IspisivanjeDirektorijuma.ispisiFajlove;

public class NitiKarakteri {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            char karakter=scanner.next().charAt(0);
            Thread t=new Thread(new NitiKarakteri().new Karakteri(karakter));
            t.start();
            t.join();
        }
    }
    private class Karakteri implements Runnable{


        private char karakter;

        Karakteri(char karakter){
            this.karakter=karakter;
        }


        @Override
        public void run() {

            String ime="";

            if(karakter<'z' && karakter>'a')
                ime=karakter+" "+".txt";
            if(karakter<'Z' && karakter>'A')
                ime=karakter+""+karakter+".txt";


            File file=new File("src/velickovj/nedelja04"+"/"+ime);

            try {
                if(!Character.isAlphabetic(karakter)){
                    System.out.println("Nije unet odgovarajuci karakter");
                }
                else if(file.createNewFile()){
                    FileWriter myFileWriter=new FileWriter("src/velickovj/nedelja04"+"/"+ime);
                    for(int i=0; i<(int)karakter;i++) {
                        Random rand = new Random();
                        int upperbound = 1000;
                        int int_random = rand.nextInt(upperbound);
                        myFileWriter.append(int_random+" ");

                    }
                    myFileWriter.close();
                }
                else{
                    System.out.println("Karakter je vec unet, fajl postoji");

                    File dir = new File("src/velickovj/nedelja04");
                    File[] files = dir.listFiles(new FilenameFilter() {
                                                     public boolean accept(File dir, String name) {
                                                         return name.toLowerCase().endsWith(".txt");
                                                     }}
                                                 );
                    ispisiFajlove(files);
                    exit(0);

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
