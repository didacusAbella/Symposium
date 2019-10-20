package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.guest.SignupAction;
import it.blackhat.symposium.integration.IntegrationTestCase;
import java.util.Map;
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
public class SignupActionTest extends IntegrationTestCase {
  
  private SignupAction signupAction;
  
  @Before
  public void setUp() {
    this.signupAction = new SignupAction(mockDbDatasource);
  }
  
  @Test
  public void testExecuteFailEmailPresent(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    String[] email = {"G.MADONNA3@studenti.unisa.it"};
    String[] password = {"PinoDan"};
    Mockito.when(req.getParameterMap()).thenReturn(Map.of("email", email, "password", password));
    String page = this.signupAction.execute(req, res);
    assertEquals("/signUp.jsp", page);
  }
  
  @Test
  public void testExecuteFailValidation(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    String[] email = {"ProvaUser@studenti.unisa.it"};
    String[] password = {"PasswordProva"};
    String[] username = {"UserProva"};
    Mockito.when(req.getParameterMap()).thenReturn(Map.of("email", email, "password", password,  
            "username", username));
    String page = this.signupAction.execute(req, res);
    assertEquals("/error400.jsp", page);
  }
  
  @Test
  public void testExecuteSuccess(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    String[] email = {"d.av5@studenti.unisa.it"};
    String[] password = {"kr"};
    String[] username = {"didacus"};
    String[] firstName = {"Daigo"};
    String[] lastName = {"Abella"};
    Mockito.when(req.getParameterMap()).thenReturn(Map.of("email", email, "password", password,  
            "username", username, "firstName", firstName, "lastName", lastName));
    String page = this.signupAction.execute(req, res);
    assertEquals("/signIn.jsp", page);
  }
  
}
