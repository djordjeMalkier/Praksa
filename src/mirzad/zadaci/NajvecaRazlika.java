package mirzad.zadaci;

public class NajvecaRazlika {

    public static void main(String[] args) {
        int[] array = {5,3,2,10,15,1};
        find(array);

    }

    private static void find(int [] array){
        int max = 0;
        for(int i = array.length-1; i >= 0; i--){
            int j = findMin(array, i);
            if (array[i] - j > max) {
                max = array[i] - j;
            }
        }

        System.out.println(max);

    }

    private static int findMin(int[] array, int start){
        int min = 9999;
        for (int i = start; i >= 0; i--){
            if (array[i] < min) min = array[i];
        }
        return min;
    }

}
