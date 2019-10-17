package it.blackhat.symposium.unit;

import it.blackhat.symposium.models.Report;
import it.blackhat.symposium.models.ReportModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Rayman
 */
public class ReportModelTest {

  @Test
  public void costructorTest() {
    Report report1 = new ReportModel();
    Assert.assertTrue(report1 instanceof ReportModel);
  }

  @Test
  public void costructFull() {
    Report report2 = new ReportModel(7, "spam", "gay", 2019,
            "G.MADONNA3@studenti.unisa.it", 21);
    Assert.assertTrue(report2 instanceof ReportModel);

  }

  /**
   * test of getId method of class ReportModel
   */
  @Test
  public void getIdTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    Assert.assertEquals("It should return 7", 7, report.getId());
  }

  /**
   * test of setId method of class ReportModel
   */
  @Test
  public void setIdTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    report.setId(1);
    Assert.assertEquals("It should return 1", 1, report.getId());
  }

  /**
   * test of getCategory method of class ReportModel
   */
  @Test
  public void getCategoryTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    Assert.assertEquals("It should return andrea", "andrea", report.getCategory());
  }

  /**
   * test of setCategory method of class ReportModel
   */
  @Test
  public void setCategoryTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    report.setCategory("spam");
    Assert.assertEquals("It should return spam", "spam", report.getCategory());
  }

  /**
   * test of getReason method of class ReportModel
   */
  @Test
  public void getReasonTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    Assert.assertEquals("It should return raiola", "raiola", report.getReason());
  }

  /**
   * test of setReason method of class ReportModel
   */
  @Test
  public void setReasonTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    report.setCategory("insulti");
    Assert.assertEquals("It should return insulti", "insulti", report.getCategory());
  }

  /**
   * test of getUserFk method of class ReportModel
   */
  @Test
  public void getUserFkTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    Assert.assertEquals("It should return G.MADONNA3@studenti.unisa.it",
            "G.MADONNA3@studenti.unisa.it", report.getUserFk());
  }

  /**
   * test of setUserFk method of class ReportModel
   */
  @Test
  public void setUserFkTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    report.setUserFk("g.madonna@studenti.unisa.it");
    Assert.assertEquals("It should return g.madonna@studenti.unisa.it", "g.madonna@studenti.unisa.it", report.getUserFk());
  }

  /**
   * test of getYear method of class ReportModel
   */
  @Test
  public void getYearTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    Assert.assertEquals("It should return 2019", 2019, report.getYear());
  }

  /**
   * test of setYeat method of class ReportModel
   */
  @Test
  public void setYearTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    report.setYear(2018);
    Assert.assertEquals("It should return 2018", 2018, report.getYear());

  }

  /**
   * test of getQuestionFk method of class ReportModel
   */
  @Test
  public void getQuestionFkTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019,
            "G.MADONNA3@studenti.unisa.it", 21);
    Assert.assertEquals("It should return 21", 21, report.getQuestionFk());
  }

  /**
   * test of setQuestionFk method of class ReportModel
   */
  @Test
  public void setQuestionFkTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    report.setQuestionFk(22);
    Assert.assertEquals("It should return 22", 22, report.getQuestionFk());
  }

  /**
   * test of toSting method of class ReportModel
   */
  @Test
  public void toStringTest() {
    Report report = new ReportModel(7, "andrea", "raiola", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    String test = "ReportModel{"
            + "id=" + 7
            + ", category=" + "andrea"
            + ", reason=" + "raiola"
            + ", userFk=" + "G.MADONNA3@studenti.unisa.it"
            + ", questionFk=" + 21
            + ", year=" + 2019
            + '}';
    assertEquals("It should return same description", test, report.toString());
  }
}
