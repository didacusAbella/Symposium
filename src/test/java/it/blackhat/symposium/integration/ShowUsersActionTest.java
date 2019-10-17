package it.blackhat.symposium.integration;

import it.blackhat.symposium.actions.admin.ShowUsersAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author didacus
 */
public class ShowUsersActionTest extends IntegrationTestCase {
  
  private ShowUsersAction showUsersAction;
  
  @Before
  public void setUp() {
    this.showUsersAction = new ShowUsersAction(mockDbDatasource);
  }
  
  @Test
  public void testExec(){
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    String page = this.showUsersAction.execute(req, res);
    Assert.assertEquals("/userList.jsp", page);
  }
  
}
