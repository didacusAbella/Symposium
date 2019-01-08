package it.blackhat.symposium.unit;

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
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

/**
 *
 * @author Gozzetto
 */
public class GuestActionFactoryTest {
    ActionFactory guestFactory;

    @Before
    public void setUp() {
        guestFactory = new GuestActionFactory();
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
            Action test = guestFactory.createAction("seachQuestionsBy");
            assertTrue(test instanceof SeachQuestionByAction);
    }

    @Test
    public void testSignInAdminAction() throws InvalidActionException {
            Action test = guestFactory.createAction("signInAdmin");
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
        new GuestActionFactory().createAction("gianni");
    }

}