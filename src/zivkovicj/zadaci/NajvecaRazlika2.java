package zivkovicj.zadaci;

import java.util.Scanner;

public class NajvecaRazlika2 {
    public static void main(String[] args) {

        //int[] array = {1,2,3,9,0,8,5};

        Scanner sc = new Scanner(System.in);
        System.out.println("Koliko brojeva hocete da unesete?");
        int number = sc.nextInt();
        int[] array = new int[number];
        System.out.println("Unesite brojeve:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        int maxRazlika = array[1] - array[0];

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j <  array.length; j++) {
                if(array[j] - array[i] > maxRazlika){
                    maxRazlika = array[j] - array[i];
                }
            }
        }

        System.out.println("Najveca razlika: " + maxRazlika);

    }
}
