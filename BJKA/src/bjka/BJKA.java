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

        // Jakajan kortti 10 ja jäljellä oleva pakka on 6 tavallista korttipakkaa.
        TulosVektori tulos = analysoija.analysoi(10, new Pakka(new int[]{96, 24, 24, 24, 24, 24, 24, 24, 24, 24}));

        System.out.println("17: " + tulos.get(17));
        System.out.println("18: " + tulos.get(18));
        System.out.println("19: " + tulos.get(19));
        System.out.println("20: " + tulos.get(20));
        System.out.println("21: " + tulos.get(21));
        System.out.println("BJ: " + tulos.getBJ());
        System.out.println("Yli: " + tulos.get(22));
        System.out.println("Yhteensä:" + (tulos.get(17) + tulos.get(18) + tulos.get(19) + tulos.get(20) + tulos.get(21) + tulos.getBJ() + tulos.get(22)));
    }

}
