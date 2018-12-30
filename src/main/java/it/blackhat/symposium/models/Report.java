package it.blackhat.symposium.models;


/**
 * Interface for represent Report resource
 *
 * @author Salvatore DelPiano
 */
public interface Report {

    /**
     * Retrieve the id of the report
     *
     * @return the id
     */
    int getId();
    

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
     * Retrieve the user author of the report
     *
     * @return user
     */
    String getUser();

    /**
     * Change the id of the report
     * 
     * @param id new id of the reason
     */
    void setId(int id);
    
    /**
     * Change the category of the report
     * 
     * @param category new category of the report
     */
    void setCategory(String category);
    
    /**
     * Change the reason of the report
     * 
     * @param reason new reason of the report
     */
    void setReason(String reason);
    
    /**
     * Change the user of the report
     * 
     * @param user new user of the report
     */
    void setUser(String user);  
}
