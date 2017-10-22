package testiluokat;

import kello.KelloRajapinta;

/**
 *
 * @author Chamion
 */
public class Testikello implements KelloRajapinta{
    
    private long edellinen = -1;
    private long sitaEdellinen = -1;
    
    @Override
    public long nanoTime() {
        sitaEdellinen = edellinen;
        edellinen = System.nanoTime();
        return edellinen;
    }
    
    public long erotus(){
        return edellinen - sitaEdellinen;
    }
}
