package zivkovicj.zadaci.threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatThread implements Runnable{
    private String name;

    private FileWriter file;

    public ChatThread(FileWriter file, String name){
        this.file = file;
        this.name = name;
    }

    @Override
    public void run() {
        try{
            file.write(name + Thread.currentThread().getName() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
