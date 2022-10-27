import java.util.Scanner;
import java.util.stream.IntStream;

public class Zbir13 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        System.out.println("n= ");
        int n,a = 0;
        n = sc.nextInt();
        int[] array = new int[n];

        while (a < n && sc.hasNextInt()){
            array[a++] = sc.nextInt();

        }*/

        int[] array = IntStream.range(1,100).toArray();

        for (int i = 1; i <= array.length; i++) {
            int[] combs = new int[i];
            combinations(array, combs, 0, array.length - 1, 0, i);
        }
    }

    private static void combinations(int [] array,int [] combs, int start, int end, int index, int n){
        if (index == n){
            test(combs);
            return;
        }

        for(int i = start; i<=end && end-i+1 >= n-index; i++){
            combs[index] = array[i];
            combinations(array,combs,i+1,end,index+1, n);
        }

    }

    private static void test(int[] array ){
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        if (sum == 13){
            printArray(array);
            System.out.println();
        }
    }

    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}