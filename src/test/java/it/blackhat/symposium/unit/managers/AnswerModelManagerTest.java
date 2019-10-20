package it.blackhat.symposium.unit.managers;

import java.sql.SQLException;

import it.blackhat.symposium.managers.AnswerModelManager;
import org.junit.Assert;
import org.junit.Test;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.mockito.Mockito;

/**
 * The class test AnswerModelManager
 *
 * @author Gozzetto
 *
 */
public class AnswerModelManagerTest {

  /**
   * The test for the empty constructor
   *
   * @throws SQLException in case of error in the database
   */
  @Test
  public void testAnswerModelManager() throws SQLException {
    DataSource ds = Mockito.mock(BasicDataSource.class);
    AnswerModelManager testConstuctor = new AnswerModelManager(ds);
    Assert.assertTrue(testConstuctor instanceof AnswerModelManager);
  }

}
