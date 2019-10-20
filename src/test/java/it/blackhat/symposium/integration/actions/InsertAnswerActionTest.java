package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.answer.InsertAnswerAction;
import it.blackhat.symposium.integration.IntegrationTestCase;
import it.blackhat.symposium.models.UserModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;

/**
 *
 * @author didacus
 */
public class InsertAnswerActionTest extends IntegrationTestCase {
  
  private InsertAnswerAction answerAction;
  
  @Before
  public void setUp() {
    this.answerAction = new InsertAnswerAction(mockDbDatasource);
  }
  
  @Test
  public void testExecuteValidationPass() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    HttpSession session = Mockito.mock(HttpSession.class);
    UserModel model = Mockito.mock(UserModel.class);
    Mockito.when(model.getEmail()).thenReturn("c.cicciolina@studenti.unisa.it");
    Mockito.when(session.getAttribute("user")).thenReturn(model);
    Mockito.when(req.getSession()).thenReturn(session);
    Mockito.when(req.getParameter("questionID")).thenReturn("19");
    Mockito.when(req.getParameter("answerContent")).thenReturn("Non si passa");
    String page = this.answerAction.execute(req, res);
    assertEquals("/index.jsp", page);
  }
  
  @Test
  public void testExeciteValidationFail() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    HttpSession session = Mockito.mock(HttpSession.class);
    UserModel model = Mockito.mock(UserModel.class);
    Mockito.when(model.getEmail()).thenReturn("c.cicciolina@studenti.unisa.it");
    Mockito.when(session.getAttribute("user")).thenReturn(model);
    Mockito.when(req.getSession()).thenReturn(session);
    Mockito.when(req.getParameter("questionID")).thenReturn("12");
    Mockito.when(req.getParameter("answerContent")).thenReturn("");
    String page = this.answerAction.execute(req, res);
    assertEquals("/error400.jsp", page);
  }
}
