package velickovj.nedelja03;

import java.awt.*;
import java.util.Scanner;

import static velickovj.nedelja03.MatriceSuma.ispisiMatricu;
import static velickovj.nedelja03.MatriceSuma.ucitajMatricu;

public class MatricaDijagonale {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int n=s.nextInt();
        int [] [] matrica=ucitajMatricu(n);
        ispisiMatricu(matrica,n);
        s.close();

        int sumaGlavnaDijagonala=zbirNaGlavnojDijagonali(matrica,n);
        System.out.println("Suma na glavnoj dijagonali je: "+sumaGlavnaDijagonala);

        int sumaSporednaDijagonala=zbirNaSporednojDijagonali(matrica,n);
        System.out.println("Suma na sporednoj dijagonali je: "+sumaSporednaDijagonala);

        int sumaIznadGlavneDijagonale=zbirIznadGlavneDijagonale(matrica,n);
        System.out.println("Suma iznad glavne dijagonale je: "+sumaIznadGlavneDijagonale);

        int sumaIspodGlavneDijagonale=zbirIspodGlavneDijagonale(matrica,n);
        System.out.println("Suma ispod glavne dijagonale je: "+sumaIspodGlavneDijagonale);

        int sumaIznadSporedneDijagonale=zbirIznadSporedneDijagonale(matrica,n);
        System.out.println("Suma iznad sporedne dijagonale je: "+sumaIznadSporedneDijagonale);

        int sumaIspodSporedneDijagonale=zbirIspodSporedneDijagonale(matrica,n);
        System.out.println("Suma ispod sporedne dijagonale je: "+sumaIspodSporedneDijagonale);

        int proizvod=proizvodVanDijagonala(matrica,n);
        System.out.println("Proizvod van dijagonala je: "+proizvod);
    }

    private static int proizvodVanDijagonala(int[][] matrica, int n) {
        int proizvod=1;
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++){
                if (i == j)
                    continue;
                if (i + j == n - 1)
                    continue;
                proizvod = proizvod * matrica[i][j];
            }
        }
        return proizvod;
    }

    private static int zbirIspodSporedneDijagonale(int[][] matrica, int n) {
        int suma=0;
        for(int i=n-1; i>0; i--) {
            for(int j=n-i;j<n;j++)
                suma=suma+matrica[i][j];
        }
        return suma;
    }

    private static int zbirIznadSporedneDijagonale(int[][] matrica, int n) {
        int suma=0;
        for(int i=0; i<n-1; i++) {
            for(int j=0;j<n-1-i;j++)
                suma=suma+matrica[i][j];
        }
        return suma;
    }

    private static int zbirIspodGlavneDijagonale(int[][] matrica, int n) {
        int suma=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++)

                suma=suma+matrica[i][j];

        }
        return suma;
    }

    private static int zbirIznadGlavneDijagonale(int[][] matrica, int n) {
        int suma=0;
        for(int i=0; i<n-1;i++){
            for(int j=i+1; j<n;j++)

                suma=suma+matrica[i][j];

        }
        return suma;
    }

    private static int zbirNaSporednojDijagonali(int[][] matrica, int n) {
        int suma=0;
        for(int i=0, j=n-1;i<n && j>=0; i++,j--){

                suma=suma+matrica[i][j];

        }
        return suma;
    }

    private static int zbirNaGlavnojDijagonali(int[][] matrica,int n) {
        int suma=0;
        for(int i=0;i<n;i++){
            suma=suma+matrica[i][i];
        }
        return suma;
    }
}
