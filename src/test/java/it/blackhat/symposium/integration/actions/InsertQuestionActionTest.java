package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.question.InsertQuestionAction;
import it.blackhat.symposium.actions.stats.UpdateStatsAction;
import it.blackhat.symposium.actions.tag.InsertTagAction;
import it.blackhat.symposium.integration.IntegrationTestCase;
import it.blackhat.symposium.models.UserModel;
import java.util.Map;
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
public class InsertQuestionActionTest extends IntegrationTestCase {
  
  private InsertQuestionAction insertAction;
  
  @Before
  public void setUp() {
    this.insertAction = new InsertQuestionAction(mockDbDatasource, 
            new InsertTagAction(mockDbDatasource), 
                new UpdateStatsAction(mockDbDatasource));
  }
  
   @Test
  public void testExecuteFailValidation(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(req.getSession()).thenReturn(session);
    UserModel model = Mockito.mock(UserModel.class);
    Mockito.when(model.getEmail()).thenReturn("d.tropeano@studenti.unisa.it");
    Mockito.when(session.getAttribute("user")).thenReturn(model);
    String[] title = {"a"};
    String[] content = {"Posso superare IS io ci credo"};
    String[] id = {"302"};
    String[] numReports = {"0"};
    Mockito.when(req.getParameterMap()).thenReturn(Map.of("title", title, "content", 
            content,"id", id, "numReports", numReports));
    String page = this.insertAction.execute(req, res);
    assertEquals("/error400.jsp", page);
  }
  
}
