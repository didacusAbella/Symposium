package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.question.ShowQuestionAction;
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
public class ShowQuestionActionTest extends IntegrationTestCase {
  
  private ShowQuestionAction question;
  
  @Before
  public void setUp() {
    this.question = new ShowQuestionAction(mockDbDatasource);
  }
  
  @Test
  public void testExecuteSuccess(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("questionId")).thenReturn("28");
    String page = this.question.execute(req, res);
    assertEquals("/question.jsp", page);
  }
  
  @Test
  public void testExecuteFail(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("questionId")).thenReturn("1000");
    String page = this.question.execute(req, res);
    assertEquals("/error400.jsp", page);
  }
  
}
