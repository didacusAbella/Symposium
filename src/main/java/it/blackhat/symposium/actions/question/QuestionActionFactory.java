package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.answer.RetrieveQuestionAnswersAction;
import it.blackhat.symposium.actions.stats.UpdateStatsAction;
import it.blackhat.symposium.actions.tag.InsertTagAction;
import it.blackhat.symposium.actions.tag.RetrieveQuestionTagsAction;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;

/**
 * Create famility of question action classes
 */
public class QuestionActionFactory implements ActionFactory {

  private final DataSource ds;

  /**
   * Create the factory
   * @param ds the datasource object
   */
  public QuestionActionFactory(DataSource ds) {
    this.ds = ds;
  }

  @Override
  public Action createAction(String actionType) throws InvalidActionException {
    switch (actionType) {
      case "insertQuestion":
        return new InsertQuestionAction(this.ds, new InsertTagAction(this.ds), 
                new UpdateStatsAction(this.ds));
      case "deleteQuestion":
        return new DeleteQuestionAction(this.ds,
                new DeleteQuestionTagAction(this.ds));

      case "seachQuestionBy":
        return new SeachQuestionByAction(this.ds);

      case "showQuestion":
        return new ShowQuestionAction(this.ds, new RetrieveQuestionAnswersAction(this.ds),
                new RetrieveQuestionTagsAction(this.ds));
      case "showQuestionByAuthor":
        return new ShowMyQuestion(this.ds);

      case "addFavourite":
        return new AddFavouriteAction(this.ds, new ShowQuestionAction(this.ds));

      case "showFavorite":
        return new ShowFavoriteAction(this.ds);

      case "showNewQuestion":
        return new ShowNewQuestionAction();

      case "showQuestions":
        return new ShowQuestionsAction(this.ds);

      default:
        throw new InvalidActionException("Azione non supportata");
    }
  }

}
