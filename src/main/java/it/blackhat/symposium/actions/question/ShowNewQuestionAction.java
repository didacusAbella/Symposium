package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This action show the question creation form
 */
public class ShowNewQuestionAction implements Action {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    return "/newQuestion.jsp";
  }

}
