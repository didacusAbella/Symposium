package it.blackhat.symposium.actions;

/**
 *
 * @author didacus
 */
public interface ActionFactory {
  
  Action createAction(String actionType);
  
}
