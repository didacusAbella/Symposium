package it.blackhat.symposium.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Avella
 */
public interface Action {
  String execute(HttpServletRequest req, HttpServletResponse res);
}
