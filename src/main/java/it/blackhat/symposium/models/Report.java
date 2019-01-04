package it.blackhat.symposium.models;


/**
 * Interface for represent Report resource
 *
 * @author SDelPiano
 */
public interface Report {

    /**
     * Retrieve the id of the report
     *
     * @return the id
     */
    int getId();

    /**
     * Change the id of the report
     *
     * @param id new id of the reason
     */
    void setId(int id);

    /**
     * Retrieve the category of the report
     *
     * @return the category
     */
    String getCategory();

    /**
     * Change the category of the report
     *
     * @param category new category of the report
     */
    void setCategory(String category);

    /**
     * Retrieve the reason of the report
     *
     * @return the reason
     */
    String getReason();

    /**
     * Change the reason of the report
     *
     * @param reason new reason of the report
     */
    void setReason(String reason);

    /**
     * Retrieve the user author of the report
     *
     * @return user
     */
    String getUserFk();

    /**
     * Change the user of the report
     *
     * @param userFk new user of the report
     */
    void setUserFk(String userFk);

    /**
     * Retrieve the year of the report
     *
     * @return year
     */
    int getYear();

    /**
     * Change the year of the report
     *
     * @param year new year of the report
     */
    void setYear(int year);
}