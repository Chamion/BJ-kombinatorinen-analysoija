package tietorakenteet;

/**
 * Jono-tietorakenne, joka hyväksyy arvoiksi kokonaislukuja ja joka on optimoitu
 * BJKA projektin käyttöön.
 *
 * @author Chamion
 */
public class Jono {

    // indeksi alkiolle, joka on seuraavana jonossa.
    private int paa;

    // indeksi jonon uusimmalle tulokkaalle.
    private int hanta;

    // maksimimäärä alkiota, joka ei saa ylittyä.
    private final int maxKoko;

    // taulukko, johon alkiot tallennetaan. Taulukon koko on maxKoko.
    // Alkioita ei pyyhitä taulukosta niiden poistamisen jälkeen.
    private final int[] taulukko;

    /**
     * Luo uuden jonon, joka on tyjä. Jonoon tallennettujen alkioiden määrä ei
     * saa ylittää maxKokoa. Alkioiden poistaminen jonosta vapauttaa tilaa
     * uusille.
     *
     * @param maxKoko Maksimimäärä arvoja, joita jonon tulee muistaa millä
     * tahansa hetkellä.
     */
    public Jono(int maxKoko) {
        this.paa = 0;
        this.hanta = 0;
        this.maxKoko = maxKoko;
        this.taulukko = new int[maxKoko];
    }

    /**
     * Lisää annetun arvon jonoon.
     *
     * @param arvo Lisättävä arvo.
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
        // bugi: get tyhjälle jonolla sotkee tulevan käytön.
        int palautettava = this.taulukko[this.paa];
        this.paa = (this.paa + 1) % this.maxKoko;
        return palautettava;
    }

    /**
     *
     * @return Onko jono tyhjä (ei yhtään alkiota tallennettuna)
     */
    public boolean isEmpty() {
        // bugi: palauttaa true, kun jono on täysi.
        return this.hanta == this.paa;
    }

}
