package it.blackhat.symposium.unit;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.actions.question.*;
import it.blackhat.symposium.helpers.InvalidActionException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QuestionActionFactoryTest {
    ActionFactory questionFactory;

    @Before
    public void setUp() {
        questionFactory = new QuestionActionFactory();
    }

    @Test
    public void testInsertQuestionAction() throws InvalidActionException {
        Action test = questionFactory.createAction("insertQuestion");
        assertTrue(test instanceof InsertQuestionAction);
    }

    @Test
    public void testDeleteQuestionAction() throws InvalidActionException {
        Action test = questionFactory.createAction("deleteQuestion");
        assertTrue(test instanceof DeleteQuestionAction);
    }

    @Test
    public void testDeleteQuestionAdminAction() throws InvalidActionException {
        Action test = questionFactory.createAction("deleteQuestionAdmin");
        assertTrue(test instanceof DeleteQuestionAdminAction);
    }


    @Test
    public void testSeachQuestionByAction() throws InvalidActionException {
        Action test = questionFactory.createAction("seachQuestionBy");
        assertTrue(test instanceof SeachQuestionByAction);
    }

    @Test
    public void testShowQuestionAction() throws InvalidActionException {
        Action test = questionFactory.createAction("showQuestion");
        assertTrue(test instanceof ShowQuestionAction);
    }

    @Test
    public void testShowQuestionByAuthorAction() throws InvalidActionException {
        Action test = questionFactory.createAction("showQuestionByAuthor");
        assertTrue(test instanceof ShowMyQuestion);
    }

    @Test
    public void testAddFavouriteAction() throws InvalidActionException {
        Action test = questionFactory.createAction("addFavourite");
        assertTrue(test instanceof AddFavouriteAction);
    }

    @Test
    public void testShowFavoriteAction() throws InvalidActionException {
        Action test = questionFactory.createAction("showFavorite");
        assertTrue(test instanceof ShowFavoriteAction);
    }

    @Test
    public void testShowNewQuestionAction() throws InvalidActionException {
        Action test = questionFactory.createAction("showNewQuestion");
        assertTrue(test instanceof ShowNewQuestionAction);
    }

    @Test
    public void testShowQuestionsAction() throws InvalidActionException {
        Action test = questionFactory.createAction("showQuestions");
        assertTrue(test instanceof ShowQuestionsAction);
    }

    @Test(expected = InvalidActionException.class)
    public void createInvalidActionExceptionTest() throws InvalidActionException {
        questionFactory.createAction("gianni");
    }

}