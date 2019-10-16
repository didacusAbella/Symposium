package it.blackhat.symposium.helpers;

/**
 * This exception is thrown when an unsupported action is catched.
 *
 * @author Andrea
 */
public class InvalidActionException extends Exception {

  /**
   * Constructs an instance of <code>InvalidActionException</code> with the
   * specified detail message.
   *
   * @param msg the detail message.
   */
  public InvalidActionException(String msg) {
    super(msg);
  }
}
