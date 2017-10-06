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
public class Suorituskykytesti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Analysoija analysoija = new Analysoija();
        Pakka alkuPakka = new Pakka(new int[]{96, 24, 24, 24, 24, 24, 24, 24, 24, 24});
        Pakka[] pakat = new Pakka[11];
        for(int i=1; i<=10; i++){
            pakat[i] = alkuPakka.poistaKortti(i);
        }
        long aika;
        aika = System.nanoTime();
        
        for(int i=1; i<=10; i++){
            analysoija.analysoi(i, pakat[i]);
        }
        
        aika = System.nanoTime() - aika;
        
        System.out.println("Todennäköisyyksien laskeminen jokaisella alkukortilla kesti " + aika + " nanosekuntia.");
    }

}
