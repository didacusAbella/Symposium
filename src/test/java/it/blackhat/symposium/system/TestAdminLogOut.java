package it.blackhat.symposium.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Gozzetto
 */
public class TestAdminLogOut  extends SystemTestCase{
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestCase.seleniumDriver;
    }

    @Test
    public void testLogOutClientOk() {
        driver.get("http://localhost:8080/Symposium/adminSignIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("supergoku");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("adminForm"));
        form.submit();
        WebElement logOut = driver.findElement(By.name("LogOut"));
        logOut.click();
        boolean nologged = driver.getPageSource().contains("Sign In");
        Assert.assertTrue(nologged);
    }
}

