/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjka;

import tietorakenteet.Jono;

/**
 *
 * @author jemisalo
 */
public class Analysoija {

    public Analysoija() {

    }

    public double[] analysoi(int alkukortti, Pakka pakka) {

        //Päättyneet tapahtumaketjut merkataan tulosvektoriin.
        double[] tulos = new double[]{0,0,0,0,0,0,0};

        TapahtumaSolmu alkuSolmu = new TapahtumaSolmu(alkukortti, alkukortti == 1, 1.0, pakka);

        // Jonoon lisätään tapahtumasolmut, jotka jatkuvat vielä.
        Jono jono = new Jono(1000);

        // Tapahtumasolmut talletetaan Map-tietorakenteeseen, jotta alkion olemassaolon tarkistaminen on nopeampaa. O(1) vs. O(n)
        TapahtumaSolmu[] map = new TapahtumaSolmu[2206];

        int alkukoodi = 0;

        // Käsitellään ensimmäinen tapahtumasolmu erikseen BJ-erikoistapauksen takia.
        double[] alkuTVektori = alkuSolmu.laskeTodennakoisyydet();
        if (alkuSolmu.getAssa()) {
            tulos[6] += alkuTVektori[0];
        } else if (alkuSolmu.getArvo() + 10 >= 17) {
            tulos[tulosIndeksi(alkuSolmu.getArvo() + 10)] += alkuTVektori[0];
        } else {
            map[alkukoodi + koodi(10)] = new TapahtumaSolmu(alkuSolmu.getArvo() + 10, false, alkuTVektori[0], alkuSolmu.seuraavaPakka(10));
            jono.lisaa(alkukoodi + koodi(10));
        }
        if (alkukortti == 10) {
            tulos[6] += alkuTVektori[1];
        } else if (alkuSolmu.getArvo() + 11 >= 17) {
            tulos[tulosIndeksi(alkuSolmu.getArvo() + 11)] += alkuTVektori[1];
        } else {
            map[alkukoodi + koodi(1)] = new TapahtumaSolmu(alkuSolmu.getArvo() + 1, true, alkuTVektori[1], alkuSolmu.seuraavaPakka(1));
            jono.lisaa(alkukoodi + koodi(1));
        }
        for (int i = 2; i <= 9; i++) {
            kasitteleTapahtuma(i, alkuTVektori[i], alkukoodi, alkuSolmu, jono, map, tulos);
        }

        // Silmukka käy läpi kaikki mahdolliset tapahtumaketjut.
        while (!jono.isEmpty()) {
            int seuraavaKoodi = jono.get();
            kasitteleTapahtumaHaara(seuraavaKoodi, jono, map, tulos);
        }

        return tulos;
    }

    private void kasitteleTapahtuma(int tapahtuma, double tapahtumaTodennakoisyys, int lahtokoodi, TapahtumaSolmu lahtoSolmu, Jono jono, TapahtumaSolmu[] map, double[] tulos) {
        // Todennäköisyysvektoreissa 10 on koodattu nollaksi. Käännetään takaisin.
        if (tapahtuma == 0) {
            tapahtuma = 10;
        }

        int uusiArvo = lahtoSolmu.getArvo() + tapahtuma;

        // Jos jakaja jää, kirjataan tulos ja käsittely päättyy.
        if (lahtoSolmu.getAssa() || tapahtuma == 1) {
            if (uusiArvo >= 7 && uusiArvo <= 11) {
                tulos[tulosIndeksi(uusiArvo + 10)] += tapahtumaTodennakoisyys;
                return;
            }
        }
        if (uusiArvo >= 17) {
            tulos[tulosIndeksi(uusiArvo)] += tapahtumaTodennakoisyys;
            return;
        }

        // Uuden tapahtumasolmun kokonaislukukoodi. ks. koodi()
        int uusiKoodi = lahtokoodi + koodi(tapahtuma);

        boolean uusiAssa = lahtoSolmu.getAssa() || tapahtuma == 1;

        if (map[uusiKoodi] != null) {
            // Jos tapahtumasolmu on jo Map-oliossa, ei lisätä sitä uudestaan, vaan päivitetään vain sen todennäköisyys.
            map[uusiKoodi].lisaaTodennakoisyys(tapahtumaTodennakoisyys);
        } else {
            // Jos tapahtumasolmu ei ole Map-oliossa, lisätään se myös jonoon käsiteltäväksi.
            map[uusiKoodi] = new TapahtumaSolmu(uusiArvo, uusiAssa, tapahtumaTodennakoisyys, lahtoSolmu.seuraavaPakka(tapahtuma));
            jono.lisaa(uusiKoodi);
        }
    }

    private void kasitteleTapahtumaHaara(int lahtokoodi, Jono jono, TapahtumaSolmu[] map, double[] tulos) {

        TapahtumaSolmu lahtoSolmu = map[lahtokoodi];
        double[] tVektori = lahtoSolmu.laskeTodennakoisyydet();

        // Käydään läpi ja käsitellään kaikki mahdolliset tapahtumat: 10, 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (int i = 0; i <= 9; i++) {
            kasitteleTapahtuma(i, tVektori[i], lahtokoodi, lahtoSolmu, jono, map, tulos);
        }
    }

    /**
     * Kokonaislukukoodi voidaan käsittää lukujonona, jossa jokainen luku
     * esittää tietyn arvoisten korttien lukumäärää jakajan kädessä. Esim. {5,
     * 7} olisi 0000010100 ja {4, 4, 4} olisi 0000003000 Yhteentörmäyksiä ei
     * tule, sillä samanarvoisia kortteja voi olla korkeintaan 9.
     *
     * @param kortti Kortti joka lisätään jakajan käteen.
     * @return Luku, joka tulee lisätä edelliseen koodiin, jotta saadaan uuden
     * tapahtumasolmun koodi.
     */
    private int koodi(int kortti) {
        switch (kortti) {
            case 1:
                return 1;
            case 2:
                return 9;
            case 3:
                return 31;
            case 4:
                return 109;
            case 5:
                return 246;
            case 6:
                return 602;
            case 7:
                return 880;
            case 8:
                return 1158;
            case 9:
                return 1484;
            default:
                return 1603;
        }
    }
    
    private int tulosIndeksi(int arvo){
        return Math.min(22, arvo) - 17;
    }

}
