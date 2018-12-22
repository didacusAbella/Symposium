package it.blackhat.symposium.actions;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Composite Action
 *
 * @version 0.1
 * @author 2Deimos
 */
public class CompositeAction implements Action {
    
    private final ArrayList<Action> actions;
/**
 * Initialize CompositeAction with an array of actions
 * @param actions the array of actions
 */
    public CompositeAction(ArrayList<Action> actions) {
        this.actions = actions;
    }
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        for (Action action : actions) {
            action.execute(req, res);
        }
        return "";
    }

}
