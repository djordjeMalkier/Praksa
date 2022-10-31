package david.zadaci.nedelja03;

import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert table size: ");
        int tableSize;
        if (sc.hasNextInt()) {
            tableSize = sc.nextInt();
            int startI = 0, startJ = 0;
            int endI = 4, endJ = 5;
            findPath(tableSize, startI, startJ, endI, endJ);
        }
        else
            System.err.println("Input is not integer");

        sc.close();
    }

    private static boolean findPath(int tableSize, int startI, int startJ, int endI, int endJ) {
        if (startI == endI && startJ == endJ)
            return true;

        Pair end = new Pair(endI, endJ);
        ArrayList<Pair> possiblePlaces = possiblePlacesForKnight(tableSize, startI, startJ);
        for (Pair position : possiblePlaces)
            if (position.equals(end)) {
                System.out.println("(" + startI + ", " + startJ + ")");
                System.out.println(position);
                return true;
            }

        for (Pair position : possiblePlaces)
            return findPath(tableSize, position.getFirst(), position.getSecond(), endI, endJ);

        return false;
    }

    private static ArrayList<Pair> possiblePlacesForKnight(int tableSize, int i, int j) {
        ArrayList<Pair> possiblePlaces = new ArrayList<>();
        if (inRange(tableSize, i, j)) {
            if (inRange(tableSize, i - 2, j - 1)) possiblePlaces.add(new Pair(i - 2, j - 1));
            if (inRange(tableSize, i - 2, j + 1)) possiblePlaces.add(new Pair(i - 2, j + 1));
            if (inRange(tableSize, i + 2, j - 1)) possiblePlaces.add(new Pair(i + 2, j - 1));
            if (inRange(tableSize, i + 2, j + 1)) possiblePlaces.add(new Pair(i + 2, j + 1));
            if (inRange(tableSize, i - 1, j - 2)) possiblePlaces.add(new Pair(i - 1, j - 2));
            if (inRange(tableSize, i - 1, j + 2)) possiblePlaces.add(new Pair(i - 1, j + 2));
            if (inRange(tableSize, i + 1, j - 2)) possiblePlaces.add(new Pair(i + 1, j - 2));
            if (inRange(tableSize, i + 1, j + 2)) possiblePlaces.add(new Pair(i + 1, j + 2));
        }
        return possiblePlaces;
    }

    private static boolean inRange(int tableSize, int i, int j) {
        return i >= 0 && i <= tableSize - 1 && j >= 0 && j <= tableSize - 1;
    }
}
