package it.blackhat.symposium.unit.managers;

import it.blackhat.symposium.managers.AdminModelManager;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author Przemyslaw Szopian
 */
public class AdminModelManagerTest {

  /**
   * Test of findAdmin method, of class AdminModelManager.
   */
  @Test
  public void constractorEmpty() {
    DataSource ds = Mockito.mock(BasicDataSource.class);
    AdminModelManager admin = new AdminModelManager(ds);
    assertTrue(admin instanceof AdminModelManager);
  }

}
