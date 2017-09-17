package bjka;

/**
 * Tulosvektoriin kirjataan päättyneiden tapahtumaketjujen arvot ja
 * todennäköisyydet. Algoritmin päätyttyä tulosvektorin lukujen summan tulisi
 * olla 1.
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

    public TulosVektori() {
        this.tulos17 = 0;
        this.tulos18 = 0;
        this.tulos19 = 0;
        this.tulos20 = 0;
        this.tulos21 = 0;
        this.tulosBJ = 0;
        this.tulosYli = 0;
    }

    public double get(int arvo) {
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
                if (arvo > 21) {
                    return this.tulosYli;
                }
                return 0.0;
        }
    }

    public double getBJ() {
        return this.tulosBJ;
    }

    public double getYli() {
        return this.tulosYli;
    }

    public void lisaa(int arvo, double lisays) {
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
                if (arvo > 21) {
                    this.tulosYli += lisays;
                }
        }
    }

    public void lisaaBJ(double lisays) {
        this.tulosBJ += lisays;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() == this.getClass()) {
            return this.equals((TulosVektori) o);
        }
        return false;
    }

    private boolean equals(TulosVektori toinen) {
        double delta = 0.0001;
        if (Math.abs(this.get(17) / toinen.get(17) - 1) > delta) {
            return false;
        }
        if (Math.abs(this.get(18) / toinen.get(18) - 1) > delta) {
            return false;
        }
        if (Math.abs(this.get(19) / toinen.get(19) - 1) > delta) {
            return false;
        }
        if (Math.abs(this.get(20) / toinen.get(20) - 1) > delta) {
            return false;
        }
        if (Math.abs(this.get(21) / toinen.get(21) - 1) > delta) {
            return false;
        }
        if (Math.abs(this.getBJ() / toinen.getBJ() - 1) > delta) {
            return false;
        }
        if (Math.abs(this.getYli() / toinen.getYli() - 1) > delta) {
            return false;
        }
        return true;
    }

}
