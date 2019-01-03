package it.blackhat.symposium.managers;

import java.sql.SQLException;
import java.util.Date;
//import java.util.Optional;

import org.apache.commons.dbutils.QueryRunner;

import static it.blackhat.symposium.queries.StatsQuery.*;

//import it.blackhat.symposium.models.Stats;

/**
 * @author Parrilli Carminantonio
 *
 */
public class StatsModelManager extends ConnectionManager implements StatsManager {

    @Override
    public int incrementSignedUpUsers(Date year) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        return run.update(INCREASE_COUNT, year);
    }

}
