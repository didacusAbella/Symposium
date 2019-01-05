package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Stats;
import it.blackhat.symposium.models.StatsModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Optional;

import static it.blackhat.symposium.queries.StatsQuery.*;

//import it.blackhat.symposium.models.Stats;

/**
 * The model manager for interacting with the database
 * @author Parrilli Carminantonio
 *
 */
public class StatsModelManager extends ConnectionManager implements StatsManager {
    @Override
    public int getNumberUsers(int interestedYear) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource); //TODO News scalar handler
        int usersTotal = run.query(GET_NUM_USERS, new ScalarHandler<Integer>(), interestedYear);
        return usersTotal;
    }

    @Override
    public int updateStatsTag(int year, String tagName) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int statstag = run.update(UPDATE_STATSTAG, year, tagName);
        return statstag;
    }
    @Override
    public int getNumberReports(int interestedYear) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        return run.query(GET_NUM_REPORTS, new ScalarHandler<Integer>(), interestedYear);
    }
    @Override
    public int createStats(int interestedYear) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        return run.execute(CREATE_STATS, interestedYear);
    }
    @Override
    public Optional<Stats> getStats(int interestedYear) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        Stats temp = run.query(GET_STATS, new BeanHandler<>(StatsModel.class), interestedYear);
        return Optional.ofNullable(temp);
    }
    @Override
    public int getBannedUsers(int interestedYear) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int temp = run.query(GET_BANNED_USERS, new ScalarHandler<Integer>(), interestedYear);
        return temp;
    }
}
