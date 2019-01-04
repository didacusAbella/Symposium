package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.User;
import it.blackhat.symposium.models.UserModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static it.blackhat.symposium.queries.UserQuery.*;


public class UserModelManager extends ConnectionManager implements UserManager {

    @Override
    public int editProfile(User user) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(EDIT_PROFILE, user.getUsername(), user.getFirstName(),
                user.getLastName(), user.getPassword(), user.getTypeGrad(), user.getEmail());
        return update;
    }

    @Override
    public int deleteAccount(User user) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int update = run.update(DELETE_ACCOUNT, user.getEmail());
        return update;
    }

    @Override
    public Optional<User> findUser(String username, String pass) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        User found = run.query(SIGN_IN, new BeanHandler<>(UserModel.class), username, pass);
        return Optional.ofNullable(found);
    }

    @Override
    public Optional<User> findEmail(String email) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        User resp = run.query(FIND_EMAIL, new BeanHandler<>(UserModel.class), email);
        return Optional.ofNullable(resp);
    }

    @Override
    public int createUser(User user) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int create = run.update(SIGN_UP, user.getUsername(), user.getFirstName(),
                user.getLastName(), user.getEmail(), user.getPassword(), user.getTypeGrad());
        return create;
    }

    @Override
    public int banUser(Date time, String email) throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        int rowMod = run.update(BAN, time, email);
        return rowMod;

    }

    @Override
    public List<User> retrieveUsers() throws SQLException {
        QueryRunner run = new QueryRunner(this.dataSource);
        ResultSetHandler<List<User>> j = new BeanListHandler<>(UserModel.class);
        List<User> users = run.query(TAKE_ALL_USERS, j);
        return users;
    }
}