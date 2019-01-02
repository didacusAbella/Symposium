/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.blackhat.symposium.models;

/**
 * @author Przemyslaw Szopian
 */
public class StatsModel implements Stats {

    private int id, numSigned, totalReports, year;

    /**
     * Create an empty StatsModel
     */
    public StatsModel() {
        super();
    }

    /**
     * Create a new Stats with id, numSigned, totalReports and year
     *
     * @param id            the stat's id
     * @param numSigned     the stat's numSigned
     * @param totalReports  the stat's total reports
     * @param year          the stat's year
     */
    public StatsModel(int id, int numSigned, int totalReports, int year) {
        this.id = id;
        this.numSigned = numSigned;
        this.totalReports = totalReports;
        this.year = year;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getNumSigned() {
        return numSigned;
    }

    @Override
    public void setNumSigned(int numSigned) {
        this.numSigned = numSigned;
    }

    @Override
    public int getTotalReports() {
        return totalReports;
    }

    @Override
    public void setTotalReports(int totalReports) {
        this.totalReports = totalReports;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }
}
