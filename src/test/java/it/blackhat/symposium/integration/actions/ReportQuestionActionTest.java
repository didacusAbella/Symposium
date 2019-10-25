package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.report.ReportQuestionAction;
import it.blackhat.symposium.integration.IntegrationTestCase;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author didacus
 */
public class ReportQuestionActionTest extends IntegrationTestCase {
  
  private ReportQuestionAction reportQuestion;
  
  @Before
  public void setUp() {
    this.reportQuestion = new ReportQuestionAction(mockDbDatasource);
  }
  
  @Test
  public void testExecuteSuccess(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("questionId")).thenReturn("28");
    Mockito.when(req.getParameter("category")).thenReturn("spam");
    Mockito.when(req.getParameter("reason")).thenReturn("messaggio spam");
    String page = this.reportQuestion.execute(req, res);
    assertEquals("/index.jsp", page);
  }
  
  @Test
  public void testExecuteFail(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("questionId")).thenReturn("1000");
    String page = this.reportQuestion.execute(req, res);
    assertEquals("/error400.jsp", page);
  }
  
  
}
