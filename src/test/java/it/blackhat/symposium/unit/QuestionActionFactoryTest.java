package it.blackhat.symposium.unit;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.question.*;
import it.blackhat.symposium.helpers.InvalidActionException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class QuestionActionFactoryTest {
    ActionFactory questionFactory;

    @Before
    public void setUp() {
        questionFactory = new QuestionActionFactory();
    }

    @Test
    public void testInsertQuestionAction() {
        try {
            Action test = questionFactory.createAction("insertQuestion");
            assertTrue(test instanceof InsertQuestionAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testDeleteQuestionAction() {
        try {
            Action test = questionFactory.createAction("deleteQuestion");
            assertTrue(test instanceof DeleteQuestionAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testDeleteQuestionAdminAction() {
        try {
            Action test = questionFactory.createAction("deleteQuestionAdmin");
            assertTrue(test instanceof DeleteQuestionAdminAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testModifyTagQuestionAdminAction() {
        try {
            Action test = questionFactory.createAction("modifyTagQuestionAdmin");
            assertTrue(test instanceof ModifyTagQuestionAdminAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testSeachQuestionByAction() {
        try {
            Action test = questionFactory.createAction("seachQuestionBy");
            assertTrue(test instanceof SeachQuestionByAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testShowQuestionAction() {
        try {
            Action test = questionFactory.createAction("showQuestion");
            assertTrue(test instanceof ShowQuestionAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testShowQuestionByAuthorAction() {
        try {
            Action test = questionFactory.createAction("showQuestionByAuthor");
            assertTrue(test instanceof ShowMyQuestion);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testAddFavouriteAction() {
        try {
            Action test = questionFactory.createAction("addFavourite");
            assertTrue(test instanceof AddFavouriteAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testShowFavoriteAction() {
        try {
            Action test = questionFactory.createAction("showFavorite");
            assertTrue(test instanceof ShowFavoriteAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testShowNewQuestionAction() {
        try {
            Action test = questionFactory.createAction("showNewQuestion");
            assertTrue(test instanceof ShowNewQuestionAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test
    public void testShowQuestionsAction() {
        try {
            Action test = questionFactory.createAction("showQuestions");
            assertTrue(test instanceof ShowQuestionsAction);
        } catch (InvalidActionException e) {
            fail("Eccezione non gestita");
        }
    }

    @Test(expected = InvalidActionException.class)
    public void createInvalidActionExceptionTest() throws InvalidActionException {
        new QuestionActionFactory().createAction("gianni");
    }

}