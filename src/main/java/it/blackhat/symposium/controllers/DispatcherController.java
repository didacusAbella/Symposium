package it.blackhat.symposium.controllers;

import it.blackhat.symposium.helpers.InvalidActionException;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Abstract controller for dispatch actions
 */
public abstract class DispatcherController extends HttpServlet {

  private static final Log DISPATCH_LOG = LogFactory.getLog(DispatcherController.class);

  @Resource(name = "jdbc/SymposiumDB")
  protected DataSource ds;

  /**
   * Dispatch the request to specific page
   *
   * @param request the request
   * @param response the response
   * @param page the page to dispatch
   * @throws IOException for io exception
   * @throws ServletException for servlet exception
   */
  protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page)
          throws IOException, ServletException {
    this.getServletContext().getRequestDispatcher(page).forward(request, response);
  }

  /**
   * Process the specific request
   *
   * @param request the request
   * @param response the response
   * @throws ServletException for servlet handling
   * @throws IOException for io exception
   * @throws InvalidActionException for invalid
   * action exception
   */
  protected abstract void processRequest(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException, InvalidActionException;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    try {
      req.setCharacterEncoding("UTF-8");
      this.processRequest(req, resp);
    } catch (InvalidActionException ex) {
      DISPATCH_LOG.error("Comando non supportato", ex);
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    try {
      req.setCharacterEncoding("UTF-8");
      this.processRequest(req, resp);
    } catch (InvalidActionException ex) {
      DISPATCH_LOG.error("Comando non supportato", ex);
    }
  }

}
