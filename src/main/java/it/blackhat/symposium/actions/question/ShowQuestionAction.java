
package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.CompositeAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author didacus
 */
public class ShowQuestionAction extends CompositeAction {

    public ShowQuestionAction(Action... actions) {
        super(actions);
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        return super.execute(req, res);
    }
    
    
    
}
