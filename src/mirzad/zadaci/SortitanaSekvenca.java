package mirzad.zadaci;

import java.util.ArrayList;

public class SortitanaSekvenca {
    public static void main(String[] args) {
       int [] array = {1,2,1,2,3,-1,0,1,2,3,4,5,7,8,-5,0,1,2,3,4,5,6,7,8};
       int max = 0;
       int maxi;

       max = findMax(array, 0);
       maxi = 0;

       for(int i = 1; i < array.length; i++){
           int t = findMax(array,i);
           if (t > max){
               max = t;
               maxi = i;
           }
       }


       while (max > 0){
           System.out.println(array[maxi++]);
           max--;
       }
    }

    private static int findMax(int[] array, int start){
        int count = 1;
        int last = array[start];
        for(int i = start + 1; i < array.length; i++){
            if(array[i] > last) {
                count++;
                last = array[i];
            }
            else break;
        }
        return count;
    }
}