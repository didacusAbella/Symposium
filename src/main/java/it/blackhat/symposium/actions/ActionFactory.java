package it.blackhat.symposium.actions;

import it.blackhat.symposium.helpers.InvalidActionException;

/**
 *
 * @author didacus
 */
public interface ActionFactory {
    
    /**
     * Create a new action based on the action type. An Action is an end User Action or an inner
     * action.
     * @param actionType the action typr
     * @return a new Action
     * @throws it.blackhat.symposium.helpers.InvalidActionException the invalid action exception
     */
    Action createAction(String actionType) throws InvalidActionException;

}
