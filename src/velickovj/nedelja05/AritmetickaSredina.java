package src.velickovj.nedelja05;

import java.util.Arrays;
import java.util.Random;

public class AritmetickaSredina {
    public static void main(String[] args) {
        int [] niz=napraviNiz();
        ispisiNiz(niz);
        System.out.println();

        System.out.println("Aritmeticka sredina je: "+aritmetickaSredina(niz));
        double [] nizRazlika=nizRazlika(niz);


        int indeks=naciMainNiza(nizRazlika);
        System.out.println("Najblizi aritmetickoj sredini je: "+niz[indeks]);
    }

    private static int[] napraviNiz(){
        int [] niz=new int[10];
        Random random=new Random();
        for(int i=0;i<niz.length;i++){
            niz[i]=(random.nextInt(99)+1);
        }
        return niz;
    }

    private static void ispisiNiz(int [] niz){
        for(int i=0;i<niz.length;i++)
            System.out.print(niz[i]+" ");
    }

    private static double aritmetickaSredina(int [] niz){

        return (double)(Arrays.stream(niz).sum())/niz.length;
    }

    private static double[] nizRazlika(int [] niz){
        double[] nizRazlike=new double[10];
        double arSredina=aritmetickaSredina(niz);
        for(int i=0;i<niz.length;i++){
            nizRazlike[i]=Math.abs((double) niz[i]-arSredina);
        }
        return nizRazlike;
    }

    private static int naciMainNiza(double [] niz){
        double min=Double.MAX_VALUE;
        int indeksMin=0;
        for (int i=0;i<niz.length;i++){
            if(niz[i]<min) {
                min = niz[i];
                indeksMin = i;
            }
        }
        return indeksMin;
    }
}
