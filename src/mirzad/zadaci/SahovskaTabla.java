package mirzad.zadaci;

import java.util.ArrayList;
import java.util.Scanner;

public class SahovskaTabla {
    public static void main(String[] args) {
        int[] pocetnaPozicija = new int[2];
        int[] krajnjaPozicija = new int[2];

        ArrayList<int[]> putanja = new ArrayList<>();
        int n;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite n: ");

        if(scanner.hasNextInt()) n = scanner.nextInt();
        else {
            System.out.println("Nepravilan unos! ");
            return;
        }

        int[][] matrix = scanMatrix(n,scanner);

        if(matrix == null) return;

        System.out.println("Unesite pocetnu poziciju");
        pocetnaPozicija[0] = scanner.nextInt();
        pocetnaPozicija[1] = scanner.nextInt();

        System.out.println("Unesite krajnju poziciju");
        krajnjaPozicija[0] = scanner.nextInt();
        krajnjaPozicija[1] = scanner.nextInt();

        int[] prethodna = {-1,-1};

        solve(n,pocetnaPozicija,krajnjaPozicija,prethodna,pocetnaPozicija,1,putanja);

    }

    private static int[][] scanMatrix(int n, Scanner scanner) {
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++ ){
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    private static void solve (int n,int[] pocetna, int[] krajnja, int[] prethodna, int[]pozicija, int count, ArrayList<int[]> putanja){
        if(checkArrays(krajnja,pozicija)) {
            System.out.println("Dosao");
            System.exit(1);
            return;
        }

        else {
            putanja.add(prethodna);
            int[] goreLevo = pomeriGoreLevo(pozicija);
            if (checkPosition(goreLevo, n) && !checkArrays(goreLevo,prethodna)) solve(n, pocetna, krajnja,pozicija, goreLevo, count + 1, putanja);
            int[] goreDesno = pomeriGoreDesno(pozicija);
            if (checkPosition(goreDesno, n) && !checkArrays(goreDesno,prethodna)) solve(n, pocetna, krajnja, pozicija, goreDesno, count + 1, putanja);

            int[] doleLevo = pomeriDoleLevo(pozicija);
            if (checkPosition(doleLevo, n) && !checkArrays(doleLevo,prethodna)) solve(n, pocetna, krajnja, pozicija, doleLevo, count + 1, putanja);
            int[] doleDesno = pomeriDoleDesno(pozicija);
            if (checkPosition(doleDesno, n) && !checkArrays(doleDesno,prethodna)) solve(n, pocetna, krajnja, pozicija,  doleDesno, count + 1, putanja);

            int[] desnoGore = pomeriDesnoGore(pozicija);
            if (checkPosition(desnoGore, n) && !checkArrays(desnoGore,prethodna)) solve(n, pocetna, krajnja, pozicija,  desnoGore, count + 1, putanja);
            int[] desnoDole = pomeriDesnoDole(pozicija);
            if (checkPosition(desnoDole, n) && !checkArrays(desnoDole,prethodna)) solve(n, pocetna, krajnja, pozicija,  desnoDole, count + 1, putanja);


            int[] levoGore = pomeriLevoGore(pozicija);
            if (checkPosition(levoGore, n) && !checkArrays(levoGore,prethodna)) solve(n, pocetna, krajnja, pozicija,  levoGore, count + 1, putanja);
            int[] levoDole = pomeriLevoDole(pozicija);
            if (checkPosition(levoDole, n) && !checkArrays(levoDole,prethodna)) solve(n, pocetna, krajnja, pozicija,  levoDole, count + 1, putanja);
        }
    }
    private static int[] pomeriGoreLevo(int[] pozicija){
        int[] array = new int[2];
        array[0] = pozicija[0] - 2;
        array[1] = pozicija[1] - 1;

        return array;
    }

    private static int[] pomeriGoreDesno(int[] pozicija){
        int[] array = new int[2];
        array[0] = pozicija[0] - 2;
        array[1] = pozicija[1] + 1;

        return array;
    }

    private static int[] pomeriDoleLevo(int[] pozicija){
        int[] array = new int[2];
        array[0] = pozicija[0] + 2;
        array[1] = pozicija[1] - 1;

        return array;
    }

    private static int[] pomeriDoleDesno(int[] pozicija){
        int[] array = new int[2];
        array[0] = pozicija[0] + 2;
        array[1] = pozicija[1] + 1;

        return array;
    }

    private static int[] pomeriDesnoGore(int[] pozicija){
        int[] array = new int[2];
        array[0] = pozicija[0] - 1;
        array[1] = pozicija[1] + 2;

        return array;
    }

    private static int[] pomeriDesnoDole(int[] pozicija){
        int[] array = new int[2];
        array[0] = pozicija[0] + 1;
        array[1] = pozicija[1] + 2;

        return array;
    }

    private static int[] pomeriLevoGore(int[] pozicija){
        int[] array = new int[2];
        array[0] = pozicija[0] - 1;
        array[1] = pozicija[1] + 2;

        return array;
    }

    private static int[] pomeriLevoDole(int[] pozicija){
        int[] array = new int[2];
        array[0] = pozicija[0] + 1;
        array[1] = pozicija[1] - 2;

        return array;
    }

    private static boolean checkArrays(int[] first, int[] second){
        if(first.length != second.length) return false;
        for(int i = 0; i < first.length; i++){
            if (first[i] != second[i])
                return false;
        }
        return true;
    }

    private static boolean checkPosition(int[] position,int n){
        return position[0] >= 0 && position[0] < n && position[1] >= 0 && position[1] < n;
    }
}
