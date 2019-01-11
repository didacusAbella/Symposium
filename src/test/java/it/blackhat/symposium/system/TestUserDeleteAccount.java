package it.blackhat.symposium.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Gozzetto
 */
public class TestUserDeleteAccount  extends SystemTestCase {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestCase.seleniumDriver;
    }

    @Test
    public void testDeleteAccountOk() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/user/UserController?action=showProfile");
        WebElement deleteStuff = driver.findElements(By.name("delete")).get(0);
        deleteStuff.click();
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement username1Stuff = driver.findElements(By.name("email")).get(0);
        username1Stuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement password1Stuff = driver.findElements(By.name("password")).get(0);
        password1Stuff.sendKeys("P@ssw0rd");
        WebElement form1 = driver.findElement(By.name("SignInForm"));
        form1.submit();
        boolean logged = driver.getPageSource().contains("Email o password errata");
        Assert.assertTrue(logged);
        // driver.close();
    }
}
