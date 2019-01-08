package it.blackhat.symposium.actions.tag;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;

/**
 *
 * @author Symposium Group
 */
public class TagActionFactory implements ActionFactory {

    @Override
    public Action createAction(String actionType) throws InvalidActionException {
        switch (actionType) {
            case "changeTag":
                return new ChangeTagAction();
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }

}
