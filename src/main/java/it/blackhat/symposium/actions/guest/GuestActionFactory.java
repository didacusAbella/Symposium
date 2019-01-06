package it.blackhat.symposium.actions.guest;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.answer.RetrieveQuestionAnswersAction;
import it.blackhat.symposium.actions.question.SeachQuestionByAction;
import it.blackhat.symposium.actions.question.ShowQuestionAction;
import it.blackhat.symposium.actions.question.ShowQuestionsAction;
import it.blackhat.symposium.actions.tag.RetrieveQuestionTagsAction;
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
            case "seachQuestionsBy":
                return new SeachQuestionByAction();      
            case "signinAdmin":
                return new SigninAdminAction();
            case "showQuestion":
                return new ShowQuestionAction(new RetrieveQuestionAnswersAction(),
                        new RetrieveQuestionTagsAction());
            case "showQuestions":
                return new ShowQuestionsAction();
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }

}
