package mirzad.zadaci.thread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadMessage {
    public static FileWriter myWriter;

    public static final Object lock = "LOCK";

    public static void main(String[] args) throws IOException {

        myWriter = new FileWriter("C:\\Users\\Malkier_2\\Documents\\Zadaci\\Praksa\\src\\mirzad\\zadaci\\thread\\poruka.txt");
        Thread threadOne = new Thread(new MyThread());
        Thread threadTwo = new Thread(new MyThread());
        Thread threadThree = new Thread(new MyThread());
        Thread threadFour = new Thread(new MyThread());
        Thread threadFive = new Thread(new MyThread());

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();
        threadFive.start();

        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
            threadFour.join();
            threadFive.join();
            ThreadMessage.myWriter.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
