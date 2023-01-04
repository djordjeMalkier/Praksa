package zivkovicj.zadaci;

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

                {1, 1, 1},
                {1, 1, 1}
        };


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        //horizontal
        int sumHoriznotal = 0;
        int countHorizontal = 0;
        int maxHorizontal = 0;
       // int counter = 0;
        int sum = 0;
        List<Integer> lista = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            boolean flag1 = false;
            // boolean flag2 = false;
            for (int j = 0; j < matrix[i].length-1; j++) {
                if(matrix[i][j] == 1) {

                        if ((matrix[i][j] == matrix[i][j + 1] || matrix[i][j] == matrix[i + 1][j])) {
                            countHorizontal++;
                            matrix[i][j] = 0;
                            flag1 = true;
                        }
                    if ((matrix[i][j] == matrix[i][j + 1] && matrix[i][j] == matrix[i + 1][j])) {
                        countHorizontal = 2 + countHorizontal;
                        matrix[i][j] = 0;
                        flag1 = true;
                    }
                }
                sumHoriznotal += countHorizontal;
            }
            //sum += counter;
            lista.add(sumHoriznotal);
           // lista2.add(sum);
            sumHoriznotal = 0;
            //sum = 0;
        }
        System.out.println("Duzine reka:");
        System.out.println(lista);
        System.out.println(Collections.max(lista));
        //System.out.println(counter);
        //System.out.println(counter);
        //System.out.println(sumHoriznotal);
    }


}


