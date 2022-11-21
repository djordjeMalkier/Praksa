package src.velickovj.nedelja06;

import java.util.Scanner;

public class SumaNajblizaBroju {
    static int a;
    static int b;
    public static void main(String[] args) {
        int [] niz={5,4,3,8,10,11};
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        scanner.close();
        najvecaSumaUNizu(niz,N);
        System.out.println("("+a+","+b+")");


    }

    private static void najvecaSumaUNizu(int [] niz, int N){

        int maxSuma=Integer.MAX_VALUE;
        for(int i=0;i<niz.length;i++){
           for(int j=i+1; j<niz.length; j++){
               if(Math.abs(N-(niz[i]+niz[j]))<maxSuma){

                   maxSuma=Math.abs(N-(niz[i]+niz[j]));

                   a=niz[i];
                   b=niz[j];
               }

           }
        }
        ;
    }
}
