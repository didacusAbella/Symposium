package it.blackhat.symposium.actions.answer;


import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;

/**
 * This class is used to create answer related action objects
 *
 * @author 2Deimos
 */
public class AnswerActionFactory implements ActionFactory {

    @Override
    public Action createAction(String actionType) throws InvalidActionException {
        switch (actionType) {
            case "insertAnswer":
                return new InsertAnswerAction();
            /*case "deleteAnswer":
                return new DeleteAnswerAction();*/
            case "chooseBestAnswer":
                return new ChooseBestAnswerAction();
            /*case "deleteAnswerAdmin":
                return new DeleteAnswerAdminAction();*/
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }

}
