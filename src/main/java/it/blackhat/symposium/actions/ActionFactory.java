package it.blackhat.symposium.actions;

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
     */
    Action createAction(String actionType);

}
