package it.blackhat.symposium.actions;

import it.blackhat.symposium.helpers.InvalidActionException;

/**
 * Interface for creating Action family classes
 */
public interface ActionFactory {

  /**
   * Create a new action based on the action type. 
   *
   * @param actionType the action typr
   * @return a new Action
   * @throws InvalidActionException the invalid action exception
   */
  Action createAction(String actionType) throws InvalidActionException;

}
