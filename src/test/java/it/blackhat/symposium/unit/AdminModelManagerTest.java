package it.blackhat.symposium.unit;

import it.blackhat.symposium.managers.AdminModelManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Przemyslaw Szopian
 */
public class AdminModelManagerTest {
   
    /**
     * Test of findAdmin method, of class AdminModelManager.
     */
    @Test
    public void constractorEmpty(){
        AdminModelManager admin = new AdminModelManager();
        assertTrue(admin instanceof AdminModelManager);
    }
    
}
