package velickovj.nedelja03;

import java.io.File;
import java.io.IOException;

public class IspisivanjeDirektorijuma {
    public static void main(String[] args) throws NullPointerException  {
       try {
           File[] fajlovi = new File("src").listFiles();

           if (fajlovi == null)
               throw new NullPointerException();
           ispisiFajlove(fajlovi);
       } catch (NullPointerException e){
           e.printStackTrace();
       }

    }

    public static void ispisiFajlove(File[] fajlovi) {
        for(File file: fajlovi){
            if(file.isDirectory()){
                System.out.println("Direktorijum: "+file.getName());
                ispisiFajlove(file.listFiles());
            }

            else {
                System.out.println("\tFajl: " + file.getName());
            }
        }
    }
}
