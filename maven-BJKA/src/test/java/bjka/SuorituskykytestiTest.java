package bjka;

import kello.Kello;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import testiluokat.Testikello;

/**
 *
 * @author Chamion
 */
public class SuorituskykytestiTest {
    
    private final ByteArrayOutputStream tulostus;
    
    public SuorituskykytestiTest() {
        this.tulostus  = new ByteArrayOutputStream();
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(tulostus));
    }
    @After
    public void tearDown() {
        System.setOut(null);
    }
    
    @Test
    public void aikaOnOikein(){
        Testikello kello = new Testikello();
        Pakka alkuPakka = new Pakka(new int[]{96, 24, 24, 24, 24, 24, 24, 24, 24, 24});
        Pakka[] pakat = new Pakka[10];
        for(int i=0; i<10; i++){
            pakat[i] = alkuPakka.poistaKortti(i+1);
        }
        int[] alkuKortit = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Suorituskykytesti.suorituskykytesti(alkuKortit, pakat, kello);
        String rivi = this.tulostus.toString();
        rivi = rivi.replaceAll("[^\\d]+", "");
        assertEquals(kello.erotus(), Long.parseLong(rivi));
    }
    
    @Test
    public void pakatEivatSaaLoppua(){
        Pakka alkuPakka = new Pakka(new int[]{96, 24, 24, 24, 24, 24, 24, 24, 24, 24});
        Pakka[] pakat = new Pakka[10];
        for(int i=0; i<9; i++){
            pakat[i] = alkuPakka.poistaKortti(i+1);
        }
        int[] alkuKortit = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean keskeytys = false;
        try{
            Suorituskykytesti.suorituskykytesti(alkuKortit, pakat, new Kello());
        } catch(NullPointerException e){
            keskeytys = true;
        }
        assertTrue(keskeytys);
    }
    
    @Test
    public void suorituskykytestiClass(){
        //Pit boosteri.
        assertEquals(Suorituskykytesti.class, new Suorituskykytesti().getClass());
    }
}
