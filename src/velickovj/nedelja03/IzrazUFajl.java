package velickovj.nedelja03;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IzrazUFajl {
    public static void main(String[] args) throws IOException {
        FileWriter myWriter = new FileWriter("src/velickovj/nedelja03/izrazi.txt");

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [] niz =ucitajniz(n);


        int suma=0;

        /*uspisujemo u fajl prvi element*/
        if(niz[0]<0 && (niz[0]*niz[0])%2==0){
            myWriter.append("( "+niz[0]+" )^2");
        }
        else if(niz[0]<0 && (niz[0]*niz[0])%2!=0){
            myWriter.append("-( "+niz[0]+" )^2");
        }
        else if(niz[0]%2==0){
            myWriter.append(""+niz[0]);
        }
        else if(niz[0]%2!=0){
            myWriter.append("-"+niz[0]);
        }



        for(int i=1;i<n;i++){
            if(niz[i]<0 && (niz[i]*niz[i])%2==0){
                myWriter.append("+( "+niz[i]+" )^2");
            }
            else if(niz[i]<0 && (niz[i]*niz[i])%2!=0){
                myWriter.append("-( "+niz[i]+" )^2");
            }
            else if(niz[i]%2==0){
                myWriter.append("+"+niz[i]);
            }
            else if(niz[i]%2!=0){
                myWriter.append("-"+niz[i]);
            }
        }


        for(int i=0;i<n;i++){
            if(niz[i]<0){
                niz[i]=niz[i]*niz[i];


            }
            if(niz[i]%2==0){
                suma=suma+niz[i];
            }
            else {
                suma=suma-niz[i];
            }
        }
        myWriter.append("="+suma);

        System.out.println("Suma je: "+suma);


        myWriter.close();
        scanner.close();
    }

    private static void ispisiNiz(int[] niz) {
        for(int i=0;i<niz.length;i++)
            System.out.print(niz[i]+" ");
        System.out.println();
    }

    public static int [] ucitajniz(int n){
        Scanner scanner=new Scanner(System.in);
        int [] niz=new int[n];
        for(int i=0;i<n;i++) {
            niz[i]=scanner.nextInt();
        }
        return  niz;
    }
}

