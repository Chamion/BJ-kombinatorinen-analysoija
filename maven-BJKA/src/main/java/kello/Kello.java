package kello;

/**
 *
 * @author Chamion
 */
public class Kello implements KelloRajapinta {

    /**
     * Kutsuu System.nanoTime-metodia.
     *
     * @return System.nanoTime-metodin palautus.
     */
    @Override
    public long nanoTime() {
        return System.nanoTime();
    }
}
