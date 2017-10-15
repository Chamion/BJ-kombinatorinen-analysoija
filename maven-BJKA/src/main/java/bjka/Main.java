package bjka;

import kello.Kello;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Chamion
 */
public class Main {

    /**
     * Main metodi. Ks. dokumentaation käyttöohje.
     *
     * @param args komentorivillä annettu syöte.
     */
    public static void main(String[] args) {
        //Oletusarvo.
        String syotePath = "syöte.txt";

        //Jos käyttäjä antoi syötteen.
        if (args.length > 0) {
            //Erikoistapaus "suorituskyky" suorittaa suorituskykytestin.
            if (args[0].equals("suorituskyky")) {
                Pakka alkuPakka = new Pakka(new int[]{96, 24, 24, 24, 24, 24, 24, 24, 24, 24});
                Pakka[] pakat = new Pakka[10];
                for (int i = 0; i < 10; i++) {
                    pakat[i] = alkuPakka.poistaKortti(i + 1);
                }
                int[] alkuKortit = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                Suorituskykytesti.suorituskykytesti(alkuKortit, pakat, new Kello());
                return;
            }

            //Oletusarvo korvataan syötteellä.
            syotePath = args[0];
        }

        File syote = new File(syotePath);
        Scanner lukija;
        try {
            lukija = new Scanner(syote);
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löytynyt: " + syotePath);
            return;
        }

        //Ensimmäinen rivi syötetiedostossa.
        int alkukortti;
        try {
            String rivi = lukija.nextLine();
            alkukortti = Integer.parseInt(rivi);
        } catch (NoSuchElementException e) {
            System.out.println("Ensimmäistä riviä ei löytynyt.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Ensimmäinen rivi ei ole kokonaisluku.");
            return;
        }
        if (alkukortti <= 0 || alkukortti > 10) {
            System.out.println("Ensimmäinen rivi ei esitä sopivaa alkukorttia.");
            return;
        }

        //Toinen rivi syötetiedostossa.
        int[] lukumaarat = new int[10];
        try {
            String rivi = lukija.nextLine();
            //Poistetaan kaikki merkit, jotka eivät ole ',' tai lukuja.
            rivi = rivi.replaceAll("[^\\d,]", "");
            String[] sanat = rivi.split(",");
            for (int i = 0; i < 10; i++) {
                lukumaarat[i] = Integer.parseInt(sanat[i]);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Toista riviä ei löytynyt.");
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Toisessa rivissä on liian vähän argumentteja.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Toisen rivin argumentti ei sisältänyt lukua.");
            return;
        }

        lukija.close();
        Pakka pakka = new Pakka(lukumaarat);
        Analysoija analysoija = new Analysoija();
        //Lasketaan todennäköisyydet.
        double[] tulos = analysoija.analysoi(alkukortti, pakka);

        //Printout.
        System.out.println("Jakajan käden todennäköisyydet");
        System.out.println("Alkukortti: " + alkukortti);
        System.out.println("Pakka: {"
                + "10: " + lukumaarat[0]
                + ", 1: " + lukumaarat[1]
                + ", 2: " + lukumaarat[2]
                + ", 3: " + lukumaarat[3]
                + ", 4: " + lukumaarat[4]
                + ", 5: " + lukumaarat[5]
                + ", 6: " + lukumaarat[6]
                + ", 7: " + lukumaarat[7]
                + ", 8: " + lukumaarat[8]
                + ", 9: " + lukumaarat[9] + "}"
        );
        System.out.println("BJ: " + tulos[6]);
        System.out.println("21: " + tulos[4]);
        System.out.println("20: " + tulos[3]);
        System.out.println("19: " + tulos[2]);
        System.out.println("18: " + tulos[1]);
        System.out.println("17: " + tulos[0]);
        System.out.println("Yli: " + tulos[5]);
    }
}
