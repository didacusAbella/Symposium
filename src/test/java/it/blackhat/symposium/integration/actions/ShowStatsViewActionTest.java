package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.stats.ShowStatsViewAction;
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
public class ShowStatsViewActionTest {
  
  private ShowStatsViewAction ssva;
  
  @Before
  public void setUp() {
    this.ssva = new ShowStatsViewAction();
  }
  
  @Test
  public void testExecute(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    String page = this.ssva.execute(req, res);
    assertEquals("/stats.jsp", page);
  }
}
