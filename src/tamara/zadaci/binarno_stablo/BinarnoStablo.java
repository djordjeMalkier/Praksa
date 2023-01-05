package tamara.zadaci.binarno_stablo;

public class BinarnoStablo {
    private Cvor korijen;

    public Cvor getKorijen() {
        return korijen;
    }

    public void balansiraj() {
        korijen = balansiranje(korijen);
    }
    public void ubaci(int vrijednost) {
        korijen = ubaci(korijen, vrijednost);
    }

    private Cvor ubaci(Cvor cvor, int vrijednost) {
        if (cvor == null) {
            return new Cvor(vrijednost);
        }
        if (vrijednost < cvor.getVrijednost()) {
            cvor.setLijevo(ubaci(cvor.getLijevo(), vrijednost));
        } else {
            cvor.setDesno(ubaci(cvor.getDesno(), vrijednost));
        }
        return balansiranje(cvor);
    }

    private Cvor balansiranje(Cvor cvor) {
        // Izračunajte razliku u visini levog i desnog podstabla
        int razlikaUVisini = vratiRazlikuUVisini(cvor);

        // Ako je razlika veća od 1, treba da rotiramo stablo
        if (razlikaUVisini > 1) {
            // Ako je visina levog podstabla veća, rotirajmo ulevo
            if (vratiRazlikuUVisini(cvor.getLijevo()) > 0) {
                cvor = rotirajULijevo(cvor);
            } else {
                // U suprotnom, rotirajmo udesno
                cvor = zarotirajDesnoLijevo(cvor);
            }
        } else if (razlikaUVisini < -1) {
            // Ako je razlika manja od -1, rotirajmo udesno
            if (vratiRazlikuUVisini(cvor.getDesno()) < 0) {
                cvor = rotirajUDesno(cvor);
            } else {
                // U suprotnom, rotirajmo ulevo-udesno
                cvor = zarotirajLijevoDesno(cvor);
            }
        }

        // Vratimo izbalansirani cvor
        return cvor;
    }

    private int vratiRazlikuUVisini(Cvor cvor) {
        int lijevaVisina = visina(cvor.getLijevo());
        int desnaVisina = visina(cvor.getDesno());
        return lijevaVisina - desnaVisina;
    }

    private int visina(Cvor cvor) {
        if (cvor == null) {
            return 0;
        }
        return 1 + Math.max(visina(cvor.getLijevo()), visina(cvor.getDesno()));
    }

    private Cvor rotirajULijevo(Cvor cvor) {
        Cvor noviKorijen = cvor.getDesno();
        cvor.setDesno(noviKorijen.getLijevo());
        noviKorijen.setLijevo(cvor);
        return noviKorijen;
    }

    private Cvor rotirajUDesno(Cvor cvor) {
        Cvor noviKorijen = cvor.getLijevo();
        cvor.setLijevo(noviKorijen.getDesno());
        noviKorijen.setDesno(cvor);
        return noviKorijen;
    }

    private Cvor zarotirajLijevoDesno(Cvor cvor) {
        cvor.setLijevo(rotirajULijevo(cvor.getLijevo()));
        return rotirajUDesno(cvor);
    }

    private Cvor zarotirajDesnoLijevo(Cvor cvor) {
        cvor.setDesno(rotirajUDesno(cvor.getDesno()));
        return rotirajULijevo(cvor);
    }

    public void ispisiStablo(Cvor cvor) {
        if (cvor != null) {
            ispisiStablo(cvor.getLijevo());
            System.out.print(cvor.getVrijednost() + " -> ");
            ispisiStablo(cvor.getDesno());
        }
    }
}
