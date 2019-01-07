package it.blackhat.symposium.unit;

import org.junit.Assert;
import org.junit.Test;

import it.blackhat.symposium.models.StatsModel;
/**
 * The class tests StatsModelTest
 * @author Parrilli Carminantonio
 *
 */
public class StatsModelTest {
    /**
     * The test for the empty constructor
     */
    @Test
    public void testStatsModelEmpty() {
        StatsModel testStatsModel = new StatsModel();
        Assert.assertTrue(testStatsModel instanceof StatsModel);
    }
    /**
     * The test for the full constructor
     */
    @Test
    public void testStatsModelFull() {
        StatsModel testStatsModel = new StatsModel(12, 23, 45, 67);
        boolean b1 = (12==testStatsModel.getId());
        boolean b2 = (23==testStatsModel.getNumSigned());
        boolean b3 = (45==testStatsModel.getTotalReports());
        boolean b4 = (67==testStatsModel.getYear());
        boolean bTot= b1&&b2&&b3&&b4;
        Assert.assertTrue(bTot);
    }
    /**
     * The test for GetId
     */
    @Test
    public void testGetId() {
        StatsModel testStat = new StatsModel();
        testStat.setId(17);
        Assert.assertEquals(17, testStat.getId());
    }
    /**
     * the test for SetId
     */
    @Test
    public void testSetId() {
        StatsModel testStat= new StatsModel();
        testStat.setId(13);
        Assert.assertEquals(13, testStat.getId());
    }
    /**
     * the test for GetNumSigned
     */
    @Test
    public void testGetNumSigned() {
        StatsModel testStat= new StatsModel();
        testStat.setNumSigned(10);
        Assert.assertEquals(10, testStat.getNumSigned());
    }
    /**
     * the test for SetNumSigned
     */
    @Test
    public void testSetNumSigned() {
        StatsModel testStat= new StatsModel();
        testStat.setNumSigned(50);
        Assert.assertEquals(50, testStat.getNumSigned());
    }
    /**
     * the test for GetTotalReports
     */
    @Test
    public void testGetTotalReports() {
        StatsModel testStat= new StatsModel();
        testStat.setTotalReports(0);
        Assert.assertEquals(0, testStat.getTotalReports());
    }
    /**
     * the test for SetTotalReports
     */
    @Test
    public void testSetTotalReports() {
        StatsModel testStat= new StatsModel();
        testStat.setTotalReports(14);
        Assert.assertEquals(14, testStat.getTotalReports());
    }
    /**
     * the test for GetYear
     */
    @Test
    public void testGetYear() {
        StatsModel testStat= new StatsModel();
        testStat.setYear(2020);
        Assert.assertEquals(2020, testStat.getYear());
    }
    /**
     * the test for SetYear
     */
    @Test
    public void testSetYear() {
        StatsModel testStat= new StatsModel();
        testStat.setYear(2019);
        Assert.assertEquals(2019, testStat.getYear());
    }
    /**
     * the test for ToString
     */
    @Test
    public void testToString() {
        StatsModel testStat= new StatsModel(98,76,54,32);
        Assert.assertEquals("id=98, numSigned=76, totalReports=54, year=32}", testStat.toString());
    }   
}
