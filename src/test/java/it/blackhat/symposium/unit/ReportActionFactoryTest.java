package it.blackhat.symposium.unit;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.report.ReportActionFactory;
import it.blackhat.symposium.actions.report.ReportQuestionAction;
import it.blackhat.symposium.actions.report.ShowInsertReportAction;
import it.blackhat.symposium.helpers.InvalidActionException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @Rayman
 */

public class ReportActionFactoryTest {
  
  private static DataSource ds;
  
    @BeforeClass
    public static final void setUpClass(){
      ds = Mockito.mock(BasicDataSource.class);
    }

    @Test
    public void reportQuestionActionTest() throws InvalidActionException {


        Action actionReportQuestion;
        actionReportQuestion = new ReportActionFactory(ds).createAction("insertReport");
        Assert.assertTrue(actionReportQuestion instanceof ReportQuestionAction);


    }

    @Test
    public void reportShowInsertReportActionTest() throws InvalidActionException {


        Action actionReportShowInsert;
        actionReportShowInsert = new ReportActionFactory(ds).createAction("showInsertReport");
        Assert.assertTrue(actionReportShowInsert instanceof ShowInsertReportAction);


    }

    @Test(expected = InvalidActionException.class)
    public void createInvalidActionExceptionTest() throws InvalidActionException {
        new ReportActionFactory(ds).createAction("raiolaDoctor");
    }
}