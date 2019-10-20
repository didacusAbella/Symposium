package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.guest.SigninAction;
import it.blackhat.symposium.integration.IntegrationTestCase;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author didacus
 */
public class SigninActionTest extends IntegrationTestCase {
  
  private SigninAction signinAction;
  
  @Before
  public void setUp() {
    this.signinAction = new SigninAction(mockDbDatasource);
  }
  
  @Test
  public void testExecuteSuccess(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(req.getParameter("email")).thenReturn("G.MADONNA3@studenti.unisa.it");
    Mockito.when(req.getParameter("password")).thenReturn("PinoDan");
    Mockito.when(req.getSession()).thenReturn(session);
    String page = this.signinAction.execute(req, res);
    assertEquals("/index.jsp", page);
  }
  
  @Test
  public void testExecuteFailUserNotFound(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("email")).thenReturn("Gianni@studenti.unisa.it");
    Mockito.when(req.getParameter("password")).thenReturn("ProvaFallita");
    String page = this.signinAction.execute(req, res);
    assertEquals("/signIn.jsp", page);
  }
  
}
