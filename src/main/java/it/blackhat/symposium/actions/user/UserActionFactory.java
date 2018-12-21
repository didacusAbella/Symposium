package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;

/**
 * This class is used to create user action objects
 * @author 2Deimos
 */
public class UserActionFactory implements ActionFactory {

    @Override
    public Action createAction(String actionType) throws InvalidActionException {
        switch (actionType) {
            case "signout":
                return new SignoutAction();
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }

}
