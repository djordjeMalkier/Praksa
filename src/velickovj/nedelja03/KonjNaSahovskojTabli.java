package velickovj.nedelja03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KonjNaSahovskojTabli {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        System.out.println("Unesi pocetne koordinate");
        int x1=s.nextInt();
        int y1=s.nextInt();
        System.out.println("Unesi krajnje koordinate");
        int x2=s.nextInt();
        int y2=s.nextInt();

        List<Par> putanja= new ArrayList<Par>();
        putanja=pronadjiPut(x1,y1,x2,y2,n);
        s.close();
        for(int i=0; i<putanja.size();i++){
            System.out.print(putanja.get(i).toString()+" ");
        }
    }

    public static List<Par> pronadjiPut(int x1, int y1, int x2, int y2, int n ) {

        Par trenutni=new Par(x1,y1);


        List<Par> posecen =new ArrayList<>();
        posecen.add(trenutni);

        List<Par> put=new ArrayList<>();

        put.add(trenutni);

        if(trenutni.getX()==x2 && trenutni.getY()==y2)
            return put;

        if(sledeci1(x1,y1,n)!=new Par(-1,-1) && !posecen.contains(sledeci1(x1,y1,n))){
            trenutni=sledeci1(x1,y1,n);
            posecen.add(trenutni);
            put.add(trenutni);
            pronadjiPut(trenutni.getX(), trenutni.getY(), x1,x2,n);

        }
        else if(sledeci2(x1,y1,n)!=new Par(-1,-1) && !posecen.contains(sledeci2(x1,y1,n))){
            trenutni=sledeci2(x1,y1,n);
            posecen.add(trenutni);
            put.add(trenutni);
            pronadjiPut(trenutni.getX(), trenutni.getY(), x1,x2,n);

        }else if(sledeci3(x1,y1,n)!=new Par(-1,-1) && !posecen.contains(sledeci3(x1,y1,n))){
            trenutni=sledeci3(x1,y1,n);
            posecen.add(trenutni);
            put.add(trenutni);
            pronadjiPut(trenutni.getX(), trenutni.getY(), x1,x2,n);

        }
        else if(sledeci4(x1,y1,n)!=new Par(-1,-1) && !posecen.contains(sledeci4(x1,y1,n))){
            trenutni=sledeci4(x1,y1,n);
            posecen.add(trenutni);
            put.add(trenutni);
            pronadjiPut(trenutni.getX(), trenutni.getY(), x1,x2,n);

        }



        return put;
    }

    public static Par sledeci1(int x1, int y1, int n){
        if(x1-2>0 && y1-1>0){
            return new Par(x1-2, y1-1);
        }
        return new Par(-1,-1);
    }
    public static Par sledeci2(int x1, int y1, int n){
        if(x1-2>0 && y1+1<n){
            return new Par(x1-2, y1-1);
        }
        return new Par(-1,-1);
    }
    public static Par sledeci3(int x1, int y1, int n){
        if(x1+2<n && y1-1>0){
            return new Par(x1-2, y1-1);
        }
        return new Par(-1,-1);
    }
    public static Par sledeci4(int x1, int y1, int n){
        if(x1+2<n && y1+1<n){
            return new Par(x1-2, y1-1);
        }
        return new Par(-1,-1);
    }
}
