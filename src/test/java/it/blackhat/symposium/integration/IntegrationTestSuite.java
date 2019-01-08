package it.blackhat.symposium.integration;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.RunScript;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author didacus
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    AdminManagerTest.class
})
public class IntegrationTestSuite {
    
    public static BasicDataSource mockDbDatasource;
    
    @BeforeClass
    public static void beforeClass() throws SQLException, FileNotFoundException {
        mockDbDatasource = new BasicDataSource();
        mockDbDatasource.setDriverClassName("org.h2.Driver");
        mockDbDatasource.setUrl("jdbc:h2:it./symposiumTest:symposiumdb1;MODE=MYSQL;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1");
        mockDbDatasource.setUsername("sa");
        mockDbDatasource.setPassword("");
        RunScript.execute(mockDbDatasource.getConnection(), 
                new FileReader(new File(IntegrationTestSuite.class.getResource("/dump.sql")
                        .getFile())));
    }
    
}
