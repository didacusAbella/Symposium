package it.blackhat.symposium.actions.guest;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.answer.RetrieveQuestionAnswersAction;
import it.blackhat.symposium.actions.question.SeachQuestionByAction;
import it.blackhat.symposium.actions.question.ShowQuestionAction;
import it.blackhat.symposium.actions.question.ShowQuestionsAction;
import it.blackhat.symposium.actions.tag.RetrieveQuestionTagsAction;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;

/**
 * Factory for create guest action family classes
 * @author didacus
 */
public class GuestActionFactory implements ActionFactory {

  private final DataSource ds;

  /**
   * Create the factory
   * @param ds the datasource object
   */
  public GuestActionFactory(DataSource ds) {
    this.ds = ds;
  }

  @Override
  public Action createAction(String actionType) throws InvalidActionException {
    switch (actionType) {
      case "signIn":
        return new SigninAction(this.ds);
      case "signUp":
        return new SignupAction(this.ds);
      case "searchQuestionsBy":
        return new SeachQuestionByAction(this.ds);
      case "signinAdmin":
        return new SigninAdminAction(this.ds);
      case "showQuestion":
        return new ShowQuestionAction(this.ds, new RetrieveQuestionAnswersAction(this.ds),
                new RetrieveQuestionTagsAction(this.ds));
      case "showQuestions":
        return new ShowQuestionsAction(this.ds);
      default:
        throw new InvalidActionException("Azione non supportata");
    }
  }

}
