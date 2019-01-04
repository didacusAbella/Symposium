package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Admin;
import it.blackhat.symposium.models.AdminModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.Optional;

import static it.blackhat.symposium.queries.AdminQuery.SIGN_IN;


/**
 * @author Diego Avella
 */
public class AdminModelManager extends ConnectionManager implements AdminManager {

    @Override
    public Optional<Admin> findAdmin(String username, String password)
            throws SQLException {
        QueryRunner findQuery = new QueryRunner(this.dataSource);
        System.out.println("Username "+username+" Password "+password);
        Admin foundAdmin = findQuery.query(SIGN_IN,
                new BeanHandler<>(AdminModel.class), username, password);
        return Optional.ofNullable(foundAdmin);
    }
}
