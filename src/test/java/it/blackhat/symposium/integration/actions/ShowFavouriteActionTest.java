package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.question.ShowFavoriteAction;
import it.blackhat.symposium.integration.IntegrationTestCase;
import it.blackhat.symposium.models.UserModel;
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
public class ShowFavouriteActionTest extends IntegrationTestCase {
  
  private ShowFavoriteAction showAction;
  
  @Before
  public void setUp() {
    this.showAction = new ShowFavoriteAction(mockDbDatasource);
  }
  
  @Test
  public void testExecuteSuccess(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    HttpSession session = Mockito.mock(HttpSession.class);
    UserModel model = Mockito.mock(UserModel.class);
    Mockito.when(model.getEmail()).thenReturn("d.tropeano@studenti.unisa.it");
    Mockito.when(session.getAttribute("user")).thenReturn(model);
    Mockito.when(req.getSession()).thenReturn(session);
    String page = this.showAction.execute(req, res);
    assertEquals( "/favoriteQuestion.jsp", page);
  }
  
}
