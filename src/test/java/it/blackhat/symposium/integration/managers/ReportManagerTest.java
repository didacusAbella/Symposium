package it.blackhat.symposium.integration.managers;

import it.blackhat.symposium.integration.IntegrationTestCase;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.managers.ReportManager;
import it.blackhat.symposium.managers.ReportModelManager;
import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Report;
import it.blackhat.symposium.models.ReportModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ReportManagerTest extends IntegrationTestCase {

  public ReportManager reportManager;
  public QuestionManager questionManager;

  @Before
  public void setUp() {
    this.reportManager = new ReportModelManager(IntegrationTestCase.mockDbDatasource);
    this.questionManager = new QuestionModelManager(IntegrationTestCase.mockDbDatasource);
  }

  @Test
  public void insertReportTest() throws SQLException {
    Report report = new ReportModel();
    report.setCategory("questo è spam");
    report.setReason("spam");
    report.setYear(2019);
    report.setUserFk("g.demaio24@studenti.unisa.it");
    report.setQuestionFk(19);
    Optional<Question> question = this.questionManager.findQuestion(19);
    Assert.assertTrue(this.reportManager.insertReport(report, question.get()) == 1);
  }

  @Test
  public void retrieveReport() throws SQLException {
    List<Report> report = this.reportManager.retrieveReport(28);
    Assert.assertEquals("It should return 2", 2, report.size());
  }

  @Test
  public void retrieveAllReports() throws SQLException {
    List<Report> report = this.reportManager.retrieveAllReports();
    Assert.assertTrue(report.size() > 0);
  }

}
