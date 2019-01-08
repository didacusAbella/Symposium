package it.blackhat.symposium.integration;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import it.blackhat.symposium.managers.AnswerManager;
import it.blackhat.symposium.managers.AnswerModelManager;
import it.blackhat.symposium.models.Answer;
import it.blackhat.symposium.models.AnswerModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import it.blackhat.symposium.managers.StatsManager;
import it.blackhat.symposium.managers.StatsModelManager;
import it.blackhat.symposium.models.Stats;

/**
 *The testig class  for the methods of StatsModelManager
 * @author Gozzetto
 *
 */

public class AnswerModelManagerTest {
    private Calendar dataProva = Calendar.getInstance();
    private Date date;
    private AnswerManager testConstructor;

    @Before
    public void setUp() throws Exception {
        this.testConstructor = new AnswerModelManager(IntegrationTestSuite.mockDbDatasource);
        this.dataProva.set(2019, 1, 6);
        this.date = new Date(this.dataProva.getTime().getTime());
    }

    @Test
    public void testInsertAnswerCORRECT() throws SQLException {
        AnswerModel testAnswerModel = new AnswerModel(12, 19, "c.cicciolina@studenti.unisa.it", "Non si passa",date,true);
        int test = testConstructor.insertAnswer(testAnswerModel);
        Assert.assertEquals(1, test);
    }

    @Test @Ignore
    public void testInsertAnswerWRONG() throws SQLException {
        AnswerModel testAnswerModel = new AnswerModel(6, 19, "c.cicciolina@studenti.unisa.it", "Non si supera", date,true);
        int test = testConstructor.insertAnswer(testAnswerModel);
        Assert.assertEquals(0, test);
    }

    @Test
    public void testDeleteAnswerCORRECT() throws SQLException {
        int test = testConstructor.removeAnswer(6);
        Assert.assertEquals(1, test);
    }

    @Test
    public void testDeleteAnswerWRONG() throws SQLException {
        int test = testConstructor.removeAnswer(100);
        Assert.assertEquals(0, test);
    }

    @Test
    public void testBestAnswerCORRECT() throws SQLException {
        int test = testConstructor.bestAnswer(6);
        Assert.assertEquals(1, test);
    }
    @Test
    public void testBestAnswerWRONG() throws SQLException {
        int test = testConstructor.bestAnswer(100);
        Assert.assertEquals(0, test);
    }

    @Test
    public void testRetrieveQuestionAnswersCORRECT() throws SQLException {
        List<Answer> answers = testConstructor.retrieveQuestionAnswers(56);
        Assert.assertFalse(answers.isEmpty());
    }

    @Test
    public void testRetrieveQuestionAnswersWRONG() throws SQLException {
        List<Answer> answers = testConstructor.retrieveQuestionAnswers(100);
        Assert.assertTrue(answers.isEmpty());
    }

    @Test
    public void testRetrieveAllQuestionsCORRECT() throws SQLException {
        List<Answer> answers = testConstructor.retrieveAllQuestionAnswers();
        Assert.assertFalse(answers.isEmpty());
    }

}

