package tamara.zadaci;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class UcitajSadrzajFajla {
    public static void main(String[] args) throws IOException {
        try {
            File[] fajlovi = new File("src/tamara").listFiles();
            //assert fajl != null; - ovo kazem samo ako sam sigurna da ovaj fajl nije null
            if (fajlovi == null)
                throw new NullPointerException("Fajl ne postoji.");
            izlistajSadrzaj(fajlovi);
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }
    }

    private static void izlistajSadrzaj(File[] fajlovi) {
        for (File file : fajlovi) {
            if (file.isDirectory()) {
                System.out.println("Direktorijum: " + file.getName());
                izlistajSadrzaj(Objects.requireNonNull(file.listFiles()));
            } else {
                System.out.println("\tFajl: " + file.getName());
            }

        }
    }


}
