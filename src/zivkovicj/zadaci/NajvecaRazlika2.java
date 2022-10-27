package zivkovicj.zadaci;

public class NajvecaRazlika2 {
    public static void main(String[] args) {

        int[] array = {1, 2,8,3,5};

        int max = 0;
        int min = array[0];
        for (int i = 0; i < array.length; i++) {

            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        System.out.println(min + " " + max);
    }
}
