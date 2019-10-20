package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.guest.SigninAdminAction;
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
public class SigninAdminActionTest extends IntegrationTestCase {
  
  private SigninAdminAction signinAction;
  
  @Before
  public void setUp() {
    this.signinAction = new SigninAdminAction(mockDbDatasource);
  }
  
  @Test
  public void testExecutePass(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(req.getParameter("username")).thenReturn("Supergoku");
    Mockito.when(req.getParameter("password")).thenReturn("P@ssw0rd");
    Mockito.when(req.getSession(true)).thenReturn(session);
    String page = this.signinAction.execute(req, res);
    assertEquals("/index.jsp", page);
  }
  
  @Test
  public void testExecuteFail() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("username")).thenReturn("GiannoLoSa");
    Mockito.when(req.getParameter("password")).thenReturn("EinveceNo");
    String page = this.signinAction.execute(req, res);
    assertEquals("/adminSignIn.jsp", page);
  }
  
}
