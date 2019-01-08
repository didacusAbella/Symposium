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
import it.blackhat.symposium.actions.user.BanAction;
import it.blackhat.symposium.actions.user.EditProfileAction;
import it.blackhat.symposium.actions.user.ShowEditProfileAction;
import it.blackhat.symposium.actions.user.ShowProfileAction;
import it.blackhat.symposium.actions.user.SignoutAction;
import it.blackhat.symposium.actions.user.UserActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

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
    public void testSignInAction() {
        try {
            Action test = guestFactory.createAction("signIn");
            assertTrue(test instanceof SigninAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testSignUpAction() {
        try {
            Action test = guestFactory.createAction("signUp");
            assertTrue(test instanceof SignupAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testSeachQuestionsByAction() {
        try {
            Action test = guestFactory.createAction("seachQuestionsBy");
            assertTrue(test instanceof SeachQuestionByAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testSignInAdminAction() {
        try {
            Action test = guestFactory.createAction("signInAdmin");
            assertTrue(test instanceof SigninAdminAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testShowQuestionAction() {
        try {
            Action test = guestFactory.createAction("showQuestion");
            assertTrue(test instanceof ShowQuestionAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }
    @Test
    public void testShowQuestionsAction() {
        try {
            Action test = guestFactory.createAction("showQuestions");
            assertTrue(test instanceof ShowQuestionsAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test(expected = InvalidActionException.class)
    public void createInvalidActionExceptionTest() throws InvalidActionException {
        new GuestActionFactory().createAction("gianni");
    }

}