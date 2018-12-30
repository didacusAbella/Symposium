/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.blackhat.symposium.models;

/**
 * Interface for represent Stats resource
 *
 * @author Przemyslaw Szopian
 */
public interface Stats {

    /**
     * Retrieve the id of the stats
     *
     * @return id
     */
    int getId();

    /**
     * Retrieve the signed number of the stats
     *
     * @return signed number
     */
    int getNumSigned();

    /**
     * Retrieve the total reports of the stats
     *
     * @return total reports
     */
    int getTotalReports();

    /**
     * Retrieve the year of the stats
     *
     * @return year
     */
    int getYear();

    /**
     * Change the id of the stats
     *
     * @param id new id of the stats
     */
    void setId(int id);

    /**
     * Change the signed number of the stats
     *
     * @param numSigned new signed number of the stats
     */
    void setNumSigned(int numSigned);

    /**
     * Change the total reports of the stats
     *
     * @param totalReports new total reports of the stats
     */
    void setTotalReports(int totalReports);

    /**
     * Change the year of the stats
     *
     * @param year new year of the stats
     */
    void setYear(int year);
}
