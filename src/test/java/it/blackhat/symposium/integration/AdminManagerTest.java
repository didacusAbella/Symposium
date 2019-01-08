package it.blackhat.symposium.integration;

import it.blackhat.symposium.managers.AdminManager;
import it.blackhat.symposium.managers.AdminModelManager;
import it.blackhat.symposium.models.Admin;
import java.sql.SQLException;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Symposium Group
 */
public class AdminManagerTest {
    
    private AdminManager adminManager;
    
    @Before
    public void setUp(){
        this.adminManager = new AdminModelManager(IntegrationTestSuite.mockDbDatasource);
    }
    
    @Test
    public void testFindAdminValid() throws SQLException {
        Optional<Admin> admin = this.adminManager.findAdmin("Supergoku", "P@ssw0rd");
        Assert.assertTrue(admin.isPresent());
    }
    
    @Test
    public void testFindAdminInvalid() throws SQLException {
        Optional<Admin> admin = this.adminManager.findAdmin("GiannoLoSa", "EinveceNo");
        Assert.assertFalse(admin.isPresent());                
    }
    
}
