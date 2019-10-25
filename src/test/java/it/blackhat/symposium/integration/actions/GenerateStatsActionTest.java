package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.stats.GenerateStatsAction;
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
public class GenerateStatsActionTest extends IntegrationTestCase {
  
  private GenerateStatsAction statAction;
  
  @Before
  public void setUp() {
    this.statAction = new GenerateStatsAction(mockDbDatasource);
  }
  
  @Test
  public void testExecute(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("year")).thenReturn("2019");
    String page = this.statAction.execute(req, res);
    assertEquals("/stats.jsp", page);
  }
  
}
