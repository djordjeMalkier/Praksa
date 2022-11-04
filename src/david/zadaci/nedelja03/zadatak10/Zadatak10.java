package david.zadaci.nedelja03.zadatak10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/*niz brijeva sa tastature
rezultat> ako je broj paran dodaje se u sumu
neparan se oduzima
negativan> kvadrat pa se gleda paran ili neparan

na kraju ceo postupak uppisati u fajl
*/
public class Zadatak10 {
    public static void main(String[] args) {
        List<Integer> inputNumbers = inputList();
        String pathFile = "C:\\Users\\Malkier_3\\IdeaProjects\\Praksa\\src\\david\\zadaci\\nedelja03\\zadatak10\\sumArithmeticOperations.txt";
        try {
            System.out.println("Sum = " + writeArithmeticToFileFunctional(inputNumbers, pathFile));
        } catch (IOException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int writeArithmeticToFile(List<Integer> inputNumbers, String pathFile) throws IOException {
        if (inputNumbers == null) throw new NullPointerException("List of input numbers is null");

        int sumOfInputNumbers = 0;
        try (FileWriter myWriter = new FileWriter(pathFile)) {
            int newNum;
            for (Integer num : inputNumbers) {
                if (num < 0) {
                    newNum = addToSum(num * num);
                    if (newNum < 0)
                        myWriter.write("-(" + num + ")^2 ");
                    else
                        myWriter.write("+(" + num + ")^2 ");
                } else {
                    newNum = addToSum(num);
                    if (newNum < 0)
                        myWriter.write(newNum + " ");
                    else
                        myWriter.write("+" + newNum + " ");
                }
                sumOfInputNumbers += newNum;
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException | NullPointerException e) {
            throw new IOException(e.getMessage());
        }
        return sumOfInputNumbers;
    }

    private static int writeArithmeticToFileFunctional(List<Integer> inputNumbers, String pathFile) throws IOException {
        if (inputNumbers == null) throw new NullPointerException("List of input numbers is null");
        int sumOfInputNumbers = 0;

        Stream<ArrayList<String>> pozitivniParni = inputNumbers.stream()
                .filter(x -> x >= 0)
                .filter(x -> x % 2 == 0)
                .map(x -> new ArrayList<>(Arrays.asList(x.toString(), x.toString(), "+")));

        Stream<ArrayList<String>> pozitivniNeparni = inputNumbers.stream()
                .filter(x -> x >= 0)
                .filter(x -> x % 2 != 0)
                .map(x -> new ArrayList<>(Arrays.asList(x.toString(), "-" + x, "-")));

        Stream<ArrayList<String>> negativniParni = inputNumbers.stream()
                .filter(x -> x < 0)
                .map(x -> x * x)
                .filter(x -> x % 2 == 0)
                .map(x -> new ArrayList<>(Arrays.asList(((int)Math.sqrt(x))+"", x+"", "+2")));

        Stream<ArrayList<String>> negativniNeparni = inputNumbers.stream()
                .filter(x -> x < 0)
                .map(x -> x * x)
                .filter(x -> x % 2 != 0)
                .map(x -> new ArrayList<>(Arrays.asList("-"+((int)Math.sqrt(x))+"", "-"+x, "-2")));

        Stream<ArrayList<String>> result = Stream.concat( Stream.concat(pozitivniParni, pozitivniNeparni),
                       Stream.concat(negativniParni, negativniNeparni));

        result.forEach(System.out::println);

        return sumOfInputNumbers;
    }

    private static int addToSum(int number) {
        return (number % 2 == 0) ? number : -number;
    }

    private static List<Integer> inputList() {
        List<Integer> inputNumbers = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextInt())
                inputNumbers.add(sc.nextInt());
        }
        return inputNumbers;
    }
}
