package velickovj.nedelja04;

import zivkovicj.vrednostProizvoda.Proizvod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KupovinaProizvoda {
    public static void main(String[] args) {
        List<Proizvod> proizvodi=new ArrayList<>();
        Proizvod p1=new Proizvod("p1",100,80);
        Proizvod p2=new Proizvod("p2",200,100);
        Proizvod p3=new Proizvod("p3",300,150);
        Proizvod p4=new Proizvod("p4",400,385);
        Proizvod p5=new Proizvod("p5",500,125);
        proizvodi.add(p1);
        proizvodi.add(p2);
        proizvodi.add(p3);
        proizvodi.add(p4);
        proizvodi.add(p5);
        List<Double> listaCena=new ArrayList<>();
        List<Double> listaVrednosti=new ArrayList<>();
        for(Proizvod p: proizvodi){
            listaVrednosti.add(p.getVrednost());
            listaCena.add(p.getCena());
        }

        Scanner scanner=new Scanner(System.in);
        double budzet=scanner.nextDouble();
        double profit=maxProfit(budzet, listaCena, listaVrednosti, proizvodi.size());

        System.out.println(profit);

    }
    public static double maxProfit( double budzet, List<Double> cena,List<Double> vrednost,  int n){

        if(budzet==0 || n==0)
            return 0;

        if(cena.get(n-1)>budzet){

            return maxProfit(budzet,cena,vrednost,n-1);
        }
        else
            return Math.max(vrednost.get(n-1) + maxProfit(budzet - cena.get(n-1), cena, vrednost, n - 1),
                    maxProfit(budzet, cena, vrednost, n - 1));

    }
}
