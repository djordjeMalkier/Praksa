package zivkovicj.zadaci;

import java.io.File;
import java.io.IOException;

public class IspisSvihDatoteka {
    public static void main(String[] args) {
        String path = "C:\\Users\\Malkier_4\\IdeaProjects\\Praksa\\src\\zivkovicj\\zadaci";
        File folder = new File(path);
        try {
            ispisFajlova(folder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ispisFajlova(File folder) throws IOException {

        for (File file : folder.listFiles()){
            if(file.isDirectory()){
                System.out.println(folder.getAbsoluteFile());
                ispisFajlova(file);
            } else{
                if(file.isFile()){
                    System.out.println(file.getName());
                }
            }
        }

    }
}
