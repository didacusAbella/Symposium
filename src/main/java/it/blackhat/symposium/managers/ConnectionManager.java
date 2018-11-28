
package it.blackhat.symposium.managers;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @author didacus
 */
public abstract class ConnectionManager {
  
  @Resource(name = "jdbc/SymposiumDB")
  protected DataSource dataSource;
  
  public ConnectionManager(){
    super();
  }
}
