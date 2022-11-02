package zivkovicj.zadaci;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Scanner;

public class SahovskaTablaKonj {
    public static void main(String[] args) {

        int mat[][] = new int[4][4];

        int p = 2, q = 2;
        int zadatax = 0;
        int zadatay = 1;
        int korak = 0;
        System.out.println(posibleKnightMoves(mat, p, q, zadatax, zadatay, korak));
    }
    /*public static boolean possibleSolution(int[][] matrix, int[][] pocetnaPozicija, int coordinates1, int coordinates2) {
        int x[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int y[] = {1, 2, 2, 1, -1, -2, -2, -1};
        pocetnaPozicija[0][0] = 0;
        if(!posibleKnightMoves(0,0,1, pocetnaPozicija, x, y)){

        }

        return true;
    }*/

    public static boolean posibleKnightMoves(int[][] matrix, int coordinates1, int coordinates2,
                                             int zadataX, int zadataY, int korak) {


        List<Pair> p = new ArrayList<>();
        int[] x = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] y = {1, 2, 2, 1, -1, -2, -2, -1};
        Pair zadatiPar= new Pair(zadataX,zadataY);

        for (int i = 0; i < 8; i++) {
            int nextPositionX = coordinates1 + x[i];
            int nextPositionY = coordinates2 + y[i];

            if (nextPositionX >= 0 && nextPositionY >= 0 &&
                    nextPositionX < matrix.length && nextPositionY < matrix.length) {
                p.add(new Pair(nextPositionX, nextPositionY));

                matrix[nextPositionX][nextPositionY] = korak;
                if(zadataX == nextPositionX && zadataY == nextPositionY ){

                    System.out.println(zadataX + " " + zadataY);

                } else{
                    posibleKnightMoves(matrix, nextPositionX, nextPositionY, zadataX, zadataY,
                            korak + 1);
                }

            }
   /* for (Pair pair : p){
        System.out.println(pair.p1 + " " + pair.p2);

    }*/

        }
        return false;
    }

    /*public static int moveHorse(List<Pair> krajnjaPutanja){
        // za zadate koordinate da
        // za odredjenu poziciju prosledjenu proveri da li su pocetne pozicije = krajnjim
        int[] x = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] y = {1, 2, 2, 1, -1, -2, -2, -1};
        posibleKnightMoves(int[][] matrix, int coordinates1, int coordinates2);
        if(krajnjaPutanja.)
    }*/

}

