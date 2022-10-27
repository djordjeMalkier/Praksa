package zivkovicj.zadaci;

public class Main {
    public static void main(String[] args) {

        String[] niz = {"abc123", "24bvc", "bvc456", "po121av"};
        int duzina = niz.length;
        int[] noviNiz = new int[duzina];
        for (int i = 0; i < niz.length; i++) {
            //u int
            noviNiz[i] = Integer.parseInt(niz[i]);
        }
        Sort(noviNiz);

        for (int i = 0; i < noviNiz.length; i++) {
            System.out.println(noviNiz[i]);
        }

        //DaLiIma(noviNiz);
        System.out.println( DaLiIma(noviNiz));
    }
    public static void Sort(int a[]){
        int temp;
        int min;
        for (int i = 0; i < a.length-1; i++) {
            min = i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] < a[min]){
                    min = j;
                }
            }
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    public static boolean DaLiIma(int a[]){
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] +1 != a[i+1]){
                return false;
            }
        }
        return true;
    }
}