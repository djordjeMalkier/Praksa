package velickovj.nedelja03;

import java.util.Scanner;

public class MatriceSuma {
    
    
    
    public static void main(String[] args) {
        int n;

        Scanner s= new Scanner(System.in);
        n=s.nextInt();
        int [][] matrica=new int[n][n];

        matrica =ucitajMatricu(n);
        ispisiMatricu(matrica,n);

        int[] maxSumaReda=naciNajvecuSumuReda(matrica,n);
        int[] maxSumaKolona=naciNajvecuSumuKolona(matrica,n);

        int sumaReda=sumirajNiz(maxSumaReda);
        int sumaKolone=sumirajNiz(maxSumaKolona);
        System.out.println();
        if(sumaReda>sumaKolone)
            ispisiRed(maxSumaReda);
        else
            ispisiRed(maxSumaKolona);



        
    }

    private static void ispisiRed(int[] niz) {
        for(int i=0; i<niz.length;i++){
            System.out.print(niz[i]+" ");
        }
        System.out.println();
    }

    private static int sumirajNiz(int[] niz) {
        int suma=0;
        for(int i=0;i<niz.length;i++)
            suma=suma+niz[i];
        return suma;
    }

    private static int[] naciNajvecuSumuKolona(int[][] matrica, int n) {
        int suma=0;
        int max_suma=0;
        int pozicija=0;
        for(int i=0;i<n;i++){
            for(int j=0; j<n;j++){
                suma=suma+matrica[j][i];
            }
            if(max_suma<suma){
                max_suma=suma;
                pozicija=i;
            }
            suma=0;

        }
        int [] niz=new int[n];

            for(int j=0;j<n;j++){
                niz[j]=matrica[j][pozicija];
            }


        return niz;
    }

    private static int[] naciNajvecuSumuReda(int[][] matrica, int n) {
        int suma=0;
        int max_suma=0;
        int pozicija=0;
        for(int i=0;i<n;i++){
            for(int j=0; j<n;j++){
                suma=suma+matrica[i][j];
            }
            if(max_suma<suma){
                max_suma=suma;
                pozicija=i;
            }
            suma=0;

        }
        int [] niz=new int[n];

            for(int j=0;j<n;j++){
                niz[j]=matrica[pozicija][j];
            }

        return niz;
    }

    private static void ispisiMatricu(int[][] matrica, int n) {
        for(int i=0;i<n;i++){
            System.out.println();
            for(int j=0; j<n; j++){
                System.out.print(matrica[i][j]+ " ");
            }
        }
        System.out.println();
    }

    private static int [] [] ucitajMatricu(int n) {
        
        Scanner s=new Scanner(System.in);
        
        int [] [] matrica = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0; j<n; j++){
               matrica[i][j]=s.nextInt(); 
            }
        }
        return matrica;
    }
}
