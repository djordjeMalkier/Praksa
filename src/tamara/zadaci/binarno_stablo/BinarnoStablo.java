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
        int razlikaUVisini = vratiRazlikuUVisini(cvor);

        // Ako je razlika veća od 1, rotiraj
        if (razlikaUVisini > 1) {
            // Ako je visina lijevog podstabla veća, rotiraj ulevo
            if (vratiRazlikuUVisini(cvor.getLijevo()) > 0) {
                cvor = rotirajULijevo(cvor);
            } else {
                // U suprotnom, udesno
                cvor = zarotirajDesnoLijevo(cvor);
            }
        } else if (razlikaUVisini < -1) {
            // Ako je razlika manja od -1, rotiraj udesno
            if (vratiRazlikuUVisini(cvor.getDesno()) < 0) {
                cvor = rotirajUDesno(cvor);
            } else {
                // U suprotnom, rotiraj lijevo-desno
                cvor = zarotirajLijevoDesno(cvor);
            }
        }

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

    public void dubinaStabla() {
        System.out.println("\nDubina je: " + dubina(korijen));
    }

    private int dubina(Cvor cvor) {
        if (cvor == null) {
            return 0;
        }
        int dubinaLijevog = dubina(cvor.getLijevo());
        int dubinaDesnog = dubina(cvor.getDesno());
        return 1 + Math.max(dubinaLijevog, dubinaDesnog);
    }

}
