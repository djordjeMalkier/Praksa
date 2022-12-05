package velickovj.zadaci;

import java.util.ArrayList;
import java.util.List;

public class Rivers {



    public static void main(String[] args) {
        int [][] matrixRiver={
                { 1, 0, 1,},
                { 1, 1, 0,},
                { 1, 0, 1 },
                { 0, 0, 1 }
        };

        List<Integer> riverLength=new ArrayList<>();
        int counter;
        int length;

        for(int i=0; i<matrixRiver.length; i++){
            for (int j=0; j<matrixRiver[i].length;j++){
                if(matrixRiver[i][j] == 1){
                    matrixRiver[i][j]=0;
                    counter=1;
                    length= findRiver(matrixRiver,i,j,counter);
                    riverLength.add(length);
                }

            }
        }

        for (int i=0; i<riverLength.size();i++)
            System.out.println(riverLength.get(i)+" ");

    }

    public static int findRiver(int[][] matrix, int i, int j, int counter){
        if(i < matrix.length -1 && matrix[i+1][j] == 1){
            matrix[i+1][j] = 0;
            counter++;
            counter = findRiver(matrix, i+1, j, counter);
        }

        if(i > 0 && matrix[i-1][j] == 1){
            matrix[i-1][j] = 0;
            counter++;
            counter = findRiver(matrix, i-1, j, counter);
        }
        if(j < matrix[0].length -1 && matrix[i][j+1] == 1){
            matrix[i][j+1] = 0;
            counter++;
            counter = findRiver(matrix, i, j+1, counter);
        }

        if(j>0 && matrix[i][j-1] == 1){
            matrix[i][j-1]=0;
            counter++;
            counter= findRiver(matrix,i,j-1, counter);
        }

        return counter;

    }

}
