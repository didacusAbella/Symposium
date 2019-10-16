package it.blackhat.symposium.actions;

import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A composite action is a set of action executed in order
 */
public class CompositeAction implements Action {

  private final ArrayList<Action> actions;

  /**
   * Initialize CompositeAction with an list of actions
   *
   * @param actions the array of actions
   */
  public CompositeAction(Action... actions) {
    this.actions = new ArrayList<>();
    this.actions.addAll(Arrays.asList(actions));
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    actions.forEach(action -> action.execute(req, res));
    return "";
  }

}
