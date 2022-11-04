package mirzad.zadaci.sumaPremaUslovima;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SumaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder postupak = new StringBuilder();
        boolean first = true;

        int sum = 0;
        int n;
        System.out.println("Unesite n: ");

        if (scanner.hasNextInt()) n = scanner.nextInt();
        else {
            System.out.println("Nepravilan unos.");
            return;
        }

        System.out.println("Sada unosite brojeve.");
        while ( n-- > 0){
            int number = scanner.nextInt();
            boolean even = checkEven(number);
            if(number > 0) {
                if (even) {
                    if(first) {
                        postupak.append(number);
                        first = false;
                    }
                    else postupak.append("+").append(number);
                    sum += number;
                } else {
                    postupak.append("-").append(number);
                    sum -= number;

                }
            }else {
                int num = number*number;
                sum = addToSum(num,sum,even);
                boolean flag = checkEven(num);
                String string = "(" + number + ")²";
                if (flag) postupak.append("+").append(string);
                else postupak.append("-").append(string);
            }
            first = false;
        }

        postupak.append("=").append(sum);
        writeToFile(postupak.toString());
    }

    private static int addToSum(int number,int sum, boolean even){
        if(even) return sum + number;
        else return sum - number;
    }

    private static boolean checkEven(int number){
        return number % 2 == 0;
    }

    private static void writeToFile(String string){
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\Malkier_2\\Documents\\Zadaci\\Praksa\\src\\mirzad\\zadaci\\sumaPremaUslovima\\postupak.txt");
            myWriter.write(string);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
