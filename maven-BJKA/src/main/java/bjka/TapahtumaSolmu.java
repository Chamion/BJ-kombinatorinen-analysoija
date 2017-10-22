package bjka;

/**
 *
 * @author jemisalo
 */
public class TapahtumaSolmu {

    // Jakajan kaden arvo.
    private final int arvo;

    // Onko jakajan kasi pehmea, ts. ei kova.
    // Ei aina true, vaikka kadessa olisi assa.
    private final boolean assa;

    // Todennakoisyys, etta tapahtumasolmuun paadytaan.
    private double todennakoisyys;

    // Jaljella oleva pakka.
    private final Pakka pakka;

    /**
     *
     * @param arvo Jakajan kaden arvo.
     * @param assa Onko jakajan kasi pehmea, ts. ei kova. Ei aina true, vaikka
     * kadessa olisi assa.
     * @param todennakoisyys Todennakoisyys, etta tapahtumasolmuun paadytaan.
     * @param pakka Jaljella oleva pakka.
     */
    public TapahtumaSolmu(int arvo, boolean assa, double todennakoisyys, Pakka pakka) {
        this.arvo = arvo;
        this.assa = assa;
        this.pakka = pakka;
        this.todennakoisyys = todennakoisyys;
    }

    /**
     * Todennakoisyysvektori tulee Pakka-olion
     * todennakoisyysVektori()-metodilla. Kaikki vektorin todennakoisyydet
     * kerrotaan solmun todennakoisyydella.
     *
     * @return todennakoisyysvektori, joka esittaa seuraavien tapahtumasolmujen
     * todennakoisyyksia taman solmun kautta.
     */
    public double[] laskeTodennakoisyydet() {
        double[] tVektori = this.pakka.todennakoisyysVektori();
        for (int i = 0; i <= 9; i++) {
            tVektori[i] = tVektori[i] * this.todennakoisyys;
        }
        return tVektori;
    }

    /**
     * Kutsuu pakka-olion poistaKortti-metodia.
     *
     * @param kortti poistaKortti-metodin parametri. Poistettava kortti.
     * @return poistaKortti-metodin palautus. Uusi pakka, jossa on kaikki taman
     * solmun pakan kortit, paitsi poistettu kortti.
     */
    public Pakka seuraavaPakka(int kortti) {
        return this.pakka.poistaKortti(kortti);
    }

    /**
     * Kasvattaa solmun todennakoisyytta. Kaytetaan, kun useampi kuin yksi
     * tapahtuma johtaa samaan solmuun duplikaattien valttamiseksi.
     *
     * @param lisays Todennakoisyys, joka lisataan solmun todennakoisyyteen.
     */
    public void lisaaTodennakoisyys(double lisays) {
        this.todennakoisyys += lisays;
    }

    public int getArvo() {
        return this.arvo;
    }

    public boolean getAssa() {
        return this.assa;
    }

    public double getTodennakoisyys() {
        return this.todennakoisyys;
    }

    public Pakka getPakka() {
        return this.pakka;
    }

}
