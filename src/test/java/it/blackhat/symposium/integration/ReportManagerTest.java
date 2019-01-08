package it.blackhat.symposium.integration;

import it.blackhat.symposium.managers.ReportManager;
import it.blackhat.symposium.managers.ReportModelManager;
import it.blackhat.symposium.models.Report;
import it.blackhat.symposium.models.ReportModel;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ReportManagerTest {
    public ReportManager reportManager;

    @Before
    public void setUp() {
        this.reportManager = new ReportModelManager(IntegrationTestSuite.mockDbDatasource);
    }


    @Test
    public void insertReportTest() throws SQLException {
        Report report = new ReportModel();
    }

    @Test
    public List<Report> retrieveReport(int questionFk) throws SQLException {
        return null;
    }

    @Test
    public List<Report> retrieveAllReports() throws SQLException {
        return null;
    }

}
