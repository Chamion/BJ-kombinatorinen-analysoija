/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjkatest;

import bjka.Pakka;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chamion
 */
public class PakkaTest {

    private Pakka pakka;

    public PakkaTest() {
    }

    @Before
    public void setUp() {
        this.pakka = new Pakka(new int[]{96, 24, 24, 24, 24, 24, 24, 24, 24, 24});
    }

    @Test
    public void poistaKorttiLuoOikeanPakan() {
        Assert.assertArrayEquals(new int[]{95, 24, 24, 24, 24, 24, 24, 24, 24, 24}, this.pakka.poistaKortti(0).getLukukumaarat());
        Assert.assertArrayEquals(new int[]{96, 23, 24, 24, 24, 24, 24, 24, 24, 24}, this.pakka.poistaKortti(1).getLukukumaarat());
        Assert.assertArrayEquals(new int[]{96, 24, 23, 24, 24, 24, 24, 24, 24, 24}, this.pakka.poistaKortti(2).getLukukumaarat());
        Assert.assertArrayEquals(new int[]{96, 24, 24, 23, 24, 24, 24, 24, 24, 24}, this.pakka.poistaKortti(3).getLukukumaarat());
        Assert.assertArrayEquals(new int[]{96, 24, 24, 24, 23, 24, 24, 24, 24, 24}, this.pakka.poistaKortti(4).getLukukumaarat());
        Assert.assertArrayEquals(new int[]{96, 24, 24, 24, 24, 23, 24, 24, 24, 24}, this.pakka.poistaKortti(5).getLukukumaarat());
        Assert.assertArrayEquals(new int[]{96, 24, 24, 24, 24, 24, 23, 24, 24, 24}, this.pakka.poistaKortti(6).getLukukumaarat());
        Assert.assertArrayEquals(new int[]{96, 24, 24, 24, 24, 24, 24, 23, 24, 24}, this.pakka.poistaKortti(7).getLukukumaarat());
        Assert.assertArrayEquals(new int[]{96, 24, 24, 24, 24, 24, 24, 24, 23, 24}, this.pakka.poistaKortti(8).getLukukumaarat());
        Assert.assertArrayEquals(new int[]{96, 24, 24, 24, 24, 24, 24, 24, 24, 23}, this.pakka.poistaKortti(9).getLukukumaarat());
    }

    @Test
    public void poistaKorttiPienentaaKokoa() {
        assertEquals(311, this.pakka.poistaKortti(0).getKoko());
    }

    @Test
    public void todennakoisyysVektoriAntaaOikeatTodennakoisyydet() {
        double[] oikeat = new double[]{
            (double) 96 / 312,
            (double) 24 / 312,
            (double) 24 / 312,
            (double) 24 / 312,
            (double) 24 / 312,
            (double) 24 / 312,
            (double) 24 / 312,
            (double) 24 / 312,
            (double) 24 / 312,
            (double) 24 / 312
        };
        Assert.assertArrayEquals(oikeat, this.pakka.todennakoisyysVektori(), 0.0000001);
    }
}
