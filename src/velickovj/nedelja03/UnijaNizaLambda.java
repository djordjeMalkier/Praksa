package velickovj.nedelja03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnijaNizaLambda {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Unesi dimenziju prvog niza");
        int n1=scanner.nextInt();
        System.out.println("Unesi prvi niz");
        int [] niz1=ucitajNiz(n1);
        System.out.println("Unesi dimenziju drugog niza");
        int n2=scanner.nextInt();
        System.out.println("Unesi drugi niz");
        int [] niz2=ucitajNiz(n2);
        scanner.close();

        List<Integer> unija=unija(Arrays.stream(niz1).boxed().toList(), Arrays.stream(niz2).boxed().toList());

        for(int i=0;i<unija.size();i++)
            System.out.print(" "+unija.get(i));
        System.out.println();

    }
    public static List<Integer> unija(List<Integer> niz1, List<Integer> niz2){
        return Stream.concat(niz1.stream(), niz2.stream())
                .distinct()
                .collect(Collectors.toList());
    }
    public static int [] ucitajNiz(int n){
        Scanner scanner=new Scanner(System.in);
        int []  niz=new int[n];
        for(int i=0;i<n;i++){
            niz[i]=scanner.nextInt();
        }
        return niz;
    }

    public static void ispisiNiz(int [] niz, int n){
        for (int i=0;i<n;i++)
            System.out.println(" "+niz[i]);
        System.out.println();
    }
}
