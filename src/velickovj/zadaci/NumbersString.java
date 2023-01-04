package velickovj.zadaci;

import java.math.BigInteger;
import java.util.*;

public class NumbersString {
    public static void main(String[] args) {
        String string = "14115785965";
        List<BigInteger> list=new ArrayList<>();


        if(!string.matches("[0-9]+")){
            System.out.println("Ne sadrzi samo cifre");
            System.exit(0);
        }

        for(int i=0; i<string.length();i++){
            for (int j=i; j<string.length(); j++) {
                BigInteger number=new BigInteger(string.substring(i,j+1));
               if (number.isProbablePrime(1))
                    list.add(number);
            }
        }
        System.out.println(list);
        System.out.println(listFilter(list));
    }

    public static BigInteger listFilter(List<BigInteger> list){
        while (true) {
            BigInteger number=list.get(0);
            list.remove(0);
            if (!list.contains(number))
                return number;
        }

    }


}


