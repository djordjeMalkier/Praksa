import java.util.Arrays;

public class VeciLevoDesno {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9,10,11};
        sort(array,0,array.length-1);

        int[] finalArray = new int[array.length];
        int a = 0;
        int b = array.length - 1;


        for(int i = 0; i < finalArray.length; i++){
            if(i % 2 == 0) finalArray[i] = array[a++];
            else finalArray[i] = array[b--];
        }

        printArray(finalArray);


    }

    private static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");;
        }
    }

    private static void sort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            sort(arr, begin, partitionIndex-1);
            sort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}