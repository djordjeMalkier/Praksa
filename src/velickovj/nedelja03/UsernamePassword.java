package velickovj.nedelja03;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class UsernamePassword {
    static String ime;
    static String sifra;
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("src/velickovj/nedelja03/usernamepassword");
        String[] strings = new String[2];
        int i =0;
        Scanner scanner = new Scanner(file);
        String line;
        while (scanner.hasNextLine()) {
            line=scanner.next();
            if(line.equals("'{") || line.equals("}'"))
                continue;
            strings[i++]=line;


          /*  System.out.println(line);*/


        }
        String username=strings[0].split(":")[1].split("\"")[1];
        String password=strings[1].split(":")[1].split("\"")[1];



      /*  System.out.println(username);
        System.out.println(password);
*/
        ucitajImeISifru();
        boolean flag=false;
        boolean flag2=false;
        while(!flag && !flag2){
        try {

            flag=(porediStringove(username,ime) );
                    flag2=porediStringove(password,sifra);
            System.out.println("Uspesno ste logovani");
        } catch (IzuzetakUsernamePassword e) {

            System.out.println(e.getMessage());;

        }}


        scanner.close();


    }

    public static boolean porediStringove(String s1, String s2) throws IzuzetakUsernamePassword {

        ucitajImeISifru();
        if(!s1.equals(s2))
            throw new IzuzetakUsernamePassword("Nije dobro ime ili sifra");
        return true;

    }

    public static void ucitajImeISifru(){
        Scanner scanner1=new Scanner(System.in);
        ime= scanner1.next();
        sifra=scanner1.next();
        scanner1.close();
    }
}
