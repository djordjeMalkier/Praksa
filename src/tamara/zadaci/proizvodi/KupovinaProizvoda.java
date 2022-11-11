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

        List<Proizvod> listaProizvoda = new ArrayList<>();
        listaProizvoda.add(p1);
        listaProizvoda.add(p2);
        listaProizvoda.add(p3);
        listaProizvoda.add(p4);
        listaProizvoda.add(p5);

        listaProizvoda.sort(Comparator.comparing(Proizvod::getVrijednost).reversed());

        System.out.println("Lista proizvoda: ");
        for (Proizvod proizvod : listaProizvoda) {
            System.out.print(proizvod + ", ");
        }

        List<Double> listaCijena = new ArrayList<>();
        List<Double> listaVrijednosti = new ArrayList<>();

        for(Proizvod proizvod: listaProizvoda){
            listaVrijednosti.add(proizvod.getVrijednost());
            listaCijena.add(proizvod.getCijena());
        }
        System.out.println("\n");

        double budzet = 800;
        double sumaVrijednosti = maxVrijednost(budzet, listaCijena, listaVrijednosti, listaProizvoda.size());

        System.out.println("Suma vrijednosti je: " + sumaVrijednosti);

    }

    public static double maxVrijednost( double budzet, List<Double> cijena, List<Double> vrijednost,  int duzina){

        if(budzet == 0 || duzina == 0)
            return 0;

        if(cijena.get(duzina-1) > budzet){

            return maxVrijednost(budzet, cijena, vrijednost,duzina-1);
        }
        else
            return Math.max(vrijednost.get(duzina-1) +
                            maxVrijednost(budzet - cijena.get(duzina-1), cijena, vrijednost, duzina - 1),
                            maxVrijednost(budzet, cijena, vrijednost, duzina - 1));

    }
}
