package velickovj.nedelja02;

import java.io.IOException;


import static david.zadaci.nedelja02.Zadatak04.inputArray;

public class Zadatak08 {

    public static int najvecaRazlika(int [] niz){
        int max=0;
        int razlika=0;
        for(int i=0; i<niz.length;i++){
            for(int j=i;j<niz.length;j++){
                if(niz[i]-niz[j]<0){

                    razlika=niz[i]-niz[j];
                }
                if(max<Math.abs(razlika))
                    max=Math.abs(razlika);
            }
        }

        return Math.abs(max);
    }


    public static void main(String[] args) {
        try {
            int[] array=inputArray();
            int razlika=najvecaRazlika(array);
            if(razlika <0){
                System.out.println("Ne postoje dva takva elementa");
            }else{
                System.out.println(razlika);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
