package it.blackhat.symposium.models;


/**
 * Interface for represent Stats resource
 *
 * @author SDelPiano
 */
public interface Stats {

    /**
     * Retrieve the id of the stats
     *
     * @return the id
     */
    int getId();

    /**
     * Retrieve the year of the stats
     *
     * @return the year
     */
    int getYear();


    /**
     * Retrieve the number of the signed
     *
     * @return numSigned
     */
    int getNumSigned();
    /**
     * Retrieve the total number of the reports
     *
     * @return totalReports
     */
    int getTotalReports();



   
}
