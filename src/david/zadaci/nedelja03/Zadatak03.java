package david.zadaci.nedelja03;

import java.util.ArrayList;
/*
* Za pocetnu i krajnju poziciju na sahovskoj tabli NxN
* naci najkraci put skokom konja
* */
public class Zadatak03 {
    private static int minPathLen = Integer.MAX_VALUE;
    private static ArrayList<Pair> minPath = new ArrayList<>();

    public static void main(String[] args) {
        int tableSize = 8;
        ArrayList<Pair> visited = new ArrayList<>();
        Pair start = new Pair(0, 0);
        Pair end = new Pair(7, 4);
        findPath(tableSize, start, end, visited);

        minPath.forEach(System.out::println);
        System.out.println(minPathLen-1 + " jumps");
        for (Pair position : minPath) {
            drawTable(tableSize, position);
        }
    }

    private static void drawTable(int tableSize, Pair position) {
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                if (i == position.getFirst() && j == position.getSecond())
                    System.out.print("x ");
                else System.out.print("- ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean findPath(int tableSize, Pair start, Pair end, ArrayList<Pair> path) {
        path.add(start);

        if (start.equals(end)) {
            if (path.size() < minPathLen) {
                minPathLen = path.size();
                minPath = new ArrayList<>(path);
                return true;
            }
            return false;
        }

        for (Pair position : possiblePlacesForKnight(tableSize, start.getFirst(), start.getSecond())) {
            if (!path.contains(position)) {
                if (distance(path.get(path.size() - 1), end) > distance(position, end)) {
                    findPath(tableSize, position, end, path);
                }
                path.remove(position);
            }
        }

        path.remove(start);
        return false;
    }

    private static double distance(Pair start, Pair end) {
        double ac = Math.abs(end.getSecond() - start.getSecond());
        double cb = Math.abs(end.getFirst() - start.getFirst());
        return Math.hypot(ac, cb);
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
