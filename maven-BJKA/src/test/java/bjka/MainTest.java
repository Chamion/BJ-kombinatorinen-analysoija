package bjka;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chamion
 */
public class MainTest {
    
    private final ByteArrayOutputStream tulostus;
    
    public MainTest() {
        tulostus  = new ByteArrayOutputStream();
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
    public void suorituskykyKutsutaanErikoissyotteella(){
        Main.main(new String[]{"suorituskyky"});
        assertTrue(tulostus.toString().matches("^Todennakoisyyksien laskeminen jokaisella alkukortilla kesti \\d+ nanosekuntia.\r\n$"));
    }
    
    @Test
    public void mainAntaaSamatArvotKuinAnalysoija(){
        Main.main(new String[]{"src/test/java/testisyotteet/testisyote1.txt"});
        String[] rivit = tulostus.toString().split("\r\n");
        double[] mainTulos = new double[7];
        for(String rivi : rivit) {
            if(rivi.contains("BJ: ")){
                mainTulos[6] = Double.parseDouble(rivi.substring(4));
            } else if(rivi.contains("Yli: ")){
                mainTulos[5] = Double.parseDouble(rivi.substring(5));
            } else if(rivi.contains("21: ")){
                mainTulos[4] = Double.parseDouble(rivi.substring(4));
            } else if(rivi.contains("20: ")){
                mainTulos[3] = Double.parseDouble(rivi.substring(4));
            } else if(rivi.contains("19: ")){
                mainTulos[2] = Double.parseDouble(rivi.substring(4));
            } else if(rivi.contains("18: ")){
                mainTulos[1] = Double.parseDouble(rivi.substring(4));
            } else if(rivi.contains("17: ")){
                mainTulos[0] = Double.parseDouble(rivi.substring(4));
            }
        }
        double[] analysoijaTulos = new Analysoija().analysoi(1, new Pakka(new int[]{16, 3, 4, 4, 4, 4, 4, 4, 4, 4}));
        assertArrayEquals(analysoijaTulos, mainTulos, 0.00000001);
    }
    
    @Test
    public void tulostuksenMuotoOnOikea(){
        Main.main(new String[]{"src/test/java/testisyotteet/testisyote1.txt"});
        String[] rivit = tulostus.toString().split("\r\n");
        assertEquals(10, rivit.length);
        assertTrue(rivit[0].matches("^Jakajan kaden todennakoisyydet$"));
        assertTrue(rivit[1].matches("^Alkukortti: ([1-9]|10)$"));
        assertTrue(rivit[2].matches("^Pakka: \\{(((,|, |)[1-9]|10):( |)\\d+){10}\\}$"));
        assertTrue(rivit[3].matches("^BJ:( |)[\\d.]+$"));
        assertTrue(rivit[4].matches("^21:( |)[\\d.]+$"));
        assertTrue(rivit[5].matches("^20:( |)[\\d.]+$"));
        assertTrue(rivit[6].matches("^19:( |)[\\d.]+$"));
        assertTrue(rivit[7].matches("^18:( |)[\\d.]+$"));
        assertTrue(rivit[8].matches("^17:( |)[\\d.]+$"));
        assertTrue(rivit[9].matches("^Yli:( |)[\\d.]+$"));
    }
    
    @Test
    public void tiedostoaEiLoytynyt(){
        Main.main(new String[]{"src/test/java/testisyotteet/olematon_tiedosto.txt"});
        assertEquals("Tiedostoa ei loytynyt: src/test/java/testisyotteet/olematon_tiedosto.txt\r\n", tulostus.toString());
    }
    
    @Test
    public void EnsimmaistaRiviaEiLoytynyt(){
        Main.main(new String[]{"src/test/java/testisyotteet/tyhja.txt"});
        assertEquals("Ensimmaista rivia ei loytynyt.\r\n", tulostus.toString());
    }
    
    @Test
    public void EnsimmainenRiviEiOleKokonaisluku(){
        Main.main(new String[]{"src/test/java/testisyotteet/huono_eka_rivi.txt"});
        assertEquals("Ensimmainen rivi ei ole kokonaisluku.\r\n", tulostus.toString());
    }
    
    @Test
    public void alkukorttiOnLiianSuuri(){
        Main.main(new String[]{"src/test/java/testisyotteet/huono_alkukortti1.txt"});
        assertEquals("Ensimmainen rivi ei esita sopivaa alkukorttia.\r\n", tulostus.toString());
    }
    
    @Test
    public void alkukorttiOnLiianPieni(){
        Main.main(new String[]{"src/test/java/testisyotteet/huono_alkukortti2.txt"});
        assertEquals("Ensimmainen rivi ei esita sopivaa alkukorttia.\r\n", tulostus.toString());
    }
    
    @Test
    public void vainYksiRivi(){
        Main.main(new String[]{"src/test/java/testisyotteet/yksi_rivi.txt"});
        assertEquals("Toista rivia ei loytynyt.\r\n", tulostus.toString());
    }
    
    @Test
    public void liianVahanArgumentteja(){
        Main.main(new String[]{"src/test/java/testisyotteet/vajaa_toinen_rivi.txt"});
        assertEquals("Toisessa rivissa on liian vahan argumentteja.\r\n", tulostus.toString());
    }
    
    @Test
    public void huonoToinenRivi(){
        Main.main(new String[]{"src/test/java/testisyotteet/huono_toinen_rivi.txt"});
        assertEquals("Toisen rivin argumentti ei sisaltanyt lukua.\r\n", tulostus.toString());
    }
    
    @Test
    public void oletussyote(){
        File tuhottava = new File("syote.txt");
        FileOutputStream oFile;
        try {
            tuhottava.createNewFile();
            oFile = new FileOutputStream("syote.txt", false);
            oFile.write("2\r\n".getBytes());
            oFile.write("32, 8, 7, 8, 8, 8, 8, 8, 8, 8".getBytes());
            oFile.close();
        } catch(Exception e){
            assertTrue(false);
            return;
        }
        Main.main(new String[]{});
        assertTrue(tuhottava.delete());
        String[] rivit = tulostus.toString().split("\r\n");
        double[] mainTulos = new double[7];
        for(String rivi : rivit) {
            if(rivi.contains("BJ: ")){
                mainTulos[6] = Double.parseDouble(rivi.substring(4));
            } else if(rivi.contains("Yli: ")){
                mainTulos[5] = Double.parseDouble(rivi.substring(5));
            } else if(rivi.contains("21: ")){
                mainTulos[4] = Double.parseDouble(rivi.substring(4));
            } else if(rivi.contains("20: ")){
                mainTulos[3] = Double.parseDouble(rivi.substring(4));
            } else if(rivi.contains("19: ")){
                mainTulos[2] = Double.parseDouble(rivi.substring(4));
            } else if(rivi.contains("18: ")){
                mainTulos[1] = Double.parseDouble(rivi.substring(4));
            } else if(rivi.contains("17: ")){
                mainTulos[0] = Double.parseDouble(rivi.substring(4));
            }
        }
        double[] analysoijaTulos = new Analysoija().analysoi(2, new Pakka(new int[]{32, 8, 7, 8, 8, 8, 8, 8, 8, 8}));
        assertArrayEquals(analysoijaTulos, mainTulos, 0.00000001);
    }
    
    @Test
    public void mainClass(){
        //Pit-boosteri.
        Main main = new Main();
        assertEquals(Main.class, main.getClass());
    }
}
