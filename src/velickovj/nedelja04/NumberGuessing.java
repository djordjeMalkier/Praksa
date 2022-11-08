package velickovj.nedelja04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int broj;
        Random rand = new Random();
        int broj_random = rand.nextInt(1000);

        boolean provera=true;
        System.out.println("Pogodite broj");
        broj=scanner.nextInt();
        int brojac=0;
        while(provera){
            brojac++;
            if(broj==broj_random){
                System.out.println("Broj "+broj+" je pogodjen u koraku broj "+brojac);
                provera=false;
            }
            else if(broj>broj_random){
                System.out.println("Unesite manji broj od "+broj);
                broj=scanner.nextInt();
            }
            else {
                System.out.println("Unesite veci broj od "+broj);
                broj=scanner.nextInt();
            }

        }
    }
}
