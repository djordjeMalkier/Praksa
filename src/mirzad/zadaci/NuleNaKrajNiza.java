package mirzad.zadaci;

import java.util.Scanner;

public class NuleNaKrajNiza {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = 0;
        int[] array = new int[7];

        while (sc.hasNextInt()){
            array[count++] = sc.nextInt();
        }

        System.out.println("Brojac je:" + count);


        for (int i = 0; i < count; i++){

            if(array[i] == 0) toEnd(array, i);
        }


        System.out.println("Zamenjen redosled: ");
        printArray(array);

    }

    private static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    private static void toEnd(int[] array, int a) {
        int n = array.length - a - 1;

        while (n > 0) {
            swap(array, a, ++a);
            n--;
        }
    }
}
