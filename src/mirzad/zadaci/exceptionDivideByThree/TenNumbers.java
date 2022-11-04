package mirzad.zadaci.exceptionDivideByThree;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TenNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
// textfile upisan username i password
        //treba da ucita podatke i da se unese user i pass da li je ispravno
        int count = 0;
        int n = 10;

        while (n > 0) {
            try {
                n--;
              addToList(numbersList,scanner);
            } catch (ThreeException e) {
                count++;
                System.out.println(e.getMessage());
            } catch (InputMismatchException e){
                String a = scanner.nextLine();
                System.out.println(e.getMessage());
            }
        }

        numbersList.forEach(System.out::println);
        System.out.println("Broj deljivih sa tri: " + count);

    }

    public static void addToList(ArrayList<Integer> list, Scanner scanner) throws ThreeException, InputMismatchException {
        int a;

       if(scanner.hasNextInt()) {
           a = scanner.nextInt();
           if (a % 3 == 0) {
               throw new ThreeException("Broj je deljiv sa tri!");
           }
           list.add(a);
        } else throw new InputMismatchException("Nevalidan unos.");

    }

}
