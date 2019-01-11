package it.blackhat.symposium.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Giuseppe Madonna
 */
public class TestUserEditProfile  extends SystemTestCase{
    
    private static WebDriver driver;
    
    @Before
    public void setUp(){
        driver = SystemTestCase.seleniumDriver;
    }
    
    @Test
    public void testEditProfileUserTRUE(){
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("g.madonna3@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("PinoDan");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/editProfile.jsp");
        WebElement firstname = driver.findElements(By.name("firstName")).get(0);
        firstname.clear();
        firstname.sendKeys("Giovanni");
        WebElement lastname = driver.findElements(By.name("lastName")).get(0);
        lastname.clear();
        lastname.sendKeys("Maione");
        WebElement password = driver.findElements(By.name("password")).get(0);
        password.clear();
        password.sendKeys("PinoDan");
        WebElement username = driver.findElements(By.name("username")).get(0);
        username.clear();
        username.sendKeys("GMaione");        
        WebElement formEdit = driver.findElement(By.name("editForm"));
        formEdit.submit();
        boolean changed = driver.getPageSource().contains("GMaione");
        Assert.assertTrue(changed);
    }
        
    @Test
    public void testEditProfileUserUSERNAMETOOSHORT(){
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("g.madonna3@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("PinoDan");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/editProfile.jsp");
        WebElement firstname = driver.findElements(By.name("firstName")).get(0);
        firstname.clear();
        firstname.sendKeys("Giovanni");
        WebElement lastname = driver.findElements(By.name("lastName")).get(0);
        lastname.clear();
        lastname.sendKeys("Maione");
        WebElement password = driver.findElements(By.name("password")).get(0);
        password.clear();
        password.sendKeys("PinoDan");
        WebElement username = driver.findElements(By.name("username")).get(0);
        username.clear();
        username.sendKeys("GM");        
        WebElement check = driver.findElements(By.name("typeGrad")).get(0);
        check.sendKeys(Keys.SPACE);
        WebElement formEdit = driver.findElement(By.name("editForm"));
        formEdit.submit();
        boolean changed = driver.getPageSource().contains("Error400");
        Assert.assertTrue(changed);
    }
    
    @Test
    public void testEditProfileUserFORMATWRONG(){
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("g.madonna3@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("PinoDan");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/editProfile.jsp");
        WebElement firstname = driver.findElements(By.name("firstName")).get(0);
        firstname.clear();
        firstname.sendKeys("Giovanni");
        WebElement lastname = driver.findElements(By.name("lastName")).get(0);
        lastname.clear();
        lastname.sendKeys("Maione");
        WebElement password = driver.findElements(By.name("password")).get(0);
        password.clear();
        password.sendKeys("PinoDan");
        WebElement username = driver.findElements(By.name("username")).get(0);
        username.clear();
        username.sendKeys("G.Maione");        
        WebElement check = driver.findElements(By.name("typeGrad")).get(0);
        check.sendKeys(Keys.SPACE);
        WebElement formEdit = driver.findElement(By.name("editForm"));
        formEdit.submit();
        boolean changed = driver.getPageSource().contains("G.Maione");
        Assert.assertFalse(changed);
    }
    
    @Test
    public void testEditProfileUserUSERNAMETOOLONG(){
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("g.madonna3@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("PinoDan");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/editProfile.jsp");
        WebElement firstname = driver.findElements(By.name("firstName")).get(0);
        firstname.clear();
        firstname.sendKeys("Giovanni");
        WebElement lastname = driver.findElements(By.name("lastName")).get(0);
        lastname.clear();
        lastname.sendKeys("Maione");
        WebElement password = driver.findElements(By.name("password")).get(0);
        password.clear();
        password.sendKeys("PinoDan");
        WebElement username = driver.findElements(By.name("username")).get(0);
        username.clear();
        username.sendKeys("GMaioneINCREDIBILMENTELUNGOWOWSPETTACOLARE");        
        WebElement check = driver.findElements(By.name("typeGrad")).get(0);
        check.sendKeys(Keys.SPACE);
        WebElement formEdit = driver.findElement(By.name("editForm"));
        formEdit.submit();
        boolean changed = driver.getPageSource().contains("GMaioneINCREDIBILMENTELUNGOWOWSPETTACOLARE");
        Assert.assertFalse(changed);
    }
    
