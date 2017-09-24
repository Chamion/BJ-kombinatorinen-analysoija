/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tietorakenteet;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chamion
 */
public class JonoTest {

    private Jono jono;

    public JonoTest() {
    }

    @Before
    public void setUp() {
        this.jono = new Jono(100);
    }

    @Test
    public void jonoPoistaaPaanPalautuksenYhteydessa() {
        this.jono.lisaa(1);
        assertNotEquals(this.jono.get(), this.jono.get());
    }

    @Test
    public void jonoAntaaArvotFIFOJarjestyksessa() {
        this.jono.lisaa(12);
        this.jono.lisaa(-11);
        this.jono.lisaa(2);
        assertEquals(12, this.jono.get());
        assertEquals(-11, this.jono.get());
        assertEquals(2, this.jono.get());
    }

    @Test
    public void taysiJonoYlikirjoittaaVanhan() {
        //Ts. testataan, ettei jono varaa ylimääräistä tilaa.
        Jono pieniJono = new Jono(2);
        pieniJono.lisaa(0);
        pieniJono.lisaa(1);
        pieniJono.lisaa(2);
        assertEquals(2, pieniJono.get());
        assertEquals(1, pieniJono.get());
    }

    @Test
    public void indeksitKierratetaan() {
        Jono pieniJono = new Jono(3);
        pieniJono.lisaa(0);
        pieniJono.lisaa(1);
        pieniJono.lisaa(2);
        pieniJono.get();
        pieniJono.get();
        pieniJono.get();

        pieniJono.lisaa(3);
        pieniJono.lisaa(4);
        assertEquals(3, pieniJono.get());
        assertEquals(4, pieniJono.get());
    }
    
    @Test
    public void isEmptyTyhjallaJonolla(){
        assertTrue(this.jono.isEmpty());
        this.jono.lisaa(3);
        this.jono.lisaa(-2);
        this.jono.get();
        this.jono.get();
        assertTrue(this.jono.isEmpty());
    }
    
    /*@Test
    public void EiIsEmptyKunAlkioita(){
        this.jono.lisaa(3);
        assertFalse(this.jono.isEmpty());
        Jono pieniJono = new Jono(2);
        pieniJono.lisaa(3);
        pieniJono.lisaa(3);
        assertFalse(pieniJono.isEmpty());
    }*/
}
