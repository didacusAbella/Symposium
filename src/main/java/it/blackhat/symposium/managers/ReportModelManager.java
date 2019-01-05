package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Report;
import it.blackhat.symposium.models.ReportModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

import static it.blackhat.symposium.queries.ReportQuery.INSERT_REPORT;
import static it.blackhat.symposium.queries.ReportQuery.TAKE_REPORT;

/**
 * @author SDelPiano
 */

public class ReportModelManager extends ConnectionManager implements ReportManager {

    public int insertReport(Report report, Question question) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int upd = run.update(INSERT_REPORT, question.getNumReports(), report.getCategory(), report.getReason(),
                report.getYear(), report.getUserFk());
        return upd;
    }

    @Override
    public List<Report> retrieveReport(int questionFk) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        ResultSetHandler<List<Report>> j = new BeanListHandler<>(ReportModel.class);
        List<Report> report = run.query(TAKE_REPORT, j);
        return report;
    }
}