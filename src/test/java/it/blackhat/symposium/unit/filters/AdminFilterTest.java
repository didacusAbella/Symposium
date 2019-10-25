
package it.blackhat.symposium.unit.filters;

import it.blackhat.symposium.filters.AdminLogInFilter;
import it.blackhat.symposium.models.AdminModel;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author didacus
 */
public class AdminFilterTest {
  
  private AdminLogInFilter filter;
  
  @Before
  public void setUp() {
    this.filter = new AdminLogInFilter();
  }
  
  @Test
  public void testFilterSuccess() throws IOException, ServletException{
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(req.getRequestURI()).thenReturn("/admin.jsp");
    Mockito.when(session.getAttribute("admin")).thenReturn(new AdminModel());
    Mockito.when(req.getSession(false)).thenReturn(session);
    FilterChain chain = Mockito.mock(FilterChain.class);
    this.filter.doFilter(req, res, chain);
    Mockito.verify(chain).doFilter(req, res);
  }
  
  @Test
  public void testFilterFail() throws IOException, ServletException{
    HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(req.getRequestURI()).thenReturn("/Symposium/admin.jsp");
    Mockito.when(req.getContextPath()).thenReturn("/Symposium");
    Mockito.when(session.getAttribute("admin")).thenReturn(null);
    Mockito.when(req.getSession(false)).thenReturn(session);
    FilterChain chain = Mockito.mock(FilterChain.class);
    this.filter.doFilter(req, res, chain);
    Mockito.verify(res).sendRedirect("/Symposium/signIn.jsp");
  }
}
