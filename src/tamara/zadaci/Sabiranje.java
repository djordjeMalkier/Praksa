package tamara.zadaci;

public class Sabiranje {
    public static void main(String[] args) {
        int broj = 9596989;
        broj = Math.abs(broj);
        int poslednjaCifra;
        int suma = 0;

        while(broj != 0) {
            poslednjaCifra = broj % 10;
            suma += poslednjaCifra;
            broj /= 10;
        }
        while(suma > 9) {
            poslednjaCifra = suma % 10;
            suma = suma / 10;
            suma = suma + poslednjaCifra;
        }
        System.out.println("Zbir je: " + suma);


        System.out.println("Slovima: " + cifraUString(suma));
    }

    private static String cifraUString(int suma) {
        switch(suma) {
            case 0: return "nula";
            case 1: return "jedan";
            case 2: return "dva";
            case 3: return "tri";
            case 4: return "cetiri";
            case 5: return "pet";
            case 6: return "sest";
            case 7: return "sedam";
            case 8: return "osam";
            case 9: return "devet";
            default: return "Greska";
        }
    }
}
