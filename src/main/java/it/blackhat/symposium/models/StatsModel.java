package it.blackhat.symposium.models;


public class StatsModel implements Stats {

    private int year, numSigned, totalReports, id;
   

    /**
     * Concrete implementation of Stats Interface
     *
     * @author SDelPiano
     */
    public StatsModel() {
        super();
    }

    /**
     * Create a new Question with id, year, numSigned, totalReports.
     *
     * @param id id of the question
     * @param year year of the stats
     * @param numSigned number of the signed of the stats
     * @param totalReports total reports of the stats
     */
    public StatsModel(int id, int  year, int numSigned , int totalReports ) {
        this.id = id;
        this.year = year;
        this.numSigned = numSigned;
        this.totalReports = totalReports;
        
    }

    @Override
	public int getId() {
    	return id;
    }

    @Override
	public int getYear() {
    	return year;
    }

    @Override
	public int getNumSigned() {
    	return numSigned;
    }

    @Override
	public int getTotalReports() {
    	return totalReports;
    }
}
