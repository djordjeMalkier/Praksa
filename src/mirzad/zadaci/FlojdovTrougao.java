package mirzad.zadaci;

public class FlojdovTrougao {
    public static void main(String[] args) {
        draw(5);
    }

    private static void draw(int n){
        int count = 1;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < i + 1; j++){
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }
}