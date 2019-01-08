package it.blackhat.symposium.unit;

import it.blackhat.symposium.managers.TagModelManager;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author SDelPiano
 */
public class TagModelManagerTest {

    @Test
    public void testTagModelManager() throws SQLException {
        DataSource ds = Mockito.mock(BasicDataSource.class);
        TagModelManager testCostructor = new TagModelManager(ds);
        Assert.assertTrue(testCostructor instanceof TagModelManager);
    }
}
