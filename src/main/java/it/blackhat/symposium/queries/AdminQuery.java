package it.blackhat.symposium.queries;

/**
 * Admin Queries
 */
public enum AdminQuery {

  SIGN_IN("SELECT * FROM admin WHERE username=? AND password=?");
  
  private final String query;
  
  /**
   * 
   * @param query thhe SQL query 
   */
  private AdminQuery(String query) {
    this.query = query;
  }

  @Override
  public String toString() {
    return this.query;
  }
}
