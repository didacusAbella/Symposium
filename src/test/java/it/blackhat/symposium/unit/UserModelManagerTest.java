/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.blackhat.symposium.unit;

import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


/**
 *
 * @author Giuseppe Madonna
 */
public class UserModelManagerTest {
    
    @Test
    public void UserModelManagerConstructorTest() throws SQLException{
        DataSource ds = Mockito.mock(BasicDataSource.class);
        UserManager testCostructorUser = new UserModelManager(ds);
        Assert.assertTrue(testCostructorUser instanceof UserModelManager);
    }  
}
