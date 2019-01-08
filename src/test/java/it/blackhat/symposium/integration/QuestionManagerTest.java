package it.blackhat.symposium.integration;

import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.QuestionModel;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuestionManagerTest {
    private QuestionManager questionManager;
    private Date testDate = new Date(Calendar.getInstance().getTime().getTime());

    @Before
    public void setUp() {
        questionManager = new QuestionModelManager(IntegrationTestSuite.mockDbDatasource);
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
        assertEquals("1", test); //TEST NON FUNGE
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

    @Ignore
    public void testChangeQuestionTagValid() {

    }

    @Ignore
    public void testChangeQuestionTagInvalid() {
    }

    @Test
    public void addFavourite() {
    }

    @Test
    public void findFavorite() {
    }

    @Test
    public void showLastEdit() {
    }

    @Test
    public void showQuestionsByAuthor() {
    }

    @Test
    public void findQuestion() {
    }
}