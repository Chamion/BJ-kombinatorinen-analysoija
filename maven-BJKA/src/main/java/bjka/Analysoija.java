package bjka;

import tietorakenteet.Jono;

/**
 *
 * @author jemisalo
 */
public class Analysoija {

    public Analysoija() {

    }

    /**
     * Laskee Blackjack jakajan kaden todennakoisyydet.
     *
     * @param alkukortti Jakajan kaden ensimmainen kortti.
     * @param pakka Jaljella oleva pakka, josta kortit nostetaan. Alkukortti ei
     * sisally pakkaan.
     * @return Tulosvektori, joka sisaltaa jakajan kaden todennakoisyydet
     * seuraavassa jarjestyksessa. [17, 18, 19, 20, 21, bust, BJ]
     */
    public double[] analysoi(int alkukortti, Pakka pakka) {

        //Paattyneet tapahtumaketjut merkataan tulosvektoriin.
        double[] tulos = new double[]{0, 0, 0, 0, 0, 0, 0};

        TapahtumaSolmu alkuSolmu = new TapahtumaSolmu(alkukortti, alkukortti == 1, 1.0, pakka);

        // Jonoon lisataan tapahtumasolmut, jotka jatkuvat viela.
        //Jonon koko selvitettiin kokeilemalla yha pienempia arvoja, kunnes testit eivat enaa menneet lapi.
        Jono jono = new Jono(91);

        // Tapahtumasolmut talletetaan Map-tietorakenteeseen, jotta alkion olemassaolon tarkistaminen on nopeampaa. O(1) vs. O(n)
        TapahtumaSolmu[] map = new TapahtumaSolmu[2191];

        int alkukoodi = 0;

        // Kasitellaan ensimmainen tapahtumasolmu erikseen BJ-erikoistapauksen takia.
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

        // Silmukka kay lapi kaikki mahdolliset tapahtumaketjut.
        while (!jono.isEmpty()) {
            int seuraavaKoodi = jono.get();
            kasitteleTapahtumaHaara(seuraavaKoodi, jono, map, tulos);
        }

        return tulos;
    }

    /**
     * Kasittelee yhden lahtoSolmun lapsista. Jos lapsi on paatossolmu, se
     * merkataan tulosvektoriin. Jos lapsi on tapahtumaSolmu, se tallennetaan
     * map ja jono rakenteisiin.
     *
     * @param tapahtuma uusi kortti, joka nostettiin
     * @param tapahtumaTodennakoisyys Edellisen solmun todennakoisyyden ja
     * tapahtuman todennakoisyyden tulo.
     * @param lahtokoodi Edellisen solmun kokonaislukukoodi
     * @param lahtoSolmu Edellinen solmu
     * @param jono Jono, johon uusien solmujen koodit tallennetaan
     * @param map Taulukko, johon uudet solmut tallennetaan
     * @param tulos Tulosvektori, johon uudet paatossolmut merkataan
     */
    private void kasitteleTapahtuma(int tapahtuma, double tapahtumaTodennakoisyys, int lahtokoodi, TapahtumaSolmu lahtoSolmu, Jono jono, TapahtumaSolmu[] map, double[] tulos) {
        // Todennakoisyysvektoreissa 10 on koodattu nollaksi. Kaannetaan takaisin.
        if (tapahtuma == 0) {
            tapahtuma = 10;
        }

        int uusiArvo = lahtoSolmu.getArvo() + tapahtuma;

        // Jos jakaja jaa, kirjataan tulos ja kasittely paattyy.
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
            // Jos tapahtumasolmu on jo Map-oliossa, ei lisata sita uudestaan, vaan paivitetaan vain sen todennakoisyys.
            map[uusiKoodi].lisaaTodennakoisyys(tapahtumaTodennakoisyys);
        } else {
            // Jos tapahtumasolmu ei ole Map-oliossa, lisataan se myos jonoon kasiteltavaksi.
            map[uusiKoodi] = new TapahtumaSolmu(uusiArvo, uusiAssa, tapahtumaTodennakoisyys, lahtoSolmu.seuraavaPakka(tapahtuma));
            jono.lisaa(uusiKoodi);
        }
    }

    /**
     * Muodostaa solmun kaikki lapset ja kasittelee ne.
     *
     * @param lahtokoodi Jonosta poimittu solmun kokonaislukukoodi
     * @param jono Jono, johon uusien solmujen koodit tallennetaan
     * @param map Taulukko, johon uudet solmut tallennetaan
     * @param tulos Tulosvektori, johon uudet paatossolmut merkataan
     */
    private void kasitteleTapahtumaHaara(int lahtokoodi, Jono jono, TapahtumaSolmu[] map, double[] tulos) {

        TapahtumaSolmu lahtoSolmu = map[lahtokoodi];
        double[] tVektori = lahtoSolmu.laskeTodennakoisyydet();

        // Kaydaan lapi ja kasitellaan kaikki mahdolliset tapahtumat: 10, 1, 2, 3, 4, 5, 6, 7, 8, 9
        for (int i = 0; i <= 9; i++) {
            kasitteleTapahtuma(i, tVektori[i], lahtokoodi, lahtoSolmu, jono, map, tulos);
        }
    }

    /**
     * Kokonaislukukoodi on summa, missa jokainen kadessa oleva kortti
     * alkukorttia lukuunottamatta on lisaa tietyn vakion koodiin. Vakio riippuu
     * kortin arvosta.
     *
     * Vakiot on valittu siten, ettei yhteentormayksia tapahdu mahdollisissa
     * Blackjack kasissa.
     *
     * @param kortti Kortti joka lisataan jakajan kateen.
     * @return Luku, joka tulee lisata edelliseen koodiin, jotta saadaan uuden
     * tapahtumasolmun koodi.
     */
    private int koodi(int kortti) {
        switch (kortti) {
            case 1:
                return 1;
            case 2:
                return 10;
            case 3:
                return 71;
            case 4:
                return 237;
            case 5:
                return 509;
            case 6:
                return 828;
            case 7:
                return 1095;
            case 8:
                return 1188;
            case 9:
                return 418;
            default:
                return 115;
        }
    }

    private int tulosIndeksi(int arvo) {
        return Math.min(22, arvo) - 17;
    }

}
