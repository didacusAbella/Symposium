package it.blackhat.symposium.queries;

/**
 * 
 * @author Parrilli Carminantonio
 *
 */
public class StatsQuery {
    /**
     * Create an stats query object. The constructor is private to not allow the
     * object to be instantiated.
     */
    private StatsQuery() {
    }

    public static final String INCREASE_COUNT = "UPDATE stats SET numsigned = " 
         + "numsigned + 1 WHERE year= ?";
    

}
