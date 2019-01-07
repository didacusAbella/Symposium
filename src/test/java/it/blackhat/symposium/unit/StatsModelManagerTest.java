package it.blackhat.symposium.unit;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import it.blackhat.symposium.managers.StatsModelManager;
/**
 * The class test StatsModelManager
 * @author Parrilli Carminantonio
 *
 */
public class StatsModelManagerTest {
    /**
     * The test for the empty constructor
     * @throws SQLException in case of error in the database
     */
    @Test
    public void testStatsModelManager() throws SQLException {
        StatsModelManager testConstuctor = new StatsModelManager();
        Assert.assertTrue(testConstuctor instanceof StatsModelManager);
    }

}
