package src.velickovj.nedelja03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IzuzeciDeljivSaTri {
    static int brojac=0;
    public static void main(String[] args) {
        List<Integer> lista=new ArrayList<>();

        for(int i=0;i<10;i++) {
            try {
                ucitajBroj(lista);
            } catch (DeljenjeSaTri e) {
                brojac++;
                System.out.println(e.getMessage());;
            }
        }
        ispisiListu(lista);
        System.out.println("Uneli ste "+brojac+" brojeva deljivih sa 3");




    }
    public static void ucitajBroj(List<Integer> lista) throws DeljenjeSaTri {

        Scanner scanner=new Scanner(System.in);
        int broj=scanner.nextInt();
        if(broj%3==0)
            throw new DeljenjeSaTri("Uneli ste broj deljiv sa 3");
        lista.add(broj);

    }

    public static void ispisiListu(List<Integer> lista){
        for(int i=0;i<lista.size();i++){
            System.out.print(" "+lista.get(i));
        }
        System.out.println();
    }
}
