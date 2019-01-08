package it.blackhat.symposium.unit;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.answer.*;
import it.blackhat.symposium.helpers.InvalidActionException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * @author Gozzetto
 */
public class AnswerActionFactoryTest {
    ActionFactory answerFactory;

    @Before
    public void setUp() {
        answerFactory = new AnswerActionFactory();
    }

    @Test
    public void testInsertAnswerAction() {
        try {
            Action test = answerFactory.createAction("insertAnswer");
            assertTrue(test instanceof InsertAnswerAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testDeleteQuestionAction() {
        try {
            Action test = answerFactory.createAction("deleteAnswer");
            assertTrue(test instanceof DeleteAnswerAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testChooseBestAnswerAction() {
        try {
            Action test = answerFactory.createAction("chooseBestAnswer");
            assertTrue(test instanceof ChooseBestAnswerAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testDeleteAnswerAdminAction() {
        try {
            Action test = answerFactory.createAction("deleteAnswerAdmin");
            assertTrue(test instanceof DeleteAnswerAdminAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testShowAnswerPageAction() {
        try {
            Action test = answerFactory.createAction("showAnswerPage");
            assertTrue(test instanceof ShowAnswerPage);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test(expected = InvalidActionException.class)
    public void createInvalidActionExceptionTest() throws InvalidActionException {
        new AnswerActionFactory().createAction("gianni");
    }

}