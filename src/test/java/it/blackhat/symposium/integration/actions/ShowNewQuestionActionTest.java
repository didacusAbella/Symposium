package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.question.ShowNewQuestionAction;
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
public class ShowNewQuestionActionTest extends IntegrationTestCase {
  
  private ShowNewQuestionAction questionAction;
  
  @Before
  public void setUp() {
    this.questionAction = new ShowNewQuestionAction();
  }
  
  @Test
  public void testExecute(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    String page = this.questionAction.execute(req, res);
    assertEquals("/newQuestion.jsp", page);
  }
  
}
