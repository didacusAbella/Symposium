package it.blackhat.symposium.integration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.RunScript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;

public class IntegrationTestCase {

    public static BasicDataSource mockDbDatasource;

    @Before
    public void setUp() throws SQLException, FileNotFoundException {
        mockDbDatasource = new BasicDataSource();
        mockDbDatasource.setDriverClassName("org.h2.Driver");
        mockDbDatasource.setUrl("jdbc:h2:./symposiumTest;MODE=MYSQL;DATABASE_TO_UPPER=false;");
        mockDbDatasource.setUsername("sa");
        mockDbDatasource.setPassword("");
        RunScript.execute(mockDbDatasource.getConnection(),
                new FileReader(new File(IntegrationTestCase.class.getResource("/dump.sql")
                        .getFile())));
    }

    @After
    public void tearDown() throws SQLException {
        mockDbDatasource.getConnection()
                .createStatement().execute("drop all objects delete files");
    }

}
