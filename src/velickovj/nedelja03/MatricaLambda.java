package velickovj.nedelja03;


import java.util.Scanner;

import java.util.stream.IntStream;

import static velickovj.nedelja03.MatriceSuma.ispisiMatricu;
import static velickovj.nedelja03.MatriceSuma.ucitajMatricu;

public class MatricaLambda {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int n=s.nextInt();
        int [] [] matrica=ucitajMatricu(n);
        ispisiMatricu(matrica,n);
        s.close();

        int sumaGlavneDijagonale= IntStream.range(0,n)
                .map(i->matrica[i][i])
                .sum();
        System.out.println("Suma na glavnoj dijagonali je "+sumaGlavneDijagonale);

      int sumaSporedneDijagonale=IntStream.range(0,n)
              .map(i->matrica[i][n-1-i])
              .sum();



        System.out.println("Suma na sporednoj dijagonali je "+sumaSporedneDijagonale);

        int sumaIspodGlavneDijagonale=IntStream.range(0,n*n)
                .filter(i->i/n>i%n)
                .map(i->matrica[i/n][i%n])
                .sum();


        System.out.println("Suma ispod glavne dijagonale je "+sumaIspodGlavneDijagonale);


        int sumaIznadGlavneDijagonale= IntStream.range(0,n*n)
                .filter(i->i/n<i%n)
                .map(i->matrica[i/n][i%n])
                .sum();

        System.out.println("Suma iznad glavne dijagonale je "+sumaIznadGlavneDijagonale);

        int sumaIspodSporedne=IntStream.range(0,n*n)
                .filter(i->(i/n+i%n)>n-1)
                .map(i->matrica[i/n][i%n])
                .sum();

        System.out.println("Suma ispod sporedne dijagonale je "+sumaIspodSporedne);

        int sumaIznadSporedne=IntStream.range(0,n*n)
                .filter(i->(i/n+i%n)<n-1)
                .map(i->matrica[i/n][i%n])
                .sum();

        System.out.println("Suma iznad sporedne dijagonale je "+sumaIznadSporedne);

        int proizvod=IntStream.range(0,n*n)
                .filter(i->i/n!=i%n)
                .filter(i->(i/n+i%n)!=n-1)
                .map(i->matrica[i/n][i%n])
                .reduce((a,b)->a*b)
                .orElse(1);
        System.out.println("Proizvod je "+proizvod);

    }


}
