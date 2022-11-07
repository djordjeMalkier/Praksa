package mirzad.zadaci;

import org.w3c.dom.Node;

import java.util.*;

// A queue node used in BFS
class Pozicija
{
    int x, y, dist;

    public Pozicija(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Pozicija(int x, int y, int dist)
    {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pozicija node = (Pozicija) o;
        return x == node.x &&
                y == node.y &&
                dist == node.dist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, dist);
    }
}

class SahovskaTabla
{
    private static int[] row = { 2, 2, -2, -2, 1, 1, -1, -1 };
    private static int[] col = { -1, 1, 1, -1, 2, -2, 2, -2 };

    private static boolean isValid(int x, int y, int N) {
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }

    public static int findShortestDistance(Pozicija src, Pozicija dest, int N, ArrayList<Pozicija> putanja)
    {
        Set<Pozicija> visited = new HashSet<>();

        Queue<Pozicija> q = new ArrayDeque<>();
        q.add(src);

        while (!q.isEmpty())
        {
            Pozicija node = q.poll();

            int x = node.x;
            int y = node.y;
            int dist = node.dist;

            if (x == dest.x && y == dest.y) {
                return dist;
            }

            if (!visited.contains(node))
            {
                visited.add(node);
                putanja.add(node);

                for (int i = 0; i < row.length; i++)
                {
                    int x1 = x + row[i];
                    int y1 = y + col[i];

                    if (isValid(x1, y1, N)) {
                        q.add(new Pozicija(x1, y1, dist + 1));
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args)
    {

        int N = 8;
        ArrayList<Pozicija> putanja = new ArrayList<>();
        Pozicija src = new Pozicija(0, 0);
        Pozicija dest = new Pozicija(7, 7);

        System.out.println("Broj skokova: " +
                findShortestDistance(src, dest, N,putanja));
    }
}