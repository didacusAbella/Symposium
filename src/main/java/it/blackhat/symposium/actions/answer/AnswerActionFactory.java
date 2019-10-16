package it.blackhat.symposium.actions.answer;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;

/**
 * This class is used to create answer related action objects
 *
 * @author 2Deimos
 */
public class AnswerActionFactory implements ActionFactory {

  private final DataSource ds;

  public AnswerActionFactory(DataSource ds) {
    this.ds = ds;
  }

  @Override
  public Action createAction(String actionType) throws InvalidActionException {
    switch (actionType) {
      case "insertAnswer":
        return new InsertAnswerAction(this.ds);
      case "chooseBestAnswer":
        return new ChooseBestAnswerAction(this.ds);
      case "deleteAnswerAdmin":
        return new DeleteAnswerAdminAction(this.ds);
      case "showAnswerPage":
        return new ShowAnswerPage(this.ds);
      default:
        throw new InvalidActionException("Azione non supportata");
    }
  }

}
