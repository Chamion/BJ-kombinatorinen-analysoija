/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjka;

import java.util.LinkedList;
import java.util.HashMap;

/**
 *
 * @author jemisalo
 */
public class Analysoija {
    
    public Analysoija(){
        
    }
    
    public TulosVektori analysoi(int alkukortti, Pakka pakka){
        TulosVektori tulos = new TulosVektori();
        TapahtumaSolmu alkuSolmu = new TapahtumaSolmu(alkukortti, alkukortti == 1, 1.0, pakka);
        LinkedList<Integer> jono = new LinkedList();
        HashMap<Integer, TapahtumaSolmu> map = new HashMap();
        int alkukoodi = 0;
        double[] alkuTVektori = alkuSolmu.laskeTodennakoisyydet();
        if(alkuSolmu.getAssa()){
            tulos.lisaaBJ(alkuTVektori[0]);
        } else if(alkuSolmu.getArvo() + 10 >= 17){
            tulos.lisaa(alkuSolmu.getArvo() + 10, alkuTVektori[0]);
        } else {
            map.put(alkukoodi + koodi(10), new TapahtumaSolmu(alkuSolmu.getArvo() + 10, false, alkuTVektori[0], alkuSolmu.seuraavaPakka(10)));
            jono.add(alkukoodi + koodi(10));
        }
        if(alkukortti == 10){
            tulos.lisaaBJ(alkuTVektori[1]);
        } else if(alkuSolmu.getArvo() + 11 >= 17){
            tulos.lisaa(alkuSolmu.getArvo() + 11, alkuTVektori[1]);
        } else {
            map.put(alkukoodi + koodi(1), new TapahtumaSolmu(alkuSolmu.getArvo() + 1, true, alkuTVektori[1], alkuSolmu.seuraavaPakka(1)));
            jono.add(alkukoodi + koodi(1));
        }
        for(int i = 2; i <= 9; i++){
            kasitteleTapahtuma(i, alkuTVektori[i], alkukoodi, alkuSolmu, jono, map, tulos);
        }
        while(!jono.isEmpty()){
            int seuraavaKoodi = jono.poll();
            kasitteleTapahtumaHaara(seuraavaKoodi, jono, map, tulos);
        }
        return tulos;
    }
    
    private void kasitteleTapahtuma(int tapahtuma, double tapahtumaTodennakoisyys, int lahtokoodi, TapahtumaSolmu lahtoSolmu, LinkedList jono, HashMap<Integer, TapahtumaSolmu> map, TulosVektori tulos){
        if(tapahtuma == 0){
            tapahtuma = 10;
        }
        int uusiArvo = lahtoSolmu.getArvo() + tapahtuma;
        if(lahtoSolmu.getAssa() || tapahtuma == 1){
            if(uusiArvo >= 7 && uusiArvo <= 11){
                tulos.lisaa(uusiArvo + 10, tapahtumaTodennakoisyys);
                return;
            }
        }
        if(uusiArvo >= 17){
            tulos.lisaa(uusiArvo, tapahtumaTodennakoisyys);
            return;
        }
        int uusiKoodi = lahtokoodi + koodi(tapahtuma);
        boolean uusiAssa = uusiArvo < 7 && (lahtoSolmu.getAssa() || tapahtuma == 1);
        if(map.containsKey(uusiKoodi)){
            map.get(uusiKoodi).lisaaTodennakoisyys(tapahtumaTodennakoisyys);
        } else {
            map.put(uusiKoodi, new TapahtumaSolmu(uusiArvo, uusiAssa, tapahtumaTodennakoisyys, lahtoSolmu.seuraavaPakka(tapahtuma)));
            jono.add(uusiKoodi);
        }
    }
    
    private void kasitteleTapahtumaHaara(int lahtokoodi, LinkedList jono, HashMap<Integer, TapahtumaSolmu> map, TulosVektori tulos){
        TapahtumaSolmu lahtoSolmu = map.get(lahtokoodi);
        double[] tVektori = lahtoSolmu.laskeTodennakoisyydet();
        for(int i = 0; i <= 9; i++){
            kasitteleTapahtuma(i, tVektori[i], lahtokoodi, lahtoSolmu, jono, map, tulos);
        }
    }
    
    private int koodi(int kortti){
        switch (kortti){
            case 1:
                return 100000000;
            case 2:
                return 10000000;
            case 3:
                return 1000000;
            case 4:
                return 100000;
            case 5:
                return 10000;
            case 6:
                return 1000;
            case 7:
                return 100;
            case 8:
                return 10;
            case 9:
                return 1;
            default:
                return 1000000000;
        }
    }
    
}
