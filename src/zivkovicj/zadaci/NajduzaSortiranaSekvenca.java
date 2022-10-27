package zivkovicj.zadaci;

public class NajduzaSortiranaSekvenca {
    public static void main(String[] args) {
        //int []arr = {1,2,1,2,3,0,1,2,3,4,20,10,9,8,7,6,5,4, 3, 4,5};
        // niz brojeva, bilo koji, nije sortiran, da ispisemo najduzu sortiranu sekvencu u nizu i koliko ima elemenata

        int[] arr = {1, 2, 1, 2, 3, 0, 1, 2, 3, 4, 10, 3, 4, 5};
        int max = 0;
        int maxi = 0;
        int maxj = 0;
        int counter = 1;
        int counter2 = 1;
        int start = 0;
        int end = 0;
        int starti = 0;
        int endj = arr.length - 1;

        while (endj - starti > 1) {
            // proverava sortirane s leva na desno
            int pocetak = starti;
            for (int i = starti; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    start = i;
                    if (counter > max) {
                        max = counter;
                        maxi = pocetak;
                        maxj = i;
                    }
                    break;
                }
                counter++;
            }
            counter = 1;

            // proverava sortirane s desna na levo
            int pocetak2 = endj;
            for (int j = endj; j >= 0; j--) {
                if (arr[j] > arr[j - 1]) {
                    end = j;
                    if (counter2 > max) {
                        max = counter2;
                        maxi = pocetak2;
                        maxj = j;
                    }
                    break;
                }
                counter2++;
            }
            counter2 = 1;
            starti = start + 1;
            endj = end - 1;
        }
        if (maxi > maxj) {
            int temp = maxi;
            maxi = maxj;
            maxj = temp;
        }

        System.out.println("Najduza sekvenca ima " + max + " elemenata:");

        for (int i = maxi; i <= maxj; i++) {
            System.out.println(arr[i]);
        }

    }
}
