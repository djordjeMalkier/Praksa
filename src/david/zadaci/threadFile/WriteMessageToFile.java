package david.zadaci.threadFile;

import java.io.FileWriter;
import java.io.IOException;

public class WriteMessageToFile implements Runnable{

    //private String filePath;
    private FileWriter fileToWriteMSG;
    private String name, msg;

    public WriteMessageToFile(String name, String msg, FileWriter fileToWriteMSG) {
        this.name = name;
        this.msg = msg;
        this.fileToWriteMSG = fileToWriteMSG;
    }

    @Override
    public void run() {
        try {
            fileToWriteMSG.write(name + ": " + msg + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
