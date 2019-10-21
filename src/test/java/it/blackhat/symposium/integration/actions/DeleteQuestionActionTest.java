package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.question.DeleteQuestionAction;
import it.blackhat.symposium.actions.question.DeleteQuestionTagAction;
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
public class DeleteQuestionActionTest extends IntegrationTestCase {
  
  private DeleteQuestionAction deleteAction;
  
  @Before
  public void setUp() {
    this.deleteAction = new DeleteQuestionAction(mockDbDatasource, 
            new DeleteQuestionTagAction(mockDbDatasource));
  }
  
  @Test
  public void testExecuteSuccess(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("questionId")).thenReturn("21");
    String page = this.deleteAction.execute(req, res);
    assertEquals("/index.jsp", page);
  }
  
}
