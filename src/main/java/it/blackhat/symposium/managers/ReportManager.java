package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Question;
import it.blackhat.symposium.models.Report;

import java.sql.SQLException;
import java.util.List;

/**
 * This class describes the Report Manager's method
 *
 * @author SDelPiano
 */

public interface ReportManager {
    /**
     * Add a report to a question
     *
     * @param report   report data
     * @param question question to update the report's number
     * @return true if the operation go well, false otherwise
     * @throws SQLException if it encounter an error
     **/
    int insertReport(Report report, Question question) throws SQLException;

    /**
     * Retrieves all answers related to a question
     *
     * @param questionFk the questionId for retrieve the reports
     * @return a List of tags related to the reports
     * @throws SQLException if db error occurred
     */
    List<Report> retrieveReport(int questionFk) throws SQLException;


}
