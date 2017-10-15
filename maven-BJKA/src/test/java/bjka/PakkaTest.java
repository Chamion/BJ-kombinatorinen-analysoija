package bjka;

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
    public void poistaKorttiVoiOttaaViimeisenKortin() {
        Pakka yksiKortti = new Pakka(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertFalse(yksiKortti.equals(yksiKortti.poistaKortti(10)));
        yksiKortti = yksiKortti.poistaKortti(10);
        assertEquals(new Pakka(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}), yksiKortti);
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
    
    @Test
    public void todennakoisyysVektoriSietaaNollia() {
        Pakka nollaPakka = new Pakka(new int[]{4, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Assert.assertArrayEquals(new double[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, nollaPakka.todennakoisyysVektori(), 0.0000001);
        nollaPakka = new Pakka(new int[]{0, 1, 0, 0, 0, 0, 0, 2, 0, 0});
        Assert.assertArrayEquals(new double[]{0, (double) 1/3, 0, 0, 0, 0, 0, (double) 2/3, 0, 0}, nollaPakka.todennakoisyysVektori(), 0.0000001);
        
        // 0 kortin pakalla ei testata. Tyhjästä pakasta nostaminen on järjetön tilanne, joten ei voida olettaa järjellistä vastausta.
        
    }
    
    @Test
    public void pitKattavuusBoosteri() {
        assertFalse(this.pakka.equals(this));
        for(int i=0; i<=9; i++){
            assertFalse(this.pakka.equals(this.pakka.poistaKortti(i)));
        }
    }
}
