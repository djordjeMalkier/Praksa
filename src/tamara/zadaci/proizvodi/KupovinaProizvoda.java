package tamara.zadaci.proizvodi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KupovinaProizvoda {
    public static void main(String[] args) throws Exception {

        Proizvod p1 = new Proizvod("solja",     100, 80);
        Proizvod p2 = new Proizvod("casa",      200, 100);
        Proizvod p3 = new Proizvod("marker",    300, 150);
        Proizvod p4 = new Proizvod("olovka",    400, 385);
        Proizvod p5 = new Proizvod("slusalice", 500, 125); //385+100+80=565

        double budzet = 800;
        double sumaProizvoda = 0;


        List<Proizvod> listaProizvoda = new ArrayList<>();
        listaProizvoda.add(p1);
        listaProizvoda.add(p2);
        listaProizvoda.add(p3);
        listaProizvoda.add(p4);
        listaProizvoda.add(p5);

        listaProizvoda.sort(Comparator.comparing(Proizvod::getVrijednost).reversed());

        System.out.println("Lista proizvoda: ");
        for (Proizvod proizvod : listaProizvoda) {
            System.out.print(proizvod + " ");
        }

        //suma cijena proizvoda
        for (Proizvod proizvod : listaProizvoda) {
            sumaProizvoda += proizvod.getCijena();
        }

        int trenutniIndeks;
        System.out.println(kupiProizvod(listaProizvoda, budzet, 0));

    }

    private static List<Proizvod> kupiProizvod(List<Proizvod> listaProizvoda, double budzet, int trenutniIndeks) {
        double sumaVrijednosti = 0;

        if(trenutniIndeks >= listaProizvoda.size())
            return null;

        List<Proizvod> kupljeniProizvodi = new ArrayList<>();

        if (budzet > 0 && listaProizvoda.get(trenutniIndeks).getCijena() <= budzet) {
            kupljeniProizvodi = kupiProizvod(listaProizvoda,
                    budzet - listaProizvoda.get(trenutniIndeks).getCijena(),
                    trenutniIndeks + 1);
            sumaVrijednosti += listaProizvoda.get(trenutniIndeks).getVrijednost();
            kupljeniProizvodi.add(listaProizvoda.get(trenutniIndeks));
        }

        System.out.println(budzet);
        return kupljeniProizvodi;
    }
}
