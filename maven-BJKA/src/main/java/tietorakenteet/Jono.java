package tietorakenteet;

/**
 * Jono-tietorakenne, joka hyvaksyy arvoiksi kokonaislukuja ja joka on optimoitu
 * BJKA projektin kayttoon.
 *
 * @author Chamion
 */
public class Jono {

    // indeksi alkiolle, joka on seuraavana jonossa.
    private int paa;

    // indeksi jonon uusimmalle tulokkaalle.
    private int hanta;

    // maksimimaara alkiota, joka ei saa ylittya.
    private final int maxKoko;

    // taulukko, johon alkiot tallennetaan. Taulukon koko on maxKoko.
    // Alkioita ei pyyhita taulukosta niiden poistamisen jalkeen.
    private final int[] taulukko;

    /**
     * Luo uuden jonon, joka on tyja. Jonoon tallennettujen alkioiden maara ei
     * saa ylittaa maxKokoa. Alkioiden poistaminen jonosta vapauttaa tilaa
     * uusille.
     *
     * @param maxKoko Maksimimaara arvoja, joita jonon tulee muistaa milla
     * tahansa hetkella.
     */
    public Jono(int maxKoko) {
        this.paa = 0;
        this.hanta = 0;
        this.maxKoko = maxKoko;
        this.taulukko = new int[maxKoko];
    }

    /**
     * Lisaa annetun arvon jonoon.
     *
     * @param arvo Lisattava arvo.
     */
    public void lisaa(int arvo) {
        this.taulukko[this.hanta] = arvo;
        this.hanta = (this.hanta + 1) % this.maxKoko;
    }

    /**
     * Poistaa ja palauttaa jonossa seuraavan alkion. Vastaa dequeue-metodia.
     *
     * @return jonossa seuraava alkio.
     */
    public int get() {
        // bugi: get tyhjalle jonolla sotkee tulevan kayton.
        int palautettava = this.taulukko[this.paa];
        this.paa = (this.paa + 1) % this.maxKoko;
        return palautettava;
    }

    /**
     *
     * @return Onko jono tyhja (ei yhtaan alkiota tallennettuna)
     */
    public boolean isEmpty() {
        // bugi: palauttaa true, kun jono on taysi.
        return this.hanta == this.paa;
    }

}
