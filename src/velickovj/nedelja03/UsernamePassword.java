package velickovj.nedelja03;


import mirzad.zadaci.jsonException.LoginException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class UsernamePassword {
    static String ime;
    static String sifra;
    static String username;
    static String password;
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
        System.out.println(username);
        System.out.println(password);


      /*  System.out.println(username);
        System.out.println(password);
*/

        boolean flag=false;

        while(!flag ){
        try {

            flag=porediStringove() ;
            System.out.println("Uspesno ste logovani");
        } catch (IzuzetakUsernamePassword e) {

            System.out.println(e.getMessage());;

        }}


        scanner.close();


    }

    public static boolean porediStringove() throws IzuzetakUsernamePassword {
        Scanner scanner=new Scanner(System.in);
        String insertedUsername = "";
        String insertedPassword = "";

        System.out.println("Unesite username: ");
        insertedUsername = scanner.nextLine();

        System.out.println("Unesite Pasword");
        insertedPassword = scanner.nextLine();

        if(!insertedUsername.equals(username) || !insertedPassword.equals(password)) {
            throw new IzuzetakUsernamePassword("Pogresan password ili username.");
        }

        return true;

    }

    public static void ucitajImeISifru(){
        Scanner scanner1=new Scanner(System.in);
        ime= scanner1.next();
        sifra=scanner1.next();
        scanner1.close();
    }
}
