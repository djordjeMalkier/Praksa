package david.zadaci.nedelja01;
/*
 * Za niz brojeva int koji nije sortiran
 * ispisati najduzu sortiranu sekvencu, i koliko sadrzi elemenata
 * bez obzira na poredak
 * */
public class Zadatak10 {
    public static void main(String[] args) {
        int[] array = {1,2,1,2,3,-1,0,1,2,3,4,5,-5}; //-1 0 1 2 3 4 5

        int maxLen = 0, subArrayLen;
        int MaxFirst = 0, MaxLast = 0;

        for (int i = 0; i < array.length; i++) {
            subArrayLen = lastIndexInOrderArray(array, i) - i + 1;
            if (subArrayLen > maxLen) {
                maxLen = subArrayLen;
                MaxFirst = i;
                MaxLast = i + subArrayLen - 1;
            }
        }
        printArray(array, MaxFirst, MaxLast + 1);
        System.out.println("Max length: " + maxLen);
    }

    private static int lastIndexInOrderArray(int[] array, int current) throws NullPointerException {
        if (array == null) throw new NullPointerException("Null array");

        if (current + 1 >= array.length)
            return current;

        int lastIndex = current;
        boolean isASC = array[current] < array[current + 1];
        int i = current;

        while (isASC && array[i] < array[i+1]){
            lastIndex++;
            i++;
            if (!(i < array.length - 1))
                break;
        }
        while (!isASC && array[i] > array[i+1]) {
            lastIndex++;
            i++;
            if (!(i < array.length - 1))
                break;
        }
        return lastIndex;
    }

    private static void printArray(int[] array, int start, int end) throws NullPointerException {
        if (array == null) throw new NullPointerException("Null array");

        for (int i = start; i < end; i++)
            System.out.print(array[i] + " ");
        System.out.println(" ");
    }
}
