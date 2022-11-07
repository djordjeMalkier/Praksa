package david.zadaci.nedelja03;

import java.io.File;
import java.util.Objects;

/*
* Uneti folder
* Ispisati strukturu
* */
public class Zadatak11 {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Malkier_3\\IdeaProjects\\Praksa\\src\\david";
        try {
            listDirectory(inputPath);
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void listDirectory(String inputPath) throws NullPointerException {
        listDirectoryWithDepth(inputPath,0);
    }

    private static void listDirectoryWithDepth(String inputPath, int n) throws NullPointerException {
        StringBuilder sb = new StringBuilder("");
        sb.append("\t".repeat(n));

        File inputFile = new File(inputPath);
        for (File file : Objects.requireNonNull(inputFile.listFiles())) {
            if (file.isDirectory()) {
                System.out.println(sb + file.getName() + "/");
                listDirectoryWithDepth(file.getPath(), n+1);
            }
            else {
                System.out.println(sb + file.getName());
            }
        }
    }
}
