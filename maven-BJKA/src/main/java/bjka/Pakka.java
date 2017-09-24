/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjka;

/**
 *
 * @author jemisalo
 */
public class Pakka {

    /*
    Taulukon arvot esittävät eri arvoisten korttien lukumääriä.
    Taulukon arvot ovat aina järjestyksessä 10, 1, 2, 3, 4, 5, 6, 7, 8, 9
    Esim. 10-arvoisten korttien lukumäärä on indeksissä 0 ja 7-arvoisten korttien lukumärä indeksissä 7.
     */
    private final int[] lukumaarat;

    // Korttien yhteismäärä.
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
     * järjestyksessä kuin lukumäärät-taulukossa. Todennäköisyysvektorin lukujen
     * summa on 1.
     *
     * @return Vektori, joka esittää eri arvoisten korttien todennäköisyyksiä
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
     * @return Pakka, joka jää jäljelle kortin poistamisen jälkeen.
     */
    public Pakka poistaKortti(int kortti) {
        kortti = kortti % 10;
        int[] uudetLukumaarat = this.lukumaarat.clone();

        // Lukumäärä voi mennä negatiiviseksi. Tulos on kuitenkin aina oikein (negatiivinen todennäköisyys kerrotaan aina nollalla).
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
    public boolean equals(Object o){
        if(o.getClass()==this.getClass()){
            return this.equals((Pakka) o);
        } else {
            return false;
        }
    }
    
    private boolean equals(Pakka o){
        for(int i = 0; i <= 9; i++){
            if(this.lukumaarat[i] != o.getLukukumaarat()[i]){
                return false;
            }
        }
        return true;
    }
}
