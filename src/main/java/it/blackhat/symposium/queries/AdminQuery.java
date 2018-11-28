package it.blackhat.symposium.queries;

/**
 *
 * @author Diego Avella
 */
public final class AdminQuery {
  
  /**
   * Crea un oggetto admin query.
   * Il costruttore è privato per non permettere di instanziare l'oggetto
   */
  private AdminQuery(){}
  
  public static final String FIND_ADMIN = "SELECT * FROM Admin WHERE username=? AND password=?";
  public static final String INSERT_ADMIN = "INSERT INTO Admin (username, password) VALUES (?, ?)";
  public static final String UPDATE_ADMIN = "UPDATE Admin SET password=? WHERE username=?";
  public static final String DELETE_ADMIN = "DELETE FROM Admin WHERE username=?";
  public static final String ALL_ADMINS = "SELECT * FROM Admin";
  
}
