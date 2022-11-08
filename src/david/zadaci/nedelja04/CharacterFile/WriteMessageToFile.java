package david.zadaci.nedelja04.CharacterFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class WriteMessageToFile implements Runnable{
    private static final int MAX = 1000;
    private final FileWriter fileToWriteMSG;
    private final char inputChar;

    public WriteMessageToFile(FileWriter fileToWriteMSG, char inputChar) {
        this.fileToWriteMSG = fileToWriteMSG;
        this.inputChar = inputChar;
    }

    @Override
    public void run() {
        try {
            fileToWriteMSG.write(writeNrandom(inputChar));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String writeNrandom(char inputChar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (int)inputChar; i++) {
            int intRandom = ThreadLocalRandom.current().nextInt(MAX);
            sb.append(intRandom).append("\n");
        }
        return sb.toString();
    }
}
