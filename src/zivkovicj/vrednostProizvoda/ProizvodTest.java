package zivkovicj.vrednostProizvoda;

import java.util.*;

public class ProizvodTest {
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

        ArrayList<ArrayList<Proizvod>> niz = new ArrayList<>();
        ArrayList<Proizvod> indeksi = new ArrayList<>();

        for (int i = 0; i < proizvodi.size(); i++) {
            recurseAdd(i, niz, indeksi, proizvodi, new ArrayList<Double>(), new ArrayList<Double>(),0, 0, budzet);
        }

        System.out.println("Konacni proizvodi sa najvecom vrednoscu: " + listaVr.get(0));
        System.out.println(niz.get(0));

    }

    private static void recurseAdd(int currentIndex, ArrayList<ArrayList<Proizvod>> niz, ArrayList<Proizvod> indeksi,
                                   ArrayList<Proizvod> proizvodi, List<Double> cene,
                                   List<Double> vrednosti, double sumVrednost, double sum, double budzet) {

        if (currentIndex >= proizvodi.size()) {
            return;
        }

        sum = sum + proizvodi.get(currentIndex).cena;
        cene.add(proizvodi.get(currentIndex).cena);
        sumVrednost = sumVrednost + proizvodi.get(currentIndex).vrednost;
        vrednosti.add(proizvodi.get(currentIndex).vrednost);
        indeksi.add(proizvodi.get(currentIndex));



        if (sum == budzet) {
            System.out.print("Cene: " + cene);
            System.out.println();
            System.out.print("Vrednosti: " + vrednosti);
            System.out.println();
            System.out.print("Ukupna vrednost: " + vrednosti.stream().mapToDouble(Double::doubleValue).sum() + "\n");
            System.out.println("----------");
            ArrayList<Proizvod> konacno = new ArrayList<>();
            konacno.addAll(indeksi);
            niz.add(konacno);
            indeksi.clear();

            listaVr.add(vrednosti.stream().mapToDouble(Double::doubleValue).sum());
            return;
        }
        if (sum > budzet) {
            indeksi.remove(indeksi.size() - 1);
            return;
        }

        for (int i = currentIndex + 1; i < proizvodi.size(); i++) {
            recurseAdd(i, niz, indeksi, new ArrayList<>(proizvodi), new ArrayList<>(cene),
                    new ArrayList<>(vrednosti), sumVrednost, sum, budzet);
        }
    }
}
