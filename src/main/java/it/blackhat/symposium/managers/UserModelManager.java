package it.blackhat.symposium.managers;

import java.sql.SQLException;
import java.util.Optional;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import it.blackhat.symposium.models.User;

public class UserModelManager extends ConnectionManager implements UserManager {

    @Override
    public int editProfile(User user) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update =  run.update("", user.getUsername());
        return update;
    }

    @Override
    public int deleteAccount(User user) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update("", user.getEmail());
        return update;
    }

    @Override
    public Optional<User> findUser(User user) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        User found = run.query("", new BeanHandler<>(User.class), "");
        return Optional.ofNullable(found);
    }

    @Override
    public Optional<User> createUser(User user) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        User create = run.query("", new BeanHandler<>(User.class), "");
        return Optional.ofNullable(create);
    }

}
