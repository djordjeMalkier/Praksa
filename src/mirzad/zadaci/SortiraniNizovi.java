package mirzad.zadaci;

public class SortiraniNizovi {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,3,5,9,11,18};
        int[] array2 = {4,6,7,8,9,10,21};
        int[] finalArray = new int[array1.length + array2.length];
        int i,x=0,y=0,a,b;

        for(i = 0; i < finalArray.length; i++){
            if (x == array1.length) {
                finalArray[i] = array2[y++];
            } else if (y == array2.length) {
                finalArray[i]  = array1[x++];
            }else {
                a = array1[x];
                b = array2[y];
                if (a<=b) finalArray[i]  = array1[x++];
                else finalArray[i] = array2[y++];
            }
        }
        printArray(finalArray);
    }

    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}