    @Test
    public void testEditProfileUserFIRSTNAMETOOSHORT(){
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("g.madonna3@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("PinoDan");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/editProfile.jsp");
        WebElement firstname = driver.findElements(By.name("firstName")).get(0);
        firstname.clear();
        firstname.sendKeys("Gi");
        WebElement lastname = driver.findElements(By.name("lastName")).get(0);
        lastname.clear();
        lastname.sendKeys("Maione");
        WebElement password = driver.findElements(By.name("password")).get(0);
        password.clear();
        password.sendKeys("PinoDan");
        WebElement username = driver.findElements(By.name("username")).get(0);
        username.clear();
        username.sendKeys("GMaione");        
        WebElement check = driver.findElements(By.name("typeGrad")).get(0);
        check.sendKeys(Keys.SPACE);
        WebElement formEdit = driver.findElement(By.name("editForm"));
        formEdit.submit();
        boolean changed = driver.getPageSource().contains("Error400");
        Assert.assertTrue(changed);
    }
        
    @Test
    public void testEditProfileUserLASTNAMETOOSHORT(){
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("g.madonna3@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("PinoDan");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/editProfile.jsp");
        WebElement firstname = driver.findElements(By.name("firstName")).get(0);
        firstname.clear();
        firstname.sendKeys("Giovanni");
        WebElement lastname = driver.findElements(By.name("lastName")).get(0);
        lastname.clear();
        lastname.sendKeys("Ma");
        WebElement password = driver.findElements(By.name("password")).get(0);
        password.clear();
        password.sendKeys("PinoDan");
        WebElement username = driver.findElements(By.name("username")).get(0);
        username.clear();
        username.sendKeys("GMaione");        
        WebElement check = driver.findElements(By.name("typeGrad")).get(0);
        check.sendKeys(Keys.SPACE);
        WebElement formEdit = driver.findElement(By.name("editForm"));
        formEdit.submit();
        boolean changed = driver.getPageSource().contains("Error400");
        Assert.assertTrue(changed);
    }
    
    @Test
    public void testEditProfileUserFIRSTNAMETOOLONG(){
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("g.madonna3@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("PinoDan");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/editProfile.jsp");
        WebElement firstname = driver.findElements(By.name("firstName")).get(0);
        firstname.clear();
        firstname.sendKeys("GiovanniINCREDIBILMENTELUNGOWOWSPETTACOLARE");
        WebElement lastname = driver.findElements(By.name("lastName")).get(0);
        lastname.clear();
        lastname.sendKeys("Maione");
        WebElement password = driver.findElements(By.name("password")).get(0);
        password.clear();
        password.sendKeys("PinoDan");
        WebElement username = driver.findElements(By.name("username")).get(0);
        username.clear();
        username.sendKeys("GMaione");        
        WebElement check = driver.findElements(By.name("typeGrad")).get(0);
        check.sendKeys(Keys.SPACE);
        WebElement formEdit = driver.findElement(By.name("editForm"));
        formEdit.submit();
        boolean changed = driver.getPageSource().contains("GMaioneINCREDIBILMENTELUNGOWOWSPETTACOLARE");
        Assert.assertFalse(changed);
    }
    
    @Test
    public void testEditProfileUserLASTNAMETOOLONG(){
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("g.madonna3@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("PinoDan");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/editProfile.jsp");
        WebElement firstname = driver.findElements(By.name("firstName")).get(0);
        firstname.clear();
        firstname.sendKeys("Giovanni");
        WebElement lastname = driver.findElements(By.name("lastName")).get(0);
        lastname.clear();
        lastname.sendKeys("MaioneINCREDIBILMENTELUNGOWOWSPETTACOLARE");
        WebElement password = driver.findElements(By.name("password")).get(0);
        password.clear();
        password.sendKeys("PinoDan");
        WebElement username = driver.findElements(By.name("username")).get(0);
        username.clear();
        username.sendKeys("GMaione");        
        WebElement check = driver.findElements(By.name("typeGrad")).get(0);
        check.sendKeys(Keys.SPACE);
        WebElement formEdit = driver.findElement(By.name("editForm"));
        formEdit.submit();
        boolean changed = driver.getPageSource().contains("GMaioneINCREDIBILMENTELUNGOWOWSPETTACOLARE");
        Assert.assertFalse(changed);
    }
}
