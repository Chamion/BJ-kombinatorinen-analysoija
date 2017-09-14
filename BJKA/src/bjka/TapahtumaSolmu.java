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
    private Pakka pakka;
    private TapahtumaSolmu[] seuraavat;
    private double[] todennakoisyydet;
    
    public TapahtumaSolmu(int arvo){
        this.arvo = arvo;
    }
    
    public TapahtumaSolmu(int arvo, Pakka pakka){
        this.arvo = arvo;
        this.pakka = pakka;
        this.seuraavat = new TapahtumaSolmu[10];
    }
    
    public void laskeTodennakoisyydet(){
        this.todennakoisyydet = pakka.todennakoisyysVektori();
    }
    
    public void sido(int kortti, TapahtumaSolmu seuraava){
        if(kortti < 0 || kortti >= 10){
            kortti = 0;
        }
        this.seuraavat[kortti] = seuraava;
    }
}
