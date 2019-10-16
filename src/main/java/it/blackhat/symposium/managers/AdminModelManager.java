package it.blackhat.symposium.managers;

import it.blackhat.symposium.models.Admin;
import it.blackhat.symposium.models.AdminModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.Optional;

import static it.blackhat.symposium.queries.AdminQuery.SIGN_IN;
import javax.sql.DataSource;

/**
 * @author SDelPiano
 */
public class AdminModelManager extends ConnectionManager implements AdminManager {

  /**
   * Create an AdminManager with specified DataSource
   *
   * @param ds the DataSource
   */
  public AdminModelManager(DataSource ds) {
    super(ds);
  }

  @Override
  public Optional<Admin> findAdmin(String username, String password)
          throws SQLException {
    QueryRunner findQuery = new QueryRunner(this.dataSource);
    System.out.println("Username " + username + " Password " + password);
    Admin foundAdmin = findQuery.query(SIGN_IN,
            new BeanHandler<>(AdminModel.class), username, password);
    return Optional.ofNullable(foundAdmin);
  }
}
