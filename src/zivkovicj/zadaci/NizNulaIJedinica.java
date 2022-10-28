package zivkovicj.zadaci;

public class NizNulaIJedinica {
    public static void main(String[] args) {
        // program koji ispisuje sve brojeve koji se pojavljajuju samo jednom i broj koji se pojavljuje najvise puta
        int[] arr = {1, 0, 2, 1, 4, 0, 6, 1, 1};

        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            while (l < r && arr[r] == 1) {
                r--;
            }
            if (arr[l] == 1) {
                swap(arr, l, r);
            }
            l++;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {

                for (int j = i; j > 0; j--) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }

        }
        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static void swap(int[] arr, int b, int a) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
