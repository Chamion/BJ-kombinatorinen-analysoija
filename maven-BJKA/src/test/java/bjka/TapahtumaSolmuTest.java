/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chamion
 */
public class TapahtumaSolmuTest {

    private TapahtumaSolmu solmu;

    public TapahtumaSolmuTest() {
    }

    @Before
    public void setUp() {
        this.solmu = new TapahtumaSolmu(3, true, 0.2, new Pakka(new int[]{96, 24, 24, 24, 24, 24, 24, 24, 24, 24}));
    }

    @Test
    public void lisaaTodennakoisyysKasvattaaTodennakoisyytta() {
        assertEquals(0.2, this.solmu.getTodennakoisyys(), 0.00000001);
        this.solmu.lisaaTodennakoisyys(0.4);
        assertEquals(0.6, this.solmu.getTodennakoisyys(), 0.00000001);
    }

    @Test
    public void laskeTodennakoisyydetAntaaTodennakoisyyksienTulon() {
        double[] oikeat = this.solmu.getPakka().todennakoisyysVektori();
        for (int i = 0; i <= 9; i++) {
            oikeat[i] = oikeat[i] * 0.2;
        }
        assertArrayEquals(oikeat, this.solmu.laskeTodennakoisyydet(), 0.00000001);
    }
    
    @Test
    public void seuraavaPakkaVastaaPakkaOlionMetodia() {
        assertEquals(this.solmu.seuraavaPakka(2), this.solmu.getPakka().poistaKortti(2));
    }
}
