package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.answer.RetrieveQuestionAnswersAction;
import it.blackhat.symposium.actions.tag.InsertTagAction;
import it.blackhat.symposium.actions.tag.RetrieveQuestionTagsAction;
import it.blackhat.symposium.helpers.InvalidActionException;

/**
 * This class is used to create question related action objects
 *
 * @author 2Deimos
 * @author Gozzetto
 */
public class QuestionActionFactory implements ActionFactory {

    @Override
    public Action createAction(String actionType) throws InvalidActionException {
        switch (actionType) {
            case "insertQuestion":
                return new InsertQuestionAction(new InsertTagAction());
            case "deleteQuestion":
                return new DeleteQuestionAction();
            case "reportQuestion":
                return new ReportQuestionAction();
            case "deleteQuestionAdmin":
                return new DeleteQuestionAdminAction();
            case "modifyTagQuestionAdmin":
                return new ModifyTagQuestionAdminAction();
            case "seachQuestionsBy":
                return new SeachQuestionsBy();
            case "showQuestion":
                return new ShowQuestionAction(new RetrieveQuestionAnswersAction(),
                        new RetrieveQuestionTagsAction());
            case "addFavourite":
                return new AddFavouriteAction();
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }

}
