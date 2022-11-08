package velickovj.nedelja04;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class BrojanjeSamoglasnika {
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of("src/common/tekst.txt");
        Scanner scanner=new Scanner(fileName);

        int brojSamoglasnika=0;
        int brojSamoglasnikaUReci=0;
        int maxBrojSamoglasnika=0;
        String recSaNajviseSamoglasnika = null;
        while (scanner.hasNext()) {
            String rec=scanner.next();
            brojSamoglasnikaUReci=0;
            
            for(int i=0;i<rec.length();i++){
                if(rec.charAt(i)=='a' || rec.charAt(i)=='e' || rec.charAt(i)=='i' || rec.charAt(i)=='o' || rec.charAt(i)=='u'
                        || rec.charAt(i)=='A' || rec.charAt(i)=='E' || rec.charAt(i)=='I' || rec.charAt(i)=='O' || rec.charAt(i)=='U'){
                    brojSamoglasnika++;
                    brojSamoglasnikaUReci++;
                }

                if(maxBrojSamoglasnika<brojSamoglasnikaUReci){
                    maxBrojSamoglasnika=brojSamoglasnikaUReci;
                    recSaNajviseSamoglasnika=rec;

                }
            }

        }
        System.out.println("Broj samoglasnika je: "+brojSamoglasnika);
        System.out.println("Rec koja ima najvise samoglasnika je: "+recSaNajviseSamoglasnika+" i ona ima "+maxBrojSamoglasnika+" samoglasnika");
        scanner.close();

    }
}
