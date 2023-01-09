package tamara.zadaci.binarno_stablo;

public class TestBinarnoStablo {
    public static void main(String[] args) {
        BinarnoStablo stablo = new BinarnoStablo();

        // Ubacivanje nekoliko brojeva u stablo
        stablo.ubaci(5);
        stablo.ubaci(3);
        stablo.ubaci(7);
        stablo.ubaci(1);
        stablo.ubaci(4);

        stablo.ispisiStablo(stablo.getKorijen());

        stablo.dubinaStabla();
    }
}
