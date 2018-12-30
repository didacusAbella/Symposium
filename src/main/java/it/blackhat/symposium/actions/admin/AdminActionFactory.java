package it.blackhat.symposium.actions.admin;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;

/**
 *
 * @author didacus
 */
public class AdminActionFactory implements ActionFactory {

    @Override
    public Action createAction(String actionType) throws InvalidActionException {
        switch (actionType) {
            case "signin":
                return new SigninAdminAction();
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }

}
