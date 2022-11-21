package zivkovicj.zadaci;

import java.util.*;
import java.util.stream.Collectors;

public class RandomPrirodniBrojevi {
    public static void main(String[] args) {

        /*Napraviti niz od 10 slučajnih prirodnih brojeva manjih od 100 i ispisati ih.
        Naći aritmetičku sredinu niza i odrediti koji je član niza najbliži aritmetičkoj sredini i ispisati ih.*/
        ArrayList<Integer> list = new ArrayList<>();
        int n = 10;

        System.out.println("Lista brojeva: " + listOfRandomNumbers(list));
        System.out.println("Aritmeticka sredina: " + meanNumber(list, n));
        System.out.println("Element najblizi aritmetickoj sredini: " + closestToMeanNumber(list, n));
    }

    public static List<Integer> listOfRandomNumbers(ArrayList<Integer> list){
        Random randomNumber = new Random();
        int n = 10;
        for (int i = 0; i < n; i++) {
            int broj = randomNumber.nextInt(0, 99);
            list.add(broj);
        }
        return list;
    }
    public static int sumOfListElements(ArrayList<Integer> list){
        return list.stream()
                .reduce(0, Integer::sum);
    }

    public static double meanNumber(ArrayList<Integer> list, int n){
        return (double) sumOfListElements(list) / n;
    }

    public static int closestToMeanNumber(ArrayList<Integer> list, int n){
        return list.stream()
                .min(Comparator.comparingInt(i -> (int) Math.abs(i-meanNumber(list, n))))
                .orElseThrow(() -> new NoSuchElementException("Nema takvog broja"));
    }

}
