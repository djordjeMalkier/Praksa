package tamara.zadaci;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ListaSaBrojevimaNe3 {

    public static void main(String[] args) {
        List<Integer> listaBrojeva = new ArrayList<>();

        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite elemente liste: ");
        int broj = 0;
        int brojac = 0;

        while(listaBrojeva.size() < 10) {
            try {
                if(!ulaz.hasNextInt()) {
                    ulaz.next();
                    throw new InputMismatchException("Nije broj.");
                }
                broj = ulaz.nextInt();
                if(broj % 3 == 0) {
                    throw new Broj3Exception("Ne mozete unijeti broj djeljiv sa 3.");
                }
                listaBrojeva.add(broj);

            } catch (InputMismatchException ime) {
                System.out.println(ime.getMessage());
            } catch (Broj3Exception e) {
                brojac++;
                System.out.println(e.getMessage());
            }
        }

        for (Integer integer : listaBrojeva) {
            System.out.print(integer + " ");
        }

        System.out.println("\nBroj elemenata koji nisu uneseni je: " + brojac);
    }


}
