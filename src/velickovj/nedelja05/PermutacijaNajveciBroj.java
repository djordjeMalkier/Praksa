package src.velickovj.nedelja05;

import java.util.Arrays;
import java.util.Scanner;

public class PermutacijaNajveciBroj {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int broj=scanner.nextInt();
        if(broj<0)
            broj=Math.abs(broj);

        int niz [] =pretvoriUNiz(broj);
        Arrays.sort(niz);

        System.out.println(pretvoriUBroj(niz));
    }



    private static int prebrojiCifre(int broj){
        int brojac=0;
        while(broj>0){
            brojac++;
            broj=broj/10;
        }
        return brojac;
    }

    private static int [] pretvoriUNiz(int broj){
        int [] niz=new int[prebrojiCifre(broj)];
        int i=0;
        while(broj>0){
           niz[i]=broj%10;
           i++;
           broj=broj/10;
        }
        return niz;
    }

    private static void ispisiNiz(int [] niz){
        for(int i=0;i<niz.length;i++)
            System.out.print(niz[i]+" ");
    }

    private static int pretvoriUBroj(int [] niz){
        int broj=0;

        for(int i=0;i<niz.length;i++){

            broj=broj+niz[i]*(int)Math.pow(10,i);

        }
        return broj;
    }


}
