package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;

/**
 * This class is used to create user action objects
 *
 * @author 2Deimos,Przemyslaw Szopian
 */
public class UserActionFactory implements ActionFactory {

    @Override
    public Action createAction(String actionType) throws InvalidActionException {
        switch (actionType) {
            case "signOut":
                return new SignoutAction();
            case "showProfile":
                return new ShowProfileAction();
            case "editProfile":
                return new EditProfileAction();
            case "showEditProfile":
                return new ShowEditProfileAction();
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }

}
