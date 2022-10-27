package zivkovicj.zadaci;

import java.util.*;

public class TrougloviStranice {
    public static void main(String[] args) {
        /*U nizu su nesortirani pozitivni brojevi, koji predstavljaju duzine linija. Potrebno je naci sve kombinacije
        linija koje mogu da formiraju trougao. Ukoliko je neki trougao jednakostranicni, ispisati JEDNAKOSTRANICNI.
        Ukoliko je neki trougao sa pravim uglom, ispisati PRAVOUGLI. Ukoliko je neki trougao jednakokraki, ispisati
        JEDNAKOKRAKI. Na primer 3,4,5 formiraju pravougli trougao. 3,3,5 formiraju jednakokraki a 5,5,5 jednakostranicni.
         1,2,5 ne mogu formirati trougao jer linije 1 i 2 zajedno
        nemaju dovoljnu duzinu kako bi se spojile.*/
        List<Integer> array = Arrays.asList(3,4,5,4,3,5,4,1,2,4,3,5,6,1,6,8,10);

        Set<List<Integer>> combinationsForJednakokraki =  combinationsForJednakokraki(array);
        System.out.println("JEDNAKOKRAKI:");
        display(combinationsForJednakokraki);

        System.out.println();

        Set<List<Integer>> combinationsForJednakostranicni =  combinationsForJednakostranicni(array);
        System.out.println("JEDNAKOSTRANICNI:");
        display(combinationsForJednakostranicni);

        System.out.println();

        Set<List<Integer>> combinationsForPravougli =  combinationsForPravougli(array);
        System.out.println("PRAVOUGLI:");
        display(combinationsForPravougli);
    }

    public static boolean isValidTriangle(List<Integer> array){

        if(array.size() < 3){
            return false;
        }
        for (int i = 0; i < array.size(); i++) {
            for (int j = i+1; j < array.size(); j++) {
                for (int k = j+1; k < array.size(); k++) {
                    //ako nije jednakokraki nije jednakostranicni, ako je jednakokraki da li je i jednakostranicni
                    if(array.get(i) + array.get(j) > array.get(k) &&
                            array.get(j) + array.get(k) > array.get(i) &&
                            array.get(k) + array.get(i) > array.get(j))
                        return true;
                }
            }
        }

        return false;
    }

    public static Set<List<Integer>> combinationsForJednakokraki(List<Integer> array){

        Set<List<Integer>> combinations = new HashSet<>();

        if(isValidTriangle(array)){
            for (int i = 0; i < array.size(); i++) {
                for (int j = i+1; j < array.size(); j++) {
                    for (int k = j+1; k < array.size(); k++) {
                        //ako nije jednakokraki nije jednakostranicni, ako je jednakokraki da li je i jednakostranicni
                        if(array.get(i) == array.get(j) || array.get(i) == array.get(k) || array.get(j) == array.get(k)){
                            List<Integer> arrayCombinations = new ArrayList<>();
                            arrayCombinations.add(array.get(i));
                            arrayCombinations.add(array.get(j));
                            arrayCombinations.add(array.get(k));
                            combinations.add(arrayCombinations);

                        }
                    }
                }
            }
        }
        return combinations;
    }

    public static Set<List<Integer>> combinationsForJednakostranicni(List<Integer> array){

        Set<List<Integer>> combinations = new HashSet<>();

        if(isValidTriangle(array)){
            for (int i = 0; i < array.size(); i++) {
                for (int j = i+1; j < array.size(); j++) {
                    for (int k = j+1; k < array.size(); k++) {
                        if(array.get(i) == array.get(j) && array.get(j) == array.get(k)){
                            List<Integer> arrayCombinations = new ArrayList<>();
                            arrayCombinations.add(array.get(i));
                            arrayCombinations.add(array.get(j));
                            arrayCombinations.add(array.get(k));
                            combinations.add(arrayCombinations);

                        }
                    }
                }
            }
        }
        return combinations;
    }

    public static Set<List<Integer>> combinationsForPravougli(List<Integer> array){

        Set<List<Integer>> combinations = new HashSet<>();

        if(isValidTriangle(array)) {
            for (Integer i : array) {
                for (Integer j : array) {
                    for (Integer k : array) {
                        if (i * i + j * j == k * k) {
                            List<Integer> arrayCombinations = new ArrayList<>();
                            arrayCombinations.add(i);
                            arrayCombinations.add(j);
                            arrayCombinations.add(k);
                            combinations.add(arrayCombinations);
                        }
                    }
                }
            }
        }
        return combinations;
    }

    public static void display(Set<List<Integer>> combinations){
        for (List<Integer> i : combinations){
            for (int j = 0; j < 3; j++) {
                System.out.print(i.get(j));
            }
            System.out.print(", ");
        }
    }

}