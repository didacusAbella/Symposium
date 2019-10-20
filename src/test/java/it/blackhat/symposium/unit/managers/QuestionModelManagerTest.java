package it.blackhat.symposium.unit.managers;

import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.mockito.Mockito;

import javax.sql.DataSource;

import static org.junit.Assert.assertTrue;

public class QuestionModelManagerTest {

  @Test
  public void testQuestionModelManager() {
    DataSource ds = Mockito.mock(BasicDataSource.class);
    QuestionManager test = new QuestionModelManager(ds);
    assertTrue(test instanceof QuestionModelManager);
  }
}
