package it.blackhat.symposium.actions.user;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;

/**
 * Factory for create family of user classes
 * @author didacus
 */
public class UserActionFactory implements ActionFactory {

  private final DataSource ds;

  /**
   * Create the factory
   * @param ds the datasource
   */
  public UserActionFactory(DataSource ds) {
    this.ds = ds;
  }

  @Override
  public Action createAction(String actionType) throws InvalidActionException {
    switch (actionType) {
      case "signOut":
        return new SignoutAction();
      case "showProfile":
        return new ShowProfileAction();
      case "editProfile":
        return new EditProfileAction(this.ds);
      case "showEditProfile":
        return new ShowEditProfileAction();
      case "banUser":
        return new BanAction(this.ds);
      case "deleteAccount":
        return new DeleteAccountAction(this.ds);
      default:
        throw new InvalidActionException("Azione non supportata");
    }
  }

}
