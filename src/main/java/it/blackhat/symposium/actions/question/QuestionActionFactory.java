package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.answer.DeleteAnswerByQuestionAction;
import it.blackhat.symposium.actions.answer.RetrieveQuestionAnswersAction;
import it.blackhat.symposium.actions.stats.UpdateStatsAction;
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
                return new InsertQuestionAction(new InsertTagAction(), new UpdateStatsAction());

            case "deleteQuestion":
                return new DeleteQuestionAction(new DeleteAnswerByQuestionAction(),
                        new DeleteQuestionTagAction());

            case "reportQuestion":
                return new ReportQuestionAction();

            case "deleteQuestionAdmin":
                return new DeleteQuestionAdminAction();

            case "modifyTagQuestionAdmin":
                return new ModifyTagQuestionAdminAction();

            case "seachQuestionBy":
                return new SeachQuestionByAction();

            case "showQuestion":
                return new ShowQuestionAction(new RetrieveQuestionAnswersAction(),
                        new RetrieveQuestionTagsAction());

            case "addFavourite":
                return new AddFavouriteAction();

            case "showFavorite":
                return new ShowFavoriteAction();

            case "showNewQuestion":
                return new ShowNewQuestionAction();
                
            case "showQuestions":
                return new ShowQuestionsAction();
                
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }

}
