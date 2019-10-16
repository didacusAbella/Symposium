package it.blackhat.symposium.actions.admin;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;

/**
 *
 * @author Symposium Group
 */
public class AdminActionFactory implements ActionFactory {

  private final DataSource ds;

  /**
   * Create the admin action factory
   * @param ds the datasource object
   */
  public AdminActionFactory(DataSource ds) {
    this.ds = ds;
  }

  @Override
  public Action createAction(String actionType) throws InvalidActionException {
    switch (actionType) {
      case "adminSignout":
        return new SignoutAdmin();
      case "showUsersAction":
        return new ShowUsersAction(this.ds);
      case "generateReportListAction":
        return new GenerateReportListAction(this.ds);
      default:
        throw new InvalidActionException("Azione non supportata");
    }
  }

}
