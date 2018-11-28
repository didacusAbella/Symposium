package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Admin;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diego Avella
 */
public interface AdminManager {
  
  Optional<Admin> findAdmin(String username, String password) throws SQLException;
  
  Optional<Admin> createAdmin(Admin admin) throws SQLException;
  
  int updateAdmin(Admin admin) throws SQLException;
  
  int deleteAdmin(Admin admin) throws SQLException;
  
  List<Admin> findAllAdmins() throws SQLException;
  
}
