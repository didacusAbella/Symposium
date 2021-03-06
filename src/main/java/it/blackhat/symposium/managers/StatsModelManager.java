package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Stats;
import it.blackhat.symposium.models.StatsModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Optional;

import static it.blackhat.symposium.queries.StatsQuery.*;
import javax.sql.DataSource;

/**
 * The model manager for interacting with the database
 *
 * @author Parrilli Carminantonio
 *
 */
public class StatsModelManager extends ConnectionManager implements StatsManager {

  /**
   * Create a StatsManager with a specified DataSource
   *
   * @param ds the datasource object
   */
  public StatsModelManager(DataSource ds) {
    super(ds);
  }

  @Override
  public int getNumberUsers(int interestedYear) throws SQLException {
    QueryRunner run = new QueryRunner(this.dataSource); //TODO News scalar handler
    Long usersTotal = run.query(GET_NUM_USERS.toString(), new ScalarHandler<>(), interestedYear);
    return usersTotal.intValue();
  }

  @Override
  public int updateStatsTag(int year, String tagName) throws SQLException {
    QueryRunner run = new QueryRunner(this.dataSource);
    int statstag = run.update(UPDATE_STATSTAG.toString(), year, tagName);
    return statstag;
  }

  @Override
  public int getNumberReports(int interestedYear) throws SQLException {
    QueryRunner run = new QueryRunner(this.dataSource);
    Long numrep = run.query(GET_NUM_REPORTS.toString(), new ScalarHandler<>(), interestedYear);
    return numrep.intValue();
  }

  @Override
  public int createStats(int interestedYear) throws SQLException {
    QueryRunner run = new QueryRunner(this.dataSource);
    return run.execute(CREATE_STATS.toString(), getNumberUsers(interestedYear),
            getNumberReports(interestedYear), interestedYear);
  }

  @Override
  public Optional<Stats> getStats(int interestedYear) throws SQLException {
    QueryRunner run = new QueryRunner(this.dataSource);
    Stats temp = run.query(GET_STATS.toString(), new BeanHandler<>(StatsModel.class), 
            interestedYear);
    return Optional.ofNullable(temp);
  }

  @Override
  public int getBannedUsers(int interestedYear) throws SQLException {
    QueryRunner run = new QueryRunner(this.dataSource);
    Long temp = run.query(GET_BANNED_USERS.toString(), new ScalarHandler<>(), interestedYear);
    return temp.intValue();
  }
}
