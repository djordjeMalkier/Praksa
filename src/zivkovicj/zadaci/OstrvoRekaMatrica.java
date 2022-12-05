package zivkovicj.zadaci;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class OstrvoRekaMatrica {
    public static void main(String[] args) {
      /*  Scanner in = new Scanner(System.in);
        System.out.print("Input row number: ");
        int n = in.nextInt();
        System.out.print("Input column number: ");
        int m = in.nextInt();*/
        int n = 4;
        int m = 3;
        int[][] matrix = {
                {1, 0, 1,},

                {0, 1, 0,},

                {1, 0, 1},
                {1, 1, 1}
        };


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        //horizontal
        int sumHoriznotal = 0;
        int countHorizontal = 0;
        int maxHorizontal = 0;
        int counter = 0;
        int sum = 0;
        List<Integer> lista = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();
        for (int i = 0; i < matrix.length - 1; i++) {
            boolean flag1 = false;
            // boolean flag2 = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1) {
                    if(j+1 < matrix.length-1) {
                        if (matrix[i][j] == matrix[i][j + 1] || matrix[i][j] == matrix[i + 1][j]) {
                            countHorizontal++;
                            flag1 = true;
                        }
                    } else {
                        counter++;
                    }
                }
                /*if (!flag1) {
                    counter++;
                }*/
                sumHoriznotal += countHorizontal;

            }
            sum += counter;
            lista.add(sumHoriznotal);
            lista2.add(sum);
            sumHoriznotal = 0;
            sum = 0;
        }
        System.out.println("Duzine reka:");
        System.out.println(Collections.max(lista));
        System.out.println(Collections.max(lista2));
        //System.out.println(counter);
        //System.out.println(sumHoriznotal);
    }


}


