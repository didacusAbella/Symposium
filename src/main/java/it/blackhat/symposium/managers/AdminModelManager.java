package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Admin;
import it.blackhat.symposium.models.AdminModel;
import static it.blackhat.symposium.queries.AdminQuery.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Diego Avella
 */
public class AdminModelManager extends ConnectionManager implements AdminManager {

    @Override
    public Optional<Admin> findAdmin(String username, String password)
            throws SQLException {
        QueryRunner findQuery = new QueryRunner(this.dataSource);
        Admin foundAdmin = findQuery.query(FIND_ADMIN,
                new BeanHandler<>(AdminModel.class), username, password);
        return Optional.ofNullable(foundAdmin);
    }

    @Override
    public Optional<Admin> createAdmin(Admin admin) throws SQLException {
        QueryRunner insertQuery = new QueryRunner(this.dataSource);
        Admin createdAdmin = insertQuery.insert(ADD_ADMIN, new BeanHandler<>(AdminModel.class),
                admin.getUsername(), admin.getPassword());
        return Optional.ofNullable(createdAdmin);
    }

    @Override
    public int updateAdmin(Admin admin) throws SQLException {
        QueryRunner updateQuery = new QueryRunner(this.dataSource);
        int updatedAdmins = updateQuery.update(UPDATE_ADMIN, admin.getPassword(),
                admin.getUsername());
        return updatedAdmins;
    }

    @Override
    public int deleteAdmin(Admin admin) throws SQLException {
        QueryRunner deleteQuery = new QueryRunner(this.dataSource);
        int deletedAdmins = deleteQuery.update(DELETE_ADMIN, admin.getUsername());
        return deletedAdmins;
    }

    @Override
    public List<Admin> findAllAdmins() throws SQLException {
        QueryRunner adminsQuery = new QueryRunner(this.dataSource);
        List<Admin> admins = adminsQuery.query(ALL_ADMINS, new BeanListHandler<>(AdminModel.class));
        return admins;
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
