package it.blackhat.symposium.actions.guest;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;

/**
 * This class is used to create guest action objects
 *
 * @author 2Deimos
 */
public class GuestActionFactory implements ActionFactory {

    @Override
    public Action createAction(String actionType) throws InvalidActionException {
        switch (actionType) {
            case "signIn":
                return new SigninAction();
            case "signUp":
                return new SignupAction();
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }

}
