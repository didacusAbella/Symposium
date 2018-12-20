package it.blackhat.symposium.actions.admin;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;

/**
 *
 * @author didacus
 */
public class AdminActionFactory implements ActionFactory {

    @Override
    public Action createAction(String actionType) {
        switch (actionType) {
            case "signin":
                return new SigninAdminAction();
            default:
                throw new UnsupportedOperationException("Azione non supportata");
        }
    }

}
