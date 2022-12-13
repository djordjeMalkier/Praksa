package tamara.zadaci;

import java.util.Scanner;

public class PronaciZadatiBrojUMatrici {
    public static void main(String[] args) {
        int[][] zadataMatrica = { {1, 3, 7, 9, 15},
                                  {2, 5, 8, 17, 22},
                                  {4, 7, 10, 30, 40} };
        int red = 3;
        int kolona = 5;
        boolean pronadjenBroj = false;

        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite broj: ");
        int broj = ulaz.nextInt();

        int razlikaOdPrvog = Math.abs(broj - zadataMatrica[0][0]);
        int razlikaOdPoslednjeg = Math.abs(broj - zadataMatrica[red-1][kolona-1]);

        if(razlikaOdPrvog < razlikaOdPoslednjeg) {
            for (int i = 0; i < red; i++) {
                for (int j = 0; j < kolona; j++) {
                    if (zadataMatrica[i][j] > broj)
                        break;
                    if (broj == zadataMatrica[i][j]) {
                        System.out.println("Broj " + broj + " postoji na poziciji [" + i + ", " + j + "]");
                        pronadjenBroj = true;
                        return;
                    }
                }
            }
        }
        if (razlikaOdPrvog > razlikaOdPoslednjeg) {
            for (int i = red - 1; i >= 0; i--) {
                for (int j = kolona - 1; j >= 0; j--) {
                    if (zadataMatrica[i][j] < broj)
                        break;
                    if (broj == zadataMatrica[i][j]) {
                        System.out.println("Broj " + broj + " postoji na poziciji [" + i + ", " + j + "]");
                        pronadjenBroj = true;
                        return;
                    }
                }
            }
        }
        if(pronadjenBroj == false) {
            System.out.println("Broj " + broj + " ne postoji u matrici.");
        }
    }
}
