package mirzad.zadaci;

public class Podniz {
    public static void main(String[] args) {
        int[] inputArray = {1,4,23,7,5,64,12,3};
        int[] subArray = {7,5};
        boolean flag = false;


        for (int i = 0; i < inputArray.length; i++){
            if (inputArray[i] == subArray[0]) {
                flag = check(inputArray, subArray, i);
            }
        }
        printCheck(flag);
    }

    private static boolean check(int[] array, int[] subArray, int start) {
        if(subArray.length < array.length) return false;

        boolean check = true;

        for (int i = 0; i < subArray.length; i++) {
            if (subArray[i] != array[start++]) {
                check = false;
                break;
            }
        }

        return check;
    }

    private static void printCheck(boolean check){
        if (check) System.out.println("Postoji podniz u nizu.");
        else System.out.println("Podniz ne postoji u nizu.");
    }
}
