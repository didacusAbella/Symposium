package it.blackhat.symposium.actions.report;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;

/**
 * Create action of report family classes
 */
public class ReportActionFactory implements ActionFactory {

  private final DataSource ds;

  /**
   * Create the factory
   * @param ds the datasource object
   */
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
