/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

/**
 *
 * @author Chamion
 */
public class Jono {
    
    private int paa;
    private int hanta;
    private final int maxKoko;
    private final int[] taulukko;
    
    public Jono(int maxKoko){
        this.paa = 0;
        this.hanta = 0;
        this.maxKoko = maxKoko;
        this.taulukko = new int[maxKoko];
    }
    
    public void lisaa(int arvo){
        this.taulukko[this.hanta] = arvo;
        this.hanta = (this.hanta + 1) % this.maxKoko;
    }
    
    public int get(){
        // bugi: get tyhjälle jonolla sotkee tulevan käytön.
        int palautettava = this.taulukko[this.paa];
        this.paa = (this.paa + 1) % this.maxKoko;
        return palautettava;
    }
    
    public boolean isEmpty(){
        // bugi: palauttaa true, kun jono on täysi. Korjaaminen haittaisi suorituskykyä.
        return this.hanta == this.paa;
    }
    
}
