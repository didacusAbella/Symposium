package it.blackhat.symposium.actions.guest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.blackhat.symposium.actions.Action;

/**
 * The class increments the number of the registered members
 * 
 * @author Parrilli Carminantonio
 *
 */
public class IncrementRegisteredUsersNumberAction implements Action {
    /**
     * The costructor of the class
     */
    public IncrementRegisteredUsersNumberAction() {
        
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        
        return null;
    }
}
