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
    String getId();
    

    /**
     * Retrieve the category of the report
     *
     * @return the category
     */
    String getCategory();

    /**
     * Retrieve the reason of the report
     *
     * @return the reason
     */
    String getReason();

    /**
     * Retrieve the user's email author of the report
     *
     * @return user
     */
    String getUser();

  

   



   
}
