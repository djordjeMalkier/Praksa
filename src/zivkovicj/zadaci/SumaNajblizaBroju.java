package zivkovicj.zadaci;

import java.util.*;

public class SumaNajblizaBroju {
    public static void main(String[] args) {
    /*za neki zadati niz, i broj N unet sa tastature, potrebno je pronaci par brojeva cija je suma najbliza broju N*/

        ArrayList<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(4);
        list.add(3);
        list.add(8);
        list.add(10);
        list.add(11);

        System.out.println("Unesite niz: ");
        Scanner scanner =  new Scanner(System.in);
        int broj = scanner.nextInt();
        System.out.println("Suma najbliza unetom broju");
        System.out.println(closestToSumOfTwoNumbers(list, broj));
    }
   public static int closestToSumOfTwoNumbers(ArrayList<Integer> list, int broj){
       ArrayList<Integer> listOfSumNumbers = new ArrayList<>();
       ArrayList<Par> parovi = new ArrayList<>();
       Par pair = null;
       for (int i = 0; i < list.size(); i++) {
           for (int j = i+1; j < list.size(); j++) {
               listOfSumNumbers.add(list.get(i) + list.get(j));
               parovi.add(new Par(list.get(i),list.get(j)));
           }
       }

       return listOfSumNumbers.stream()
             .min(Comparator.comparingInt(i -> (int) Math.abs(i-broj)))
             .orElseThrow(() -> new NoSuchElementException("Nema takvog broja"));
    }
}
