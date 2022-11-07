package david.zadaci.nedelja04;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Zadatak01 {
    private final static String PATH = "C:\\Users\\Malkier_3\\IdeaProjects\\Praksa\\src\\david\\zadaci\\nedelja04\\out.txt";
    private final static int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)) {
            try (FileWriter fileWriter = new FileWriter(PATH)) {
                for (int i = 0; i < 10; i++) {
                    Runnable writer = new WriteMessageToFile(i + "", "Poruka " + i, fileWriter);
                    executor.execute(writer);
                }
                shutdownAndAwaitTermination(executor);
                System.out.println("Finished all threads");
            } catch (IOException | NullPointerException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void shutdownAndAwaitTermination(ExecutorService pool) {
            pool.shutdown();
            try {
                if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                    pool.shutdownNow();
                    if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                        System.err.println("Pool did not terminate");
                }
            } catch (InterruptedException e) {
                pool.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
}
