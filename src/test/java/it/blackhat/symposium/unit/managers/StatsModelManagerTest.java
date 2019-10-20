package it.blackhat.symposium.unit.managers;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import it.blackhat.symposium.managers.StatsModelManager;

/**
 * The class test StatsModelManager
 *
 * @author Parrilli Carminantonio
 *
 */
public class StatsModelManagerTest {

  /**
   * The test for the empty constructor
   *
   * @throws SQLException in case of error in the database
   */
  @Test
  public void testStatsModelManager() throws SQLException {
    DataSource ds = Mockito.mock(BasicDataSource.class);
    StatsModelManager testConstuctor = new StatsModelManager(ds);
    Assert.assertTrue(testConstuctor instanceof StatsModelManager);
  }
}
