package it.blackhat.symposium.managers;

import java.sql.SQLException;
import java.util.Optional;

import it.blackhat.symposium.models.Admin;


/**
 *
 * @author Diego Avella
 */
public interface AdminManager {

	/**
	 * 
	 * @param username of the admin
	 * @param password of the admin
	 * @return Admin Object
	 * @throws SQLException in case of error
	 */
    Optional<Admin> findAdminBy(String username, String password) throws SQLException;
	
    /**
     * 
     * @param email user identificator
     * @return boolean true/false  
     * @throws SQLException in case of error
     */
    boolean banUser(String email) throws SQLException;
   
    /**
     * 
     * @param adminUsername username of the admin
     * @return a String containing the report
     * @throws SQLException in case of error
     */
    Optional<String> genReport(String adminUsername) throws SQLException;
}
