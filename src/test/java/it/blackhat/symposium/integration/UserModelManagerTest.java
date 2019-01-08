/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.blackhat.symposium.integration;

import it.blackhat.symposium.managers.UserManager;
import it.blackhat.symposium.managers.UserModelManager;
import it.blackhat.symposium.models.User;
import it.blackhat.symposium.models.UserModel;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Giuseppe Madonna
 */
public class UserModelManagerTest {
   
    private UserManager user;
    
    @Before
    public void setUp() {
        this.user = new UserModelManager(IntegrationTestSuite.mockDbDatasource);
    }

    /**
     * Test of editProfile method, of class UserModelManager.
     * @throws SQLException if the DB fail
     */
    @Test
    public void testEditProfileTrue() throws SQLException {
        User prova = new UserModel("GMadness","Giuseppe","Madonna","PinoDan","G.MADONNA3@studenti.unisa.it",2020);
        int result = this.user.editProfile(prova);
        Assert.assertEquals("Should be 1 ", 1, result);
    }
    /**
     * Test of editProfile method, of class UserModelManager.
     * @throws SQLException if the DB fail
     */
    @Test
    public void testEditProfileFail() throws SQLException {
        User prova = new UserModel("GMadness","Giuseppe","Madonna","PinoDan","GianniMorandiManiGrandi@studenti.unisa.it",2020);
        int result = this.user.editProfile(prova);
        Assert.assertEquals("Should be 0 ", 0, result);
    }

    /**
     * Test of deleteAccount method, of class UserModelManager.
     * @throws SQLException if the DB fail
     */
    @Test
    public void testDeleteAccountTrue() throws SQLException {
        User prova = new UserModel("Memo98171","Sandra","Marchigiano","password","p.szopian@studenti.unisa.it",2020);
        int result = this.user.deleteAccount(prova);
        Assert.assertEquals("Should be 1 ", 1, result);
    }
    /**
     * Test of deleteAccount method, of class UserModelManager
     * @throws SQLException if the DB fail
     */
    @Test
    public void testDeleteAccountFalse() throws SQLException {
        User prova = new UserModel("GMadness","Giuseppe","Madonna","PinoDan","GianniMorandiManiGrandi@studenti.unisa.it",2020);
        int result = this.user.deleteAccount(prova);
        Assert.assertEquals("Should be 0 ", 0, result);
    }
    /**
     * Test of findUser method, of class UserModelManager.
     * @throws SQLException if the DB fail
     */
    @Test
    public void testFindUserTrue() throws SQLException {
        Optional<User> userFounded = this.user.findUser("G.MADONNA3@studenti.unisa.it",DigestUtils.sha256Hex("PinoDan"));
        Assert.assertTrue(userFounded.isPresent());
    }

    /**
     * Test of findUser method, of class UserModelManager.
     * @throws SQLException if the DB fail
     */
    @Test
    public void testFindUserFalse() throws SQLException {
        Optional<User> userFounded = this.user.findUser("Gianni@studenti.unisa.it", DigestUtils.sha256Hex("ProvaFallita"));
        Assert.assertFalse(userFounded.isPresent());
    }
    
    /**
     * Test of findEmail method, of class UserModelManager.
     * @throws SQLException 
     */
    @Test
    public void testFindEmailTrue() throws SQLException {
        Optional<User> userFounded= this.user.findEmail("G.MADONNA3@studenti.unisa.it");
        Assert.assertTrue(userFounded.isPresent());
    }

    /**
     * Test of findEmail method, of class UserModelManager.
     * @throws SQLException 
     */
    @Test
    public void testFindEmailFalse() throws SQLException {
        Optional<User> userFounded= this.user.findEmail("Gianni@studenti.unisa.it");
        Assert.assertFalse(userFounded.isPresent());
    }
    
    /**
     * Test of createUser method, of class UserModelManager.
     * @throws SQLException if the DB fail
     */
    @Test
    public void testCreateUserTrue() throws SQLException {
        User prova = new UserModel("UserProva","Giuseppe","Madonna",DigestUtils.sha256Hex("PasswordProva"),"ProvaUser@studenti.unisa.it",2020);
        int usercreated = this.user.createUser(prova);
        Assert.assertEquals("Should be 1",1,usercreated);
    }
    
        /**
     * Test of createUser method, of class UserModelManager.
     * @throws SQLException if the test succed
     */
    @Test(expected=SQLException.class)
    public void testCreateUserFalse() throws SQLException {
        
        User prova = new UserModel("GMadness","Giuseppe","Madonna",DigestUtils.sha256Hex("PinoDan"),"G.MADONNA3@studenti.unisa.it",2020);
        int usercreated = this.user.createUser(prova);
        Assert.assertEquals("Should be 0",0,usercreated);
    }

    /**
     * Test of banUser method, of class UserModelManager.
     * @throws SQLException if the DB fail
     */
    @Test
    public void testBanUserTrue() throws SQLException {
        Calendar cal = Calendar.getInstance();
        cal.set(2020,10,2);
        Date date = new Date(cal.getTime().getTime());
        int banUser = this.user.banUser(date, "G.MADONNA3@studenti.unisa.it");
        Assert.assertEquals("Should be 1",1,banUser);
    }
    
    /**
     * Test of banUser method, of class UserModelManager.
     * @throws SQLException if the DB fail
     */
    @Test
    public void testBanUserFalse() throws SQLException {
        Calendar cal = Calendar.getInstance();
        cal.set(2020,10,2);
        Date date = new Date(cal.getTime().getTime());
        int banUser = this.user.banUser(date, "NonEsistente@studenti.unisa.it");
        Assert.assertEquals("Should be 0",0,banUser);
    }
    
    /**
     * Test of retrieveUsers method, of class UserModelManager.
     * @throws SQLException if the DB fail
     */
    @Test
    public void testRetrieveUsersTrue() throws SQLException {
        List<User> usersFounded = this.user.retrieveUsers();
        Assert.assertTrue(usersFounded.size()>0);
    }
        
    /**
     * Test of retrieveUsers method, of class UserModelManager.
     * @throws SQLException if the DB fail
     */
    @Test
    public void testRetrieveUsersFalse() throws SQLException {
        List<User> usersFounded = this.user.retrieveUsers();
        Assert.assertFalse(usersFounded.size()<0);
    }
}
