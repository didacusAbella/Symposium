/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.blackhat.symposium.integration.actions;

import it.blackhat.symposium.actions.admin.SignoutAdmin;
import it.blackhat.symposium.integration.IntegrationTestCase;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;

/**
 *
 * @author didacus
 */
public class SignoutAdminTest extends IntegrationTestCase {
  
  private SignoutAdmin signoutAdmin;
  
  public SignoutAdminTest() {
  }
  
  @Before
  public void setUp() {
    this.signoutAdmin = new SignoutAdmin();
  }
  
  @Test
  public void testExec() {
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    HttpSession session = Mockito.mock(HttpSession.class);
    session.setAttribute("admin", "admin");
    Mockito.when(req.getSession()).thenReturn(session);
    String page = this.signoutAdmin.execute(req, res);
    assertEquals("/index.jsp", page);
  }
  
}
