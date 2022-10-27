package mirzad.zadaci;

public class BrojPojavljivanja {
    public static void main(String[] args) {
        int[] array = {1,2,3,3,3,4,5,5,5,5,6,7};

        sort(array,0,array.length-1);
        int counter = 1, max = 0, best =-1,last;
        last = array[0];

        for (int i = 1; i < array.length; i++){
            if (array[i] != last) {
                if (counter == 1) System.out.println("Jednom se pojavljuje: " + last);
                if (counter>max) {
                    max = counter;
                    best = last;
                    counter = 1;
                }
            }
            else {
                counter++;
            }
            last = array[i];

        }
        if (counter > max) best = last;
        if (counter == 1) System.out.println("Jednom se pojavljuje: " + last);
        System.out.println("Najvise se pojavljuje: " + best);
    }

    private static void sort(int arr[], int begin, int end) {
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