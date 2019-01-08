package it.blackhat.symposium.unit;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.report.ReportActionFactory;
import it.blackhat.symposium.actions.report.ReportQuestionAction;
import it.blackhat.symposium.actions.report.ShowInsertReportAction;
import it.blackhat.symposium.helpers.InvalidActionException;
import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @Rayman
 */

public class ReportActionFactoryTest {

    @Test
    public void reportQuestionActionTest() throws InvalidActionException {


            Action actionReportQuestion;
            actionReportQuestion = new ReportActionFactory().createAction("insertReport");
            Assert.assertTrue(actionReportQuestion instanceof ReportQuestionAction);


    }

    @Test
    public void reportShowInsertReportActionTest() throws InvalidActionException {


        Action actionReportShowInsert;
        actionReportShowInsert = new ReportActionFactory().createAction("showInsertReport");
        Assert.assertTrue(actionReportShowInsert instanceof ShowInsertReportAction);


    }

    @Test(expected = InvalidActionException.class)
    public void createInvalidActionExceptionTest() throws InvalidActionException {
        new ReportActionFactory().createAction("raiolaDoctor");
    }
}