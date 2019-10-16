package it.blackhat.symposium.actions.stats;

import it.blackhat.symposium.actions.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Show the stats page
 */
public class ShowStatsViewAction implements Action {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    return "/stats.jsp";
  }
}
