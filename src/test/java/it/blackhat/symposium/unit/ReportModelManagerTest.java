package it.blackhat.symposium.unit;

import it.blackhat.symposium.managers.ReportModelManager;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.sql.DataSource;

/**
 * @Rayman
 */

public class ReportModelManagerTest {
@Test
public void constractorEmpty() {
    DataSource ds = Mockito.mock(BasicDataSource.class);
    ReportModelManager testConstrucorReport = new ReportModelManager(ds);
    Assert.assertTrue(testConstrucorReport instanceof ReportModelManager);
    }

}