package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;

/**
 *
 * @author 2Deimos
 */
public class UserActionFactory implements ActionFactory {

    @Override
    public Action createAction(String actionType) {
        switch (actionType) {
            case "signout":
                return new SignoutAction();
            default:
                throw new UnsupportedOperationException("Azione non supportata");
        }
    }

}
