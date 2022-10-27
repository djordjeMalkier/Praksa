package zivkovicj.zadaci;

public class FlojdovTrougao {
    public static void main(String[] args) {
        // 1
        // 2 3
        // 4 5 6
        // dijamant slova
        int br = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(br + " ");
                br++;
            }
            System.out.println();
        }
    }
}
