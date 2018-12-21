package it.blackhat.symposium.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Andrea Raiola
 *
 */
@WebFilter("/user/*")
public class UserLogInFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/signIn.jsp";
    
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        
        if (loggedIn) {
            chain.doFilter(req, resp);
        }
        else {
            resp.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() { 
    }
    
}
