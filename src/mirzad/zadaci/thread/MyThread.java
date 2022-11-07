package mirzad.zadaci.thread;

import java.io.FileWriter;
import java.io.IOException;

public class MyThread implements Runnable {
    @Override
    public void run() {
        synchronized (ThreadMessage.lock){
            writeToFile("Cao, ja sam " + Thread.currentThread().getName() + "\n");
        }

    }

    private static void writeToFile(String string){
        try {
            ThreadMessage.myWriter.write(string);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
