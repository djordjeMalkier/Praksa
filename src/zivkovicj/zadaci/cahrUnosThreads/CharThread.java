package zivkovicj.zadaci.cahrUnosThreads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharThread implements Runnable{

    String path;

    public CharThread(String path){
        this.path = path;
    }


    @Override
    public void run() {

        try {
            File file = new File(path);
            if (file.createNewFile()) {

                System.out.println("File created: " + file.getName());
            } else {
                System.exit(0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
