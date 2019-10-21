package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.question.ShowQuestionsAction;
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
public class ShowQuestionsActionTest extends IntegrationTestCase {
  
  private ShowQuestionsAction question;
  
  @Before
  public void setUp() {
    this.question = new ShowQuestionsAction(mockDbDatasource);
  }
  
  @Test
  public void testExecute(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    String page = this.question.execute(req, res);
    assertEquals("/allQuestions.jsp", page);
  }
}