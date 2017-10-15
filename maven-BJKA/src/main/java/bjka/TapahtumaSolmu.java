package bjka;

/**
 *
 * @author jemisalo
 */
public class TapahtumaSolmu {

    // Jakajan käden arvo.
    private final int arvo;

    // Onko jakajan käsi pehmeä, ts. ei kova.
    // Ei aina true, vaikka kädessä olisi ässä.
    private final boolean assa;

    // Todennäköisyys, että tapahtumasolmuun päädytään.
    private double todennakoisyys;

    // Jäljellä oleva pakka.
    private final Pakka pakka;

    /**
     *
     * @param arvo Jakajan käden arvo.
     * @param assa Onko jakajan käsi pehmeä, ts. ei kova. Ei aina true, vaikka
     * kädessä olisi ässä.
     * @param todennakoisyys Todennäköisyys, että tapahtumasolmuun päädytään.
     * @param pakka Jäljellä oleva pakka.
     */
    public TapahtumaSolmu(int arvo, boolean assa, double todennakoisyys, Pakka pakka) {
        this.arvo = arvo;
        this.assa = assa;
        this.pakka = pakka;
        this.todennakoisyys = todennakoisyys;
    }

    /**
     * Todennäköisyysvektori tulee Pakka-olion
     * todennäköisyysVektori()-metodilla. Kaikki vektorin todennäköisyydet
     * kerrotaan solmun todennäköisyydellä.
     *
     * @return todennäköisyysvektori, joka esittää seuraavien tapahtumasolmujen
     * todennäköisyyksiä tämän solmun kautta.
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
     * @return poistaKortti-metodin palautus. Uusi pakka, jossa on kaikki tämän
     * solmun pakan kortit, paitsi poistettu kortti.
     */
    public Pakka seuraavaPakka(int kortti) {
        return this.pakka.poistaKortti(kortti);
    }

    /**
     * Kasvattaa solmun todennäköisyyttä. Käytetään, kun useampi kuin yksi
     * tapahtuma johtaa samaan solmuun duplikaattien välttämiseksi.
     *
     * @param lisays Todennäköisyys, joka lisätään solmun todennäköisyyteen.
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
