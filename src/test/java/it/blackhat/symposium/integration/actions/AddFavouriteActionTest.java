package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.question.AddFavouriteAction;
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
public class AddFavouriteActionTest extends IntegrationTestCase {
  
  private AddFavouriteAction favouriteAction;

  @Before
  public void setUp() {
    this.favouriteAction = new AddFavouriteAction(mockDbDatasource, 
            new ShowQuestionAction(mockDbDatasource));
  }
  
  @Test
  public void testExecuteSuccess(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("questionId")).thenReturn("19");
    Mockito.when(req.getParameter("userEmail")).thenReturn("d.tropeano@studenti.unisa.it");
    String page = this.favouriteAction.execute(req, res);
    assertEquals("/user/QuestionController?action=showFavorite", page);
  }
 
}
