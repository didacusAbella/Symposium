package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Admin;
import it.blackhat.symposium.models.AdminModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

import static it.blackhat.symposium.queries.AdminQuery.*;


/**
 * @author Diego Avella
 */
public class AdminModelManager extends ConnectionManager implements AdminManager {

    @Override
    public Optional<Admin> findAdmin(String username, String password)
            throws SQLException {
        QueryRunner findQuery = new QueryRunner(this.dataSource);
        Admin foundAdmin = findQuery.query(SIGN_IN,
                new BeanHandler<>(AdminModel.class), username, password);
        return Optional.ofNullable(foundAdmin);
    }

    @Override
    public int banUser(Date time, String email) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int rowMod = run.update(BAN, time, email);
        return rowMod;
    }

    @Override
    public Optional<String> genReport(String year) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        BeanHandler<String> h = new BeanHandler<>(String.class);
        String result = run.query(REPORT, h, year);
        return Optional.ofNullable(result);
    }

}
