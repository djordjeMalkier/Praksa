package tamara.zadaci;

import javax.management.BadAttributeValueExpException;

public class Trougao {
    enum Tip {
        JEDNAKOSTRANICNI,
        PRAVOUGLI,
        JEDNAKOKRAKI,
        NIJE
    }
    public static void main(String[] args) {
        int[] linije = {3,4,5,4};
        try {

            for (int i = 0; i < linije.length; i++)
                for (int j = i+1; j < linije.length; j++)
                    for (int k = j+1; k < linije.length; k++) {
                        //System.out.println(linije[i] + " " + linije[j] + " " + linije[k]);
                        Tip tip = tipTrougla(linije[i], linije[i], linije[k]);
                        if (tip != Tip.NIJE) {
                            System.out.println(linije[i] + ", " + linije[j] + ", " + linije[k] + ": " +
                                    tip);
                        }
                    }
        } catch (BadAttributeValueExpException e) {
            System.err.println(e.getMessage());
        }
    }

    private static Tip tipTrougla(int a, int b, int c) throws BadAttributeValueExpException {
        if (a == 0 || b == 0 || c == 0)
            throw new BadAttributeValueExpException("Duzina stranica mora biti veca od nule");

        if (a == b && b == c)
            return Tip.JEDNAKOSTRANICNI;

        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        if (a == b || b == c || a == c) {
            if (max / 2 < min)
                return Tip.JEDNAKOKRAKI;
        }

        int maxMin = Math.max(a, Math.min(b, c));
        int minMax = Math.min(a, Math.max(b, c));
        int other = maxMin;
        if (minMax != max && minMax != min)
            other = minMax;

        if (max*max == min*min + other*other)
            return Tip.PRAVOUGLI;

        return Tip.NIJE;
    }
}

