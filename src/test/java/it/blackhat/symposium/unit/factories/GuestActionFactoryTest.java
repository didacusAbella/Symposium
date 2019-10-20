package it.blackhat.symposium.unit.factories;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.guest.GuestActionFactory;
import it.blackhat.symposium.actions.guest.SigninAction;
import it.blackhat.symposium.actions.guest.SigninAdminAction;
import it.blackhat.symposium.actions.guest.SignupAction;
import it.blackhat.symposium.actions.question.SeachQuestionByAction;
import it.blackhat.symposium.actions.question.ShowQuestionAction;
import it.blackhat.symposium.actions.question.ShowQuestionsAction;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.BeforeClass;
import org.mockito.Mockito;

/**
 *
 * @author Gozzetto
 */
public class GuestActionFactoryTest {

  ActionFactory guestFactory;

  private static DataSource ds;

  @BeforeClass
  public static final void setUpClass() {
    ds = Mockito.mock(BasicDataSource.class);
  }

  @Before
  public void setUp() {
    guestFactory = new GuestActionFactory(ds);
  }

  @Test
  public void testSignInAction() throws InvalidActionException {
    Action test = guestFactory.createAction("signIn");
    assertTrue(test instanceof SigninAction);
  }

  @Test
  public void testSignUpAction() throws InvalidActionException {
    Action test = guestFactory.createAction("signUp");
    assertTrue(test instanceof SignupAction);
  }

  @Test
  public void testSeachQuestionsByAction() throws InvalidActionException {
    Action test = guestFactory.createAction("searchQuestionsBy");
    assertTrue(test instanceof SeachQuestionByAction);
  }

  @Test
  public void testSignInAdminAction() throws InvalidActionException {
    Action test = guestFactory.createAction("signinAdmin");
    assertTrue(test instanceof SigninAdminAction);
  }

  @Test
  public void testShowQuestionAction() throws InvalidActionException {
    Action test = guestFactory.createAction("showQuestion");
    assertTrue(test instanceof ShowQuestionAction);
  }

  @Test
  public void testShowQuestionsAction() throws InvalidActionException {
    Action test = guestFactory.createAction("showQuestions");
    assertTrue(test instanceof ShowQuestionsAction);

  }

  @Test(expected = InvalidActionException.class)
  public void createInvalidActionExceptionTest() throws InvalidActionException {
    new GuestActionFactory(ds).createAction("gianni");
  }

}
