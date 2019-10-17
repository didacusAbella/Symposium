package it.blackhat.symposium.queries;

/**
 * This class contains all queries for user table
 *
 * @author Symposium Group
 */
public enum UserQuery {

  FIND_EMAIL("SELECT * FROM user WHERE email=?"),
  
  SIGN_UP("INSERT INTO user (username, firstName, lastName, email, password, typeGrad,year) "
          + "VALUES( ? , ? , ? , ? , ? , ?, ?)"),
  
  SIGN_IN("SELECT * FROM user WHERE email=? AND password=?"),
  
  EDIT_PROFILE("UPDATE user SET username=?, firstName=?, lastName=?, password=?, typeGrad=? "
          + "WHERE email=?"),
  
  DELETE_ACCOUNT("DELETE FROM user WHERE email=?"),
  
  TAKE_ALL_USERS("SELECT * FROM user"),
  
  BAN("UPDATE user SET banLastDate=? where email=?");
  
  
  private final String query;
  
  /**
   * 
   * @param query the SQL query
   */
  private UserQuery(String query) {
    this.query = query;
  }

  @Override
  public String toString() {
    return this.query;
  }
  
}
