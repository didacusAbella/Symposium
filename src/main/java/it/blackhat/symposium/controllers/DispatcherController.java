package it.blackhat.symposium.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class DispatcherController extends HttpServlet {
    
    /**
     * Dispatch the request to specific page
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
     * @param request the request
     * @param response the response
     * @throws ServletException for servlet handling
     * @throws IOException for io exception
     */
    protected abstract void processRequest(HttpServletRequest request, 
                HttpServletResponse response) 
            throws ServletException, IOException;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        this.processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        this.processRequest(req, resp);
    }

}
