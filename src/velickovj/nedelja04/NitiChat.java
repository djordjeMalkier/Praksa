package velickovj.nedelja04;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class NitiChat {
    public static void main(String[] args) throws InterruptedException {
       for(int i=0;i<5;i++){
            Thread t=new Thread(new NitiChat().new Niti());
            t.start();
            t.join();

    }


}

    private class Niti implements Runnable {
        public void run() {
            try{

                FileWriter myWriter = new FileWriter("src/velickovj/nedelja04/chat.txt",true);



                System.out.println("Unesite poruku: ");
                Scanner scanner = new Scanner(System.in);
                String poruka = scanner.next();
                myWriter.write(Thread.currentThread().getName());
                myWriter.write(" ");
                myWriter.write(poruka);
                myWriter.write("\n");
                myWriter.close();


            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

