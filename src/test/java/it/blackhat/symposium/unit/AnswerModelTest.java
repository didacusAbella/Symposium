package it.blackhat.symposium.unit;

import it.blackhat.symposium.models.AnswerModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.Calendar;

/**
 * The class tests StatsModelTest
 *
 * @author Gozzetto
 *
 */
public class AnswerModelTest {

  private final Calendar dataProva = Calendar.getInstance();
  private Date date;

  @Before
  public void setUp() {
    this.dataProva.set(2018, 11, 6);
    this.date = new Date(this.dataProva.getTime().getTime());
  }

  /**
   * The test for the empty constructor
   */
  @Test
  public void testAnswerModelEmpty() {
    AnswerModel testAnswerModel = new AnswerModel();
    Assert.assertTrue(testAnswerModel instanceof AnswerModel);
  }

  /**
   * The test for the full constructor
   */
  @Test
  public void testAnswerModelFull() {
    AnswerModel testAnswerModel = new AnswerModel(12, 23, "c.cicciolina@studenti.unisa.it", "Non si passa", date, true);
    boolean b1 = (12 == testAnswerModel.getId());
    boolean b2 = (23 == testAnswerModel.getQuestionFk());
    boolean b3 = ("c.cicciolina@studenti.unisa.it".equals(testAnswerModel.getUserFk()));
    boolean b4 = ("Non si passa".equals(testAnswerModel.getContent()));
    boolean b5 = (date.equals(testAnswerModel.getCreationDate()));
    boolean b6 = (true == testAnswerModel.isCorrect());
    boolean bTot = b1 && b2 && b3 && b4 && b5 && b6;
    Assert.assertTrue(bTot);
  }

  /**
   * The test for GetId
   */
  @Test
  public void testGetId() {
    AnswerModel testAnswer = new AnswerModel();
    testAnswer.setId(17);
    Assert.assertEquals(17, testAnswer.getId());
  }

  /**
   * the test for GetQuestionFk
   */
  @Test
  public void testGetQuestionFk() {
    AnswerModel testAnswer = new AnswerModel();
    testAnswer.setQuestionFk(13);
    Assert.assertEquals(13, testAnswer.getQuestionFk());
  }

  /**
   * the test for GetUserFk
   */
  @Test
  public void testGetUserFk() {
    AnswerModel testAnswer = new AnswerModel();
    testAnswer.setUserFk("c.cicciolina@studenti.unisa.it");
    Assert.assertEquals("c.cicciolina@studenti.unisa.it", testAnswer.getUserFk());
  }

  /**
   * the test for GetContent
   */
  @Test
  public void testGetContent() {
    AnswerModel testAnswer = new AnswerModel();
    testAnswer.setContent("Non si passa");
    Assert.assertEquals("Non si passa", testAnswer.getContent());
  }

  /**
   * the test for GetCreationDate aaaa
   */
  @Test
  public void testGetCreationDate() {
    AnswerModel testAnswer = new AnswerModel();
    testAnswer.setCreationDate(date);
    Assert.assertEquals(date, testAnswer.getCreationDate());
  }

  /**
   * the test for IsCorrect
   */
  @Test
  public void testIsCorrect() {
    AnswerModel testAnswer = new AnswerModel();
    testAnswer.setCorrect(true);
    Assert.assertEquals(true, testAnswer.isCorrect());
  }

  /**
   * the test for ToString
   */
  @Test
  public void testToString() {
    AnswerModel testAnswer = new AnswerModel(12, 23, "c.cicciolina@studenti.unisa.it", "Non si passa", date, true);
    String test = "AnswerModel{"
            + "id=" + 12
            + ", questionFk=" + 23
            + ", userFk=" + "c.cicciolina@studenti.unisa.it"
            + ", content=" + "Non si passa"
            + ", creationDate=" + "2018-12-06"
            + ", correct=" + true
            + '}';
    Assert.assertEquals(test, testAnswer.toString());
  }
}
