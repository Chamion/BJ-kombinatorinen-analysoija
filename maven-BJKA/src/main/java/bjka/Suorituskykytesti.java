/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjka;

import kello.KelloRajapinta;


public class Suorituskykytesti {

    public static void suorituskykytesti(Pakka alkuPakka,int[] alkuKortit, Pakka[] pakat, KelloRajapinta kello) {
        Analysoija analysoija = new Analysoija();
        long aika;
        aika = kello.nanoTime();
        
        for(int i=0; i<alkuKortit.length; i++){
            analysoija.analysoi(alkuKortit[i], pakat[i]);
        }
        
        aika = kello.nanoTime() - aika;
        
        System.out.println("Todennäköisyyksien laskeminen jokaisella alkukortilla kesti " + aika + " nanosekuntia.");
    }

}
