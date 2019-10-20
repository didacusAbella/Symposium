package it.blackhat.symposium.unit.models;

import it.blackhat.symposium.models.Admin;
import it.blackhat.symposium.models.AdminModel;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Przemyslaw Szopian
 */
public class AdminModelTest {

  private Admin admin;

  @Before
  public void setUp() {
    admin = new AdminModel(1, "Amministratore", "password");
  }

  /**
   * Test of getId method, of class AdminModel.
   */
  @Test
  public void constructorEmpty() {
    AdminModel admin1 = new AdminModel();
    assertTrue(admin1 instanceof AdminModel);
  }

  @Test
  public void constructorFull() {
    AdminModel admin1 = new AdminModel(3, "Blackhat", "Symposium");
    boolean b1 = 3 == admin1.getId();
    boolean b2 = "Blackhat".equals(admin1.getUsername());
    boolean b3 = "Symposium".equals(admin1.getPassword());
    boolean bFinal = b1 && b2 && b3;
    Assert.assertTrue(bFinal);
  }

  @Test
  public void testGetId() {
    assertEquals(1, admin.getId());
  }

  /**
   * Test of setId method, of class AdminModel.
   */
  @Test
  public void testSetId() {
    int id = 2;
    admin.setId(id);
    assertEquals(2, admin.getId());
  }

  /**
   * Test of getUsername method, of class AdminModel.
   */
  @Test
  public void testGetUsername() {
    assertEquals("Amministratore", admin.getUsername());
  }

  /**
   * Test of setUsername method, of class AdminModel.
   */
  @Test
  public void testSetUsername() {
    admin.setUsername("Symposium");
    assertEquals("Symposium", admin.getUsername());
  }

  /**
   * Test of getPassword method, of class AdminModel.
   */
  @Test
  public void testGetPassword() {
    assertEquals("password", admin.getPassword());
  }

  /**
   * Test of setPassword method, of class AdminModel.
   */
  @Test
  public void testSetPassword() {
    admin.setPassword("pincopallino");
    assertEquals("pincopallino", admin.getPassword());
  }

  /**
   * Test of equals method, of class AdminModel.
   */
  @Test
  public void testEquals() {
    Object obj = null;
    assertEquals(false, admin.equals(obj));
  }

  /**
   * Test of toString method, of class AdminModel.
   */
  @Test
  public void testToString() {
    assertEquals("AdminModel{username=Amministratore, password=password}", admin.toString());
  }
}
