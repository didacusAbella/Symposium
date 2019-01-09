package it.blackhat.symposium.integration;

import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.QuestionModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuestionManagerTest extends IntegrationTestCase {
    private QuestionManager questionManager;
    private Date testDate = new Date(Calendar.getInstance().getTime().getTime());

    @Before
    public void setUp() throws SQLException, FileNotFoundException {
        super.setUp();
        questionManager = new QuestionModelManager(IntegrationTestCase.mockDbDatasource);
    }

    @Test
    public void testSeachQuestionsByTagValid() throws SQLException {
        List<Question> test = questionManager.seachQuestionsByTag("Android");
        assertEquals(false, test.isEmpty());
    }

    @Test
    public void testSeachQuestionsByTagInvalid() throws SQLException {
        List<Question> test = questionManager.seachQuestionsByTag("gianni");
        assertEquals(true, test.isEmpty());
    }

    @Test
    public void testSeachQuestionsByWordValid() throws SQLException {
        List<Question> test = questionManager.seachQuestionByWords("Ferrucci");
        assertEquals(false, test.isEmpty());
    }

    @Test
    public void testSeachQuestionsByWordInvalid() throws SQLException {
        List<Question> test = questionManager.seachQuestionByWords("gianni");
        assertEquals(true, test.isEmpty());
    }

    @Ignore
    public void testInsertQuestionValid() throws SQLException {
        Question question = new QuestionModel("Posso superare IS",
                "Posso superare IS io ci credo", "d.tropeano@studenti.unisa.it",
                testDate, testDate, 302, 0);
        int test = questionManager.insertQuestion(question);
        assertTrue(test > 0);
    }

    @Ignore
    public void testInsertQuestionInvalid() throws SQLException {
        Question question = new QuestionModel("Posso superare IS",
                "Posso superare IS io ci credo", "d.tropeano@studenti.unisa.it",
                testDate, testDate, 302, 0);
        int test = questionManager.insertQuestion(question);
        assertEquals("1", test); //TEST NON FUNGE
    }

    @Test
    public void testDeleteQuestionValid() throws SQLException {
        int test = questionManager.deleteQuestion(21);
        assertEquals(true, test > 0);
    }

    @Test
    public void testDeleteQuestionInvalid() throws SQLException {
        int test = questionManager.deleteQuestion(900);
        assertEquals(false, test > 0);
    }

    @Test
    public void testDeleteQuestionTagValid() throws SQLException {
        int test = questionManager.deleteQuestionTag(21);
        assertEquals(true, test > 0);
    }

    @Test
    public void testDeleteQuestionTagInvalid() throws SQLException {
        int test = questionManager.deleteQuestionTag(900);
        assertEquals(false, test > 0);
    }

    @Test
    public void addFavouriteValid() throws SQLException {
        int test = questionManager.addFavourite("d.tropeano@studenti.unisa.it",19);
        assertEquals(1, test);

    }

    @Test (expected=SQLException.class)
    public void addFavouriteInvalid() throws SQLException {
        int test = questionManager.addFavourite("d.tropeano@studenti.unisa.it",1000);

    }

    @Test
    public void findFavoriteValid() throws SQLException {
        List<Question> list = questionManager.findFavorite("d.tropeano@studenti.unisa.it");
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void findFavoriteInvalid() throws SQLException {
        List<Question> list = questionManager.findFavorite("g.gianni11@studenti.unisa.it");
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void showLastEditValid() throws SQLException {
        List<Question> list = questionManager.showLastEdit();
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void showQuestionsByAuthorValid() throws SQLException {
        List<Question> list = questionManager.showQuestionsByAuthor("d.tropeano@studenti.unisa.it");
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void showQuestionsByAuthorInvalid() throws SQLException {
        List<Question> list = questionManager.showQuestionsByAuthor("s.saaaaa@studenti.unisa.it");
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void findQuestionValid() throws SQLException {
        Optional<Question> question = questionManager.findQuestion(28);
        Assert.assertTrue(question.isPresent());
    }

    @Test
    public void findQuestionInvalid() throws SQLException {
        Optional<Question> question = questionManager.findQuestion(1000);
        Assert.assertFalse(question.isPresent());
    }
}