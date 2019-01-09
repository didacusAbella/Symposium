package it.blackhat.symposium.unit;

import java.sql.SQLException;

import it.blackhat.symposium.managers.AnswerModelManager;
import org.junit.Assert;
import org.junit.Test;

import it.blackhat.symposium.managers.StatsModelManager;
/**
 * The class test AnswerModelManager
 * @author Gozzetto
 *
 */
public class AnswerModelManagerTest {
    /**
     * The test for the empty constructor
     * @throws SQLException in case of error in the database
     */
    @Test
    public void testAnswerModelManager() throws SQLException {
        AnswerModelManager testConstuctor = new AnswerModelManager();
        Assert.assertTrue(testConstuctor instanceof AnswerModelManager);
    }

}
