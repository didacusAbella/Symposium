/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.blackhat.symposium.unit;

import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import java.sql.SQLException;
import org.junit.Assert;


/**
 *
 * @author Giuseppe Madonna
 */
public class UserModelManagerTest {
    
    public UserModelManagerTest() throws SQLException{
        UserManager testCostructorUser = new UserModelManager();
        Assert.assertTrue(testCostructorUser instanceof UserModelManager);
    }  
}
