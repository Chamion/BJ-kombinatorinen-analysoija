package bjka;

import kello.KelloRajapinta;

public class Suorituskykytesti {

    /**
     *
     * @param alkuKortit analysoijan parametri alkuKortti jokaiselle
     * kierrokselle. Oltava yhtä suuri kuin pakat.
     * @param pakat analysoijan parametri pakka jokaiselle kierrokselle. Oltava
     * yhtä suuri kuin alkuKortit.
     * @param kello Kello, joka mittaa laskentaan kuluneen ajan. Parametrina
     * testejä varten.
     */
    public static void suorituskykytesti(int[] alkuKortit, Pakka[] pakat, KelloRajapinta kello) {
        Analysoija analysoija = new Analysoija();
        long aika;

        //Aika alkaa.
        aika = kello.nanoTime();

        //Silmukka käsittelee kaikki alkiot parametrina annetuista taulukoista indeksi kerrallaan.
        for (int i = 0; i < alkuKortit.length; i++) {
            analysoija.analysoi(alkuKortit[i], pakat[i]);
        }

        //Aika päättyy.
        aika = kello.nanoTime() - aika;

        System.out.println("Todennäköisyyksien laskeminen jokaisella alkukortilla kesti " + aika + " nanosekuntia.");
    }

}
