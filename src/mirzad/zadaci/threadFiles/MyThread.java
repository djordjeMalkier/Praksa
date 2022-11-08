package mirzad.zadaci.threadFiles;

import mirzad.zadaci.thread.ThreadMessage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MyThread implements Runnable {
    int value;
    FileWriter writer;

    public MyThread(int value, FileWriter writer){
        this.writer = writer;
        this.value = value;
    }
    @Override
    public void run() {
        synchronized (ThreadMessage.lock){
            System.out.println("Ja sam tred sa vrednosti " + value);
            Random random = new Random();
            for (int i = 0; i < value; i++){
                writeToFile(writer, random.nextInt(1000));
            }
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Zavrsio " + value);
        }

    }

    private static void writeToFile(FileWriter myWriter, int number){
        try {
            myWriter.write(number + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
