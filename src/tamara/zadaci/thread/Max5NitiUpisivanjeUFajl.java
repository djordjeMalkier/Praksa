package tamara.zadaci.thread;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Max5NitiUpisivanjeUFajl implements Runnable {
    static final int MAX_T = 5;

    private String imeNiti;
    private FileWriter fw;

    public Max5NitiUpisivanjeUFajl( FileWriter fw, String ime)
    {
        this.fw = fw;
        imeNiti = ime;
    }

    @Override
    public void run() {

        try {


            fw.write(imeNiti + " Tadaa\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Malkier_1\\IdeaProjects\\Praksa\\src\\tamara\\zadaci\\thread\\nitiUpisivanje.txt";

        FileWriter fw = new FileWriter(path);
        Runnable r1 = new Max5NitiUpisivanjeUFajl(fw,"Nit1");
        Runnable r2 = new Max5NitiUpisivanjeUFajl(fw,"Nit2");
        Runnable r3 = new Max5NitiUpisivanjeUFajl(fw,"Nit3");
        Runnable r4 = new Max5NitiUpisivanjeUFajl(fw,"Nit4");
        Runnable r5 = new Max5NitiUpisivanjeUFajl(fw,"Nit5");


        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);


        pool.shutdown();
        while (!pool.isTerminated()) {}
        fw.close();
    }
}
