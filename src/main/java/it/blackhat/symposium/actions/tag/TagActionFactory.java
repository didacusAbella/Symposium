package it.blackhat.symposium.actions.tag;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;

/**
 *
 * @author Symposium Group
 */
public class TagActionFactory implements ActionFactory {

  private final DataSource ds;

  public TagActionFactory(DataSource ds) {
    this.ds = ds;
  }

  @Override
  public Action createAction(String actionType) throws InvalidActionException {
    switch (actionType) {
      case "showEditTag":
        return new RetrieveQuestionTagsAction(this.ds);
      case "changeTag":
        return new ChangeTagAction(this.ds);
      default:
        throw new InvalidActionException("Azione non supportata");
    }
  }

}
