package it.blackhat.symposium.unit;

import it.blackhat.symposium.models.User;
import it.blackhat.symposium.models.UserModel;
import java.sql.Date;
import java.util.Calendar;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Giuseppe Madonna
 */
public class UserModelTest {

  private User user;

  @Before
  public void setUp() {
    user = new UserModel("GMadness", "Giuseppe", "Madonna", "PinoDan", "GMadonna@studenti.unisa.it", 2019);
    user.setTypeGrad(true);
    Calendar cal = Calendar.getInstance();
    cal.set(2019, 10, 3);
    Date date = new Date(cal.getTime().getTime());
    user.setBanLastDate(date);
  }

  /**
   * Test of getUsername method, of class UserModel.
   */
  @Test
  public void testGetUsername() {
    user.setUsername("GMadness");
    String result = user.getUsername();
    assertEquals("Should return GMadness", "GMadness", result);
  }

  /**
   * Test of setUsername method, of class UserModel.
   */
  @Test
  public void testSetUsername() {
    user.setUsername("Tina");
    String result = user.getUsername();
    assertEquals("Should return Tina", "Tina", result);
  }

  /**
   * Test of getFirstName method, of class UserModel.
   */
  @Test
  public void testGetFirstName() {
    user.setFirstName("Giuseppe");
    String result = user.getFirstName();
    assertEquals("Should return Giuseppe", "Giuseppe", result);
  }

  /**
   * Test of setFirstName method, of class UserModel.
   */
  @Test
  public void testSetFirstName() {
    user.setFirstName("Giovanni");
    String result = user.getFirstName();
    assertEquals("Should return Giovanni", "Giovanni", result);
  }

  /**
   * Test of getLastName method, of class UserModel.
   */
  @Test
  public void testGetLastName() {
    user.setLastName("Madonna");
    String result = user.getLastName();
    assertEquals("Should return Madonna", "Madonna", result);
  }

  /**
   * Test of setLastName method, of class UserModel.
   */
  @Test
  public void testSetLastName() {
    user.setLastName("Maione");
    String result = user.getLastName();
    assertEquals("Should return Maione", "Maione", result);
  }

  /**
   * Test of getEmail method, of class UserModel.
   */
  @Test
  public void testGetEmail() {
    user.setEmail("GMadonna@studenti.unisa.it");
    String result = user.getEmail();
    assertEquals("Should return GMadonna@studenti.unisa.it", "GMadonna@studenti.unisa.it", result);
  }

  /**
   * Test of setEmail method, of class UserModel.
   */
  @Test
  public void testSetEmail() {
    user.setEmail("CMaione@studenti.unisa.it");
    String result = user.getEmail();
    assertEquals("Should return CMaione@studenti.unisa.it", "CMaione@studenti.unisa.it", result);
  }

  /**
   * Test of getPassword method, of class UserModel.
   */
  @Test
  public void testGetPassword() {
    user.setPassword("PinoDan");
    String result = user.getPassword();
    assertEquals("Should return PinoDan", "PinoDan", result);
  }

  /**
   * Test of setPassword method, of class UserModel.
   */
  @Test
  public void testSetPassword() {
    user.setPassword("Giggione");
    String result = user.getPassword();
    assertEquals("Should return Giggione", "Giggione", result);
  }

  /**
   * Test of getTypeGrad method, of class UserModel.
   */
  @Test
  public void testGetTypeGrad() {
    user.setTypeGrad(true);
    Boolean result = user.getTypeGrad();
    assertEquals("Should return true", true, result);
  }

  /**
   * Test of setTypeGrad method, of class UserModel.
   */
  @Test
  public void testSetTypeGrad() {
    user.setTypeGrad(false);
    Boolean result = user.getTypeGrad();
    assertEquals("Should return false", false, result);
  }

  /**
   * Test of getBanLastDate method, of class UserModel.
   */
  @Test
  public void testGetBanLastDate() {
    Calendar calget = Calendar.getInstance();
    calget.set(2019, 10, 3);
    Date date = new Date(calget.getTime().getTime());
    user.setBanLastDate(date);
    Date result = user.getBanLastDate();
    assertEquals("Should return 2019-10-03", date, result);
  }

  /**
   * Test of setBanLastDate method, of class UserModel.
   */
  @Test
  public void testSetBanLastDate() {
    Calendar setcal = Calendar.getInstance();
    setcal.set(2020, 11, 4);
    Date setDate = new Date(setcal.getTime().getTime());
    user.setBanLastDate(setDate);
    Date result = user.getBanLastDate();
    assertEquals("Should return 2020-11-04", setDate, result);
  }

  /**
   * Test of getYear method, of class UserModel.
   */
  @Test
  public void testGetYear() {
    user.setYear(2019);
    int result = user.getYear();
    assertEquals("Should return 2019", 2019, result);
  }

  /**
   * Test of setYear method, of class UserModel.
   */
  @Test
  public void testSetYear() {
    user.setYear(2020);
    int result = user.getYear();
    assertEquals("Should return 2020", 2020, result);
  }

  /**
   * Test of toString method, of class UserModel.
   */
  @Test
  public void testToString() {
    User prova = new UserModel("GMadness", "Giuseppe", "Madonna", "PinoDan", "GMadonna@studenti.unisa.it", 2019);
    prova.setTypeGrad(true);
    Calendar cal = Calendar.getInstance();
    cal.set(2019, 10, 3);
    Date date = new Date(cal.getTime().getTime());
    prova.setBanLastDate(date);
    String result = prova.toString();
    String resToString = "UserModel{"
            + "banLastDate=" + date
            + ", username='" + "GMadness" + '\''
            + ", firstName='" + "Giuseppe" + '\''
            + ", lastName='" + "Madonna" + '\''
            + ", password='" + "PinoDan" + '\''
            + ", email='" + "GMadonna@studenti.unisa.it" + '\''
            + ", typeGrad=" + true
            + '}';
    assertEquals(resToString, result);
  }
}
