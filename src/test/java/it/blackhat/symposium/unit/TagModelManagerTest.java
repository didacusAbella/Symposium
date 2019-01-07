package it.blackhat.symposium.unit;

import it.blackhat.symposium.managers.TagModelManager;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author SDelPiano
 */
public class TagModelManagerTest {

    @Test
    public void testTagModelManager() throws SQLException {
        TagModelManager testCostructor = new TagModelManager();
        Assert.assertTrue(testCostructor instanceof TagModelManager);
    }
}
