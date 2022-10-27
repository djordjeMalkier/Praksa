package tamara.zadaci;

public class MaxRazlikaDvaBroja {
    public static void main(String[] args) {
        int[] niz = {5, 3, 2, 10, 15, 1};
        int maxRazlika = Integer.MIN_VALUE;
        int razlika = 0;

        for(int i = 0; i < niz.length; i++) {
            for(int j = i + 1; j < niz.length; j++) {
                razlika = niz[j] - niz[i];
                if(maxRazlika < razlika) {
                    maxRazlika = razlika;
                }
            }
        }

        if(maxRazlika < 0) {
            maxRazlika = -1;
        }

        System.out.println("Najveca razlika je: " + maxRazlika);
    }

}

