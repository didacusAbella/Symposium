package it.blackhat.symposium.unit;

import it.blackhat.symposium.managers.ReportModelManager;
import org.junit.Assert;

import java.sql.SQLException;

public class ReportModelManagerTest {

    public ReportModelManagerTest() throws SQLException {
        ReportModelManager testConstrucorReport = new ReportModelManager();
        Assert.assertTrue(testConstrucorReport instanceof ReportModelManager);
    }
}