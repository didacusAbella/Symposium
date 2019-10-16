package it.blackhat.symposium.actions.report;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;

/**
 *
 * @author Symposium Group
 */
public class ReportActionFactory implements ActionFactory {

  private final DataSource ds;

  public ReportActionFactory(DataSource ds) {
    this.ds = ds;
  }

  @Override
  public Action createAction(String actionType) throws InvalidActionException {
    switch (actionType) {
      case "showInsertReport":
        return new ShowInsertReportAction();
      case "insertReport":
        return new ReportQuestionAction(this.ds);
      default:
        throw new InvalidActionException("Azione non supportata");
    }
  }

}
