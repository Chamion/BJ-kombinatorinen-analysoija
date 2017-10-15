package bjka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chamion
 */
public class AnalysoijaTest {
    
    private final Analysoija analysoija;
    
    public AnalysoijaTest() {
        this.analysoija = new Analysoija();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void analysoiOnSamaaMieltaWizardinKanssa() {
        // https://wizardofodds.com/games/blackjack/appendix/2b/
        // Testin toimivuus riippuu wizardofodds.com:in tarkkuudesta.
        // Testi ei huomannut bugia, joka aiheutti niin pienen virheen, että viimeinen merkitsevä numero ei muuttunut. Bugi on korjattu.
        double[][] wizardArvot = new double[][]{
            new double[]{0.111914, 0.111669, 0.111945, 0.340014, 0.0348174, 0.0771704, 0.212471},
            new double[]{0.130017, 0.130822, 0.130594, 0.13091, 0.0535035, 0.308682, 0.115473},
            new double[]{0.139656, 0.134389, 0.13002, 0.124019, 0.118413, 0, 0.353504},
            new double[]{0.134296, 0.130539, 0.125226, 0.120817, 0.114928, 0, 0.374194},
            new double[]{0.130556, 0.124062, 0.121272, 0.116441, 0.111866, 0, 0.395805},
            new double[]{0.121843, 0.122437, 0.117575, 0.111793, 0.107945, 0, 0.418406},
            new double[]{0.165707, 0.106194, 0.106431, 0.101551, 0.0972756, 0, 0.422842},
            new double[]{0.369208, 0.137931, 0.078428, 0.0786816, 0.0738158, 0, 0.261936},
            new double[]{0.12894, 0.359955, 0.128723, 0.0692189, 0.0694701, 0, 0.243693},
            new double[]{0.12031, 0.117348, 0.351854, 0.120368, 0.0608772, 0, 0.229242}
        };
        for(double[] rivi : wizardArvot){
            double temp = rivi[6];
            rivi[6] = rivi[5];
            rivi[5] = temp;
        }
        double[][] omatArvot = new double[10][];
        Pakka alkuPakka = new Pakka(new int[]{96, 24, 24, 24, 24, 24, 24, 24, 24, 24});
        omatArvot[0] = analysoija.analysoi(10, alkuPakka.poistaKortti(0));
        for(int i=1; i<=9; i++){
            omatArvot[i] = analysoija.analysoi(i, alkuPakka.poistaKortti(i));
        }
        for(int i=0; i<=9; i++){
            assertArrayEquals(wizardArvot[i], omatArvot[i], 0.0000005);
        }
    }
    
}
