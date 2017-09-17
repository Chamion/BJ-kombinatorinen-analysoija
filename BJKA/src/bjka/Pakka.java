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
public class Pakka {
    
    private final int[] lukumaarat;
    private int koko;
    
    public Pakka(int[] lukumaarat){
        this.lukumaarat = lukumaarat;
        this.koko = 0;
        for(int lukumaara : this.lukumaarat){
            koko += lukumaara;
        }
    }
    
    public double[] todennakoisyysVektori(){
        double[] tVektori = new double[10];
        for(int i=0; i<=9; i++){
            tVektori[i] = (double) this.lukumaarat[i]/koko;
        }
        return tVektori;
    }
    
    public Pakka poistaKortti(int kortti){
        kortti = siivoaKortti(kortti);
        int[] uudetLukumaarat = this.lukumaarat.clone();
        uudetLukumaarat[kortti] -= 1;
        return new Pakka(uudetLukumaarat);
    }
    
    private int siivoaKortti(int kortti){
        if(kortti < 0 || kortti >= 10){
            return 0;
        }
        return kortti;
    }
}
