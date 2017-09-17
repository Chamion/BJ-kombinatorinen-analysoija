/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjka;

/**
 *
 * @author Chamion
 */
public class TulosVektori {
    
    private double tulos17;
    private double tulos18;
    private double tulos19;
    private double tulos20;
    private double tulos21;
    private double tulosBJ;
    private double tulosYli;
    
    public TulosVektori(){
        this.tulos17 = 0;
        this.tulos18 = 0;
        this.tulos19 = 0;
        this.tulos20 = 0;
        this.tulos21 = 0;
        this.tulosBJ = 0;
        this.tulosYli = 0;
    }
    
    public double get(int arvo){
        switch (arvo) {
            case 17:
                return this.tulos17;
            case 18:
                return this.tulos18;
            case 19:
                return this.tulos19;
            case 20:
                return this.tulos20;
            case 21:
                return this.tulos21;
            default:
                if(arvo > 21){
                    return this.tulosYli;
                }
                return 0.0;
        }
    }
    
    public double getBJ(){
        return this.tulosBJ;
    }
    
    public void lisaa(int arvo, double lisays){
        switch (arvo) {
            case 17:
                this.tulos17 += lisays;
                break;
            case 18:
                this.tulos18 += lisays;
                break;
            case 19:
                this.tulos19 += lisays;
                break;
            case 20:
                this.tulos20 += lisays;
                break;
            case 21:
                this.tulos21 += lisays;
                break;
            default:
                if(arvo > 21){
                    this.tulosYli += lisays;
                }
        }
    }
    
    public void lisaaBJ(double lisays){
        this.tulosBJ += lisays;
    }
    
}
