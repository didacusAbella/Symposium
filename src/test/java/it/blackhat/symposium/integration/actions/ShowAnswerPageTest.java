package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.answer.ShowAnswerPage;
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
public class ShowAnswerPageTest extends IntegrationTestCase {
  
  private ShowAnswerPage showPage;
  
  @Before
  public void setUp() {
    this.showPage = new ShowAnswerPage(mockDbDatasource);
  }
  
  @Test
  public void testExecuteNoQuestion(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("questionId")).thenReturn("1000");
    String page = this.showPage.execute(req, res);
    assertEquals("/error500.jsp", page);
  }
  
  @Test
  public void testExecuteWithQuestion() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("questionId")).thenReturn("28");
    String page = this.showPage.execute(req, res);
    assertEquals("/newAnswer.jsp", page);
  }
  
}
