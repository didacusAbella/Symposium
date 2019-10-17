package it.blackhat.symposium.integration;

import it.blackhat.symposium.actions.admin.GenerateReportListAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;

/**
 *
 * @author didacus
 */
public class GenerateReportListActionTest extends IntegrationTestCase {
  
  private GenerateReportListAction reportAction;
  
  @Before
  public void setUpClass() {
    this.reportAction = new GenerateReportListAction(mockDbDatasource);
  }

  @Test
  public void testExecute() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    String page = this.reportAction.execute(req, res);
    assertEquals("/reportList.jsp", page);
  }
  
}
