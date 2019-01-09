package it.blackhat.symposium.integration;

import java.sql.SQLException;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import it.blackhat.symposium.managers.StatsManager;
import it.blackhat.symposium.managers.StatsModelManager;
import it.blackhat.symposium.models.Stats;

/**
 *The testig class  for the methods of StatsModelManager
 * @author Parrilli Carminantonio
 *
 */

public class StatsModelManagerDBTest {
    private StatsManager testConstructor;
    @Before
    public void setUp() throws Exception {
        this.testConstructor = new StatsModelManager(IntegrationTestSuite.mockDbDatasource);
    }

    @Test
    public void testGetNumberUsersCORRECT() throws SQLException {
        int test = testConstructor.getNumberUsers(2019);
        Assert.assertEquals(5, test);
    }
    
    @Test
    public void testGetNumberUsersWRONG() throws SQLException {
        int test = testConstructor.getNumberUsers(1990);
        Assert.assertEquals(0, test);
    }

    @Test @Ignore
    public void testUpdateStatsTagCORRECT() throws SQLException {
        int test = testConstructor.updateStatsTag(2019, "esame");
        Assert.assertEquals(1, test);
    }
    
    @Test (expected = SQLException.class)
    public void testUpdateStatsTagWRONG() throws SQLException {
        int test = testConstructor.updateStatsTag(1990, "Carminantonio");
    }

    @Test
    public void testGetNumberReportsCORRECT() throws SQLException {
        int test = testConstructor.getNumberReports(2019);
        Assert.assertEquals(3, test);
    }
    
    @Test
    public void testGetNumberReportsWRONG() throws SQLException {
        int test = testConstructor.getNumberReports(1990);
        Assert.assertEquals(0, test);
    }

    @Test
    public void testCreateStatsCORRECT() throws SQLException {
        testConstructor.createStats(2020);
        Assert.assertTrue( testConstructor.getStats(2020).isPresent());
    }
    
    @Test(expected =  SQLException.class)
    public void testCreateStatsWRONG() throws SQLException {
       testConstructor.createStats(2018);
    }
    
    @Test
    public void testGetStatsCORRECT() throws SQLException {
        Optional<Stats> test = testConstructor.getStats(2019);
        Assert.assertTrue(test.isPresent());
    }
    
    @Test
    public void testGetStatsWRONG() throws SQLException {
        Optional<Stats> test = testConstructor.getStats(1990);
        Assert.assertFalse(test.isPresent());
    }

    @Test
    public void testGetBannedUsersCORRECT() throws SQLException {
        int test = testConstructor.getBannedUsers(2018);
        Assert.assertEquals(2, test);
    }
    
    @Test
    public void testGetBannedUsersWRONG() throws SQLException {
        int test = testConstructor.getBannedUsers(2300);
        Assert.assertEquals(0, test);
    }

}
