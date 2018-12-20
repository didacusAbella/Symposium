package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Admin;
import java.sql.SQLException;
import java.util.Optional;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 *
 * @author Diego Avella
 */
public class AdminModelManager extends ConnectionManager implements AdminManager {

    @Override
	public Optional<Admin> findAdminBy(String username, String password) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);       
        BeanHandler<Admin> h = new BeanHandler<>(Admin.class);
        Admin result = run.query("" , h);
        return Optional.ofNullable(result);
    }

    @Override
    public boolean banUser(String email) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int rowMod = run.update("");
        if (rowMod == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Optional<String> genReport(String adminUsername) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        BeanHandler<String> h = new BeanHandler<>(String.class);
        String result = run.query("", h);
        return Optional.ofNullable(result);
    }
    
    
    
}
