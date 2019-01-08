package it.blackhat.symposium.unit;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.answer.*;
import it.blackhat.symposium.helpers.InvalidActionException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;



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
    public void testInsertAnswerAction() throws InvalidActionException {
            Action test = answerFactory.createAction("insertAnswer");
            assertTrue(test instanceof InsertAnswerAction);
    }

    @Test
    public void testDeleteQuestionAction() throws InvalidActionException {
            Action test = answerFactory.createAction("deleteAnswer");
            assertTrue(test instanceof DeleteAnswerAction);
    }

    @Test
    public void testChooseBestAnswerAction() throws InvalidActionException {
            Action test = answerFactory.createAction("chooseBestAnswer");
            assertTrue(test instanceof ChooseBestAnswerAction);
    }

    @Test
    public void testDeleteAnswerAdminAction() throws InvalidActionException {
            Action test = answerFactory.createAction("deleteAnswerAdmin");
            assertTrue(test instanceof DeleteAnswerAdminAction);
    }

    @Test
    public void testShowAnswerPageAction() throws InvalidActionException {
            Action test = answerFactory.createAction("showAnswerPage");
            assertTrue(test instanceof ShowAnswerPage);
    }

    @Test(expected = InvalidActionException.class)
    public void createInvalidActionExceptionTest() throws InvalidActionException {
        new AnswerActionFactory().createAction("gianni");
    }

}