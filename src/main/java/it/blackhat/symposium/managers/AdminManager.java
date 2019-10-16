package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Admin;

import java.sql.SQLException;
import java.util.Optional;

/**
 * @author SDelPiano
 */
public interface AdminManager {

  /**
   * Find an admin given username and password
   *
   * @param username the admin's username
   * @param password tha admin's password
   * @return an instance of admin
   * @throws SQLException if db errors occurred
   */
  Optional<Admin> findAdmin(String username, String password) throws SQLException;

}
