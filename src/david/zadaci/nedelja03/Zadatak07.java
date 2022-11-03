package david.zadaci.nedelja03;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
* Unosi se do 10 elemenata u listu
* ako se unese broj deljiv sa tri ne unosi se u listu i baca se izuzetak
* na kraju ispisati unete brojeve bez deljivih sa 3
* i koliko je bilo brojeva deljivih sa 3
* */

public class Zadatak07 {
    public static void main(String[] args) {
        List<Integer> inputElements = new ArrayList<>();
        int numDividedBy3 = 0;

        Scanner scanner = new Scanner(System.in);
        while (inputElements.size() < 10) {
            try {
                inputWithout3(scanner, inputElements);
            } catch(InputNumber3Exception e){
                System.err.println(e.getMessage());
                numDividedBy3++;
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
        scanner.close();

        inputElements.forEach(System.out::println);
        System.out.println("Elements divided by 3: " + numDividedBy3);
    }

    private static void inputWithout3(Scanner scanner, List<Integer> inputElements)
            throws InputNumber3Exception, InputMismatchException {

        if (!scanner.hasNextInt()) {
            scanner.next();
            throw new InputMismatchException("Not a number!");
        }
        int inputNumber = scanner.nextInt();
        if (inputNumber % 3 == 0)
            throw new InputNumber3Exception("Number is divided by 3");

        inputElements.add(inputNumber);
    }
}
