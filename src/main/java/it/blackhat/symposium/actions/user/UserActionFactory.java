package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;

/**
 * This class is used to create user action objects
 * @author 2Deimos
 * @author Przemyslaw Szopian
 */
public class UserActionFactory implements ActionFactory {

    @Override
    public Action createAction(String actionType) throws InvalidActionException {
        switch (actionType) {
            case "signout":
                return new SignoutAction();
            case "editprofile":
                return new EditProfileAction();
            case "showprofile":
                return new ShowProfileAction();
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }

}
