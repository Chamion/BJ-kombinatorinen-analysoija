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
public class TapahtumaSolmu {
    
    private final int arvo;
    private final boolean assa;
    private double todennakoisyys;
    private final Pakka pakka;
    
    public TapahtumaSolmu(int arvo, boolean assa, double todennakoisyys, Pakka pakka){
        this.arvo = arvo;
        this.assa = assa;
        this.pakka = pakka;
        this.todennakoisyys = todennakoisyys;
    }
    
    public double[] laskeTodennakoisyydet(){
        double[] tVektori = this.pakka.todennakoisyysVektori();
        for(int i = 0; i <= 9; i++){
            tVektori[i] = tVektori[i]*this.todennakoisyys;
        }
        return tVektori;
    }
    
    public Pakka seuraavaPakka(int kortti){
        return this.pakka.poistaKortti(kortti);
    }
    
    public void lisaaTodennakoisyys(double lisays){
        this.todennakoisyys += lisays;
    }
    
    public int getArvo(){
        return this.arvo;
    }
    
    public boolean getAssa(){
        return this.assa;
    }
    
}
