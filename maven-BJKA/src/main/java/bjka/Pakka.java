package bjka;

/**
 *
 * @author jemisalo
 */
public class Pakka {

    /*
    Taulukon arvot esittavat eri arvoisten korttien lukumaaria.
    Taulukon arvot ovat aina jarjestyksessa 10, 1, 2, 3, 4, 5, 6, 7, 8, 9
    Esim. 10-arvoisten korttien lukumaara on indeksissa 0 ja 7-arvoisten korttien lukumara indeksissa 7.
     */
    private final int[] lukumaarat;

    // Korttien yhteismaara.
    private int koko;

    public Pakka(int[] lukumaarat) {
        this.lukumaarat = lukumaarat;
        this.koko = 0;
        for (int lukumaara : this.lukumaarat) {
            koko += lukumaara;
        }
    }

    /**
     * Laskee ja palauttaa taulukon, jossa korttien arvot ovat samassa
     * jarjestyksessa kuin lukumaarat-taulukossa. Todennakoisyysvektorin lukujen
     * summa on 1.
     *
     * @return Vektori, joka esittaa eri arvoisten korttien todennakoisyyksia
     * tulla nostetuksi pakasta seuraavana.
     */
    public double[] todennakoisyysVektori() {
        double[] tVektori = new double[10];
        for (int i = 0; i <= 9; i++) {
            tVektori[i] = (double) this.lukumaarat[i] / this.koko;
        }
        return tVektori;
    }

    /**
     * Luo ja palauttaa uuden pakan, jossa on kaikki pakan kortit, paitsi
     * parametrina annettu kortti.
     *
     * @param kortti Kortti, joka poistetaan pakasta.
     * @return Pakka, joka jaa jaljelle kortin poistamisen jalkeen.
     */
    public Pakka poistaKortti(int kortti) {
        kortti = kortti % 10;
        int[] uudetLukumaarat = this.lukumaarat.clone();

        // Lukumaara voi menna negatiiviseksi. Tulos on kuitenkin aina oikein (negatiivinen todennakoisyys kerrotaan aina nollalla).
        uudetLukumaarat[kortti] -= 1;
        return new Pakka(uudetLukumaarat);
    }

    public int[] getLukukumaarat() {
        return this.lukumaarat;
    }

    public int getKoko() {
        return this.koko;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() == this.getClass()) {
            return this.equals((Pakka) o);
        } else {
            return false;
        }
    }

    private boolean equals(Pakka o) {
        for (int i = 0; i <= 9; i++) {
            if (this.lukumaarat[i] != o.getLukukumaarat()[i]) {
                return false;
            }
        }
        return true;
    }
}
