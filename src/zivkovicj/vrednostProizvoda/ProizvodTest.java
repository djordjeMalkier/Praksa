package zivkovicj.vrednostProizvoda;

import java.util.*;

public class ProizvodTest {
    //public static double sumVrednost;
    public static List<Double> listaVr = new ArrayList<>();
    public static void main(String[] args) {

        ArrayList<Proizvod> proizvodi = new ArrayList<>();
        proizvodi.add(new Proizvod("banana", 100, 2));
        proizvodi.add(new Proizvod("jabuka", 200, 6));
        proizvodi.add(new Proizvod("mango", 300, 1));
        proizvodi.add(new Proizvod("grozdje", 400, 7));
        proizvodi.add(new Proizvod("lubenica", 500, 10));

        Collections.sort(proizvodi);
        Collections.reverse(proizvodi);

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite budzet za kupovinu");
        double budzet = sc.nextDouble();
        double ukupnaCenaProizvoda = 0.0;


        for (Proizvod p : proizvodi) {
            ukupnaCenaProizvoda += p.cena;
        }
        ArrayList<Proizvod> proizvodi2 = new ArrayList<>();

        for(int i = 0; i < proizvodi.size(); i++) {
            recurseAdd(i,  new ArrayList<ArrayList<Integer>>(), proizvodi,  new ArrayList<Double>(), new ArrayList<Double>(), proizvodi2,0,0, budzet);
        }
        System.out.print("Lista vrednosti ");
        System.out.println(listaVr);
        for (Proizvod p : proizvodi2){
            System.out.println(p);
        }

    }
    private static void recurseAdd(int currentIndex, ArrayList<ArrayList<Integer>> niz, ArrayList<Proizvod> proizvodi, List<Double> usedNumbers,
                                   List<Double> vrednosti, List<Proizvod> proizvodi2, double sumVrednost, double sum, double budzet) {
        if (currentIndex >= proizvodi.size()) {
            return;
        }
        ArrayList<Integer> indeksi = new ArrayList<>();
        sum = sum + proizvodi.get(currentIndex).cena;
        usedNumbers.add(proizvodi.get(currentIndex).cena);
        sumVrednost = sumVrednost + proizvodi.get(currentIndex).vrednost;
        vrednosti.add(proizvodi.get(currentIndex).vrednost);
        indeksi.add(currentIndex);
        niz.add(indeksi);

        if (sum == budzet) {
            System.out.print("Cene: ");
            System.out.println(usedNumbers);
            System.out.print("Vrednosti: ");
            System.out.println(vrednosti);
            System.out.print("Ukupna vrednost: " + vrednosti.stream().mapToDouble(Double::doubleValue).sum() + "\n");
            System.out.println("----------");


            listaVr.add(vrednosti.stream().mapToDouble(Double::doubleValue).sum());
            for (Integer n : niz.get(0)){
                proizvodi2.add(proizvodi.get(n));
            }
            return;
        }
        if (sum > budzet) {
            return;
        }

        for (int i = currentIndex + 1; i < proizvodi.size(); i++) {
            recurseAdd(i, niz, new ArrayList<>(proizvodi), new ArrayList<>(usedNumbers),
                    new ArrayList<>(vrednosti),proizvodi2, sumVrednost, sum, budzet);
        }
    }
}
