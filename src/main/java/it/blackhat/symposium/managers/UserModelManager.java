package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.User;
import static it.blackhat.symposium.queries.UserQuery.*;
import java.sql.SQLException;
import java.util.Optional;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import it.blackhat.symposium.models.UserModel;

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
        int create = run.update(SIGN_UP,user.getUsername() , user.getFirstName(), user.getLastName(),
                user.getEmail() , user.getPassword(), user.getTypeGrad());
        return create;
    }

}
