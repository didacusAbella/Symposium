package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.report.ShowInsertReportAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author didacus
 */
public class ShowInsertReportActionTest {
  
  private ShowInsertReportAction showInsertReport;

  @Before
  public void setUp() {
    this.showInsertReport = new ShowInsertReportAction();
  }
  
  @Test
  public void testExecute(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("questionId")).thenReturn("28");
    String page = this.showInsertReport.execute(req, res);
    assertEquals("/insertReport.jsp", page);
  }
  
}
