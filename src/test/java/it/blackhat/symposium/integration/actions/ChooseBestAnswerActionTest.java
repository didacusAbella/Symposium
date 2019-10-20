/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.answer.ChooseBestAnswerAction;
import it.blackhat.symposium.integration.IntegrationTestCase;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;

/**
 *
 * @author didacus
 */
public class ChooseBestAnswerActionTest extends IntegrationTestCase {
  
  private ChooseBestAnswerAction bestanswerAction;
  
  @Before
  public void setUp() {
    this.bestanswerAction = new ChooseBestAnswerAction(mockDbDatasource);
  }
  
  @Test
  public void testExecute() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    Mockito.when(req.getParameter("id")).thenReturn("6");
    String page = this.bestanswerAction.execute(req, res);
    assertEquals("/index.jsp", page);
  } 
  
}
