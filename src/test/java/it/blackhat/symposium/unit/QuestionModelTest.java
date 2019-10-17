package it.blackhat.symposium.unit;

import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.QuestionModel;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class QuestionModelTest {

  Date testDate = new Date(Calendar.getInstance().getTime().getTime());
  private Question question;

  @Before
  public void setUp() {
    String title = "Posso superare IS";
    String content = "Posso superare IS io ci credo";
    String userFk = "a.raiola14@studenti.unisa.it";
    int questionId = 10;
    int numReports = 0;
    question = new QuestionModel(title, content, userFk, testDate, testDate, questionId, numReports);
  }

  @Test
  public void testGetTitle() {
    String test = "Posso superare IS";
    assertEquals(test, question.getTitle());
  }

  @Test
  public void testSetTitle() {
    String test = "Apelle figlio di apollo";
    question.setTitle(test);
    assertEquals(test, question.getTitle());
  }

  @Test
  public void testGetContent() {
    String test = "Posso superare IS io ci credo";
    assertEquals(test, question.getContent());
  }

  @Test
  public void testSetContent() {
    String test = "non supero mai mai mai IS";
    question.setContent(test);
    assertEquals(test, question.getContent());
  }

  @Test
  public void testGetUserFk() {
    assertEquals("a.raiola14@studenti.unisa.it", question.getUserFk());
  }

  @Test
  public void testSetUserFk() {
    String test = "memo.szopian@studenti.unisa.it";
    question.setUserFk(test);
    assertEquals(test, question.getUserFk());
  }

  @Test
  public void testGetCreationDate() {
    assertEquals(testDate, question.getCreationDate());
  }

  @Test
  public void testSetCreationDate() {
    Date test = new Date(Calendar.getInstance().getTime().getTime());
    question.setCreationDate(test);
    assertEquals(test, question.getCreationDate());
  }

  @Test
  public void testGetLastUpdate() {
    assertEquals(testDate, question.getLastUpdate());
  }

  @Test
  public void testSetLastUpdate() {
    Calendar today = Calendar.getInstance();
    today.set(2018, 12, 31);
    Date test = new Date(today.getTime().getTime());
    question.setLastUpdate(test);
    assertEquals(test, question.getLastUpdate());
  }

  @Test
  public void testGetId() {
    int test = 10;
    assertEquals(test, question.getId());
  }

  @Test
  public void testSetId() {
    int test = 11;
    question.setId(test);
    assertEquals(test, question.getId());

  }

  @Test
  public void testGetNumReports() {
    assertEquals(0, question.getNumReports());
  }

  @Test
  public void testSetNumReports() {
    int test = 1;
    question.setNumReports(1);
    assertEquals(test, question.getNumReports());
  }

  @Test
  public void testToString() {
    String test = "QuestionModel{"
            + "title='" + "Posso superare IS" + '\''
            + ", content='" + "Posso superare IS io ci credo" + '\''
            + ", userFk='" + "a.raiola14@studenti.unisa.it" + '\''
            + ", creationDate=" + testDate
            + ", lastUpdate=" + testDate
            + ", id=" + 10
            + ", numReports=" + 0
            + '}';
    assertEquals(test, question.toString());
  }
}
