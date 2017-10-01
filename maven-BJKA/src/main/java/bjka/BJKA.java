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
public class BJKA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Analysoija analysoija = new Analysoija();

        // Jakajan kortti 1 ja jäljellä oleva pakka on 6 tavallista korttipakkaa.
        long aika;
        aika = System.nanoTime();
        double[] tulos = analysoija.analysoi(10, new Pakka(new int[]{95, 24, 24, 24, 24, 24, 24, 24, 24, 24}));
        
        aika = System.nanoTime() - aika;
        
        System.out.println("17: " + tulos[0]);
        System.out.println("18: " + tulos[1]);
        System.out.println("19: " + tulos[2]);
        System.out.println("20: " + tulos[3]);
        System.out.println("21: " + tulos[4]);
        System.out.println("BJ: " + tulos[6]);
        System.out.println("Yli: " + tulos[5]);
        System.out.println("Yhteensä:" + (tulos[0] + tulos[1] + tulos[2] + tulos[3] + tulos[4] + tulos[5] + tulos[6]));
        System.out.println("Aika: " + aika + " nanosekuntia");
    }

}
