package it.blackhat.symposium.integration;

import it.blackhat.symposium.actions.answer.DeleteAnswerAdminAction;
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
public class DeleteAnswerAdminActionTest extends IntegrationTestCase {
  
  private DeleteAnswerAdminAction deleteAction;
  
  @Before
  public void setUp() {
    this.deleteAction = new DeleteAnswerAdminAction(mockDbDatasource);
  }
  
  @Test
  public void testExecute(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("id")).thenReturn("6");
    String page = this.deleteAction.execute(req, res);
    assertEquals("/index.jsp", page);
  }
  
}
