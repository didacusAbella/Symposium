package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.answer.RetrieveQuestionAnswersAction;
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
public class RetrieveQuestionAnswersActionTest extends IntegrationTestCase {
  
  private RetrieveQuestionAnswersAction retrieveQuestion;
  
  @Before
  public void setUp() {
    this.retrieveQuestion = new RetrieveQuestionAnswersAction(mockDbDatasource);
  }
  
  @Test
  public void testExecute() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("questionId")).thenReturn("56");
    String page = this.retrieveQuestion.execute(req, res);
    assertEquals("#", page);
  }
}
