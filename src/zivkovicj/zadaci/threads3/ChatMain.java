package zivkovicj.zadaci.threads3;

import zivkovicj.zadaci.threads.ChatThread;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatMain {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Malkier_4\\IdeaProjects\\Praksa\\src\\zivkovicj\\zadaci\\threads3\\general.txt";

        try (ExecutorService executor = Executors.newFixedThreadPool(5)) {
            FileWriter fr = new FileWriter(path);
            for (int i = 0; i < 10; i++) {
                Runnable thread = new ChatThread(fr, "Jovana ");
                executor.execute(thread);
            }

            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            fr.close();
        }
    }
}
