package it.blackhat.symposium.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Gozzetto
 */
public class TestAdminBanUser {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestSuite.seleniumDriver;
    }

    @Test
    public void testTemporaryBanAdminOk() {
        driver.get("http://localhost:8080/Symposium/adminSignIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("supergoku");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("adminForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/admin/AdminController?action=showUsersAction");
        WebElement checkBox = driver.findElements(By.name("typeBan1")).get(0);
        checkBox.click();
        WebElement form1 = driver.findElement(By.name("userForm"));
        form1.submit();
        boolean banned = driver.getPageSource().contains("Gestione Utente");
        Assert.assertTrue(banned);

    }
    @Test
    public void testPermanentBanAdminOk() {
        driver.get("http://localhost:8080/Symposium/adminSignIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("supergoku");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("adminForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/admin/AdminController?action=showUsersAction");
        WebElement checkBox = driver.findElements(By.name("typeBan2")).get(0);
        checkBox.click();
        WebElement form1 = driver.findElement(By.name("userForm"));
        form1.submit();
        boolean banned = driver.getPageSource().contains("Gestione Utente");
        Assert.assertTrue(banned);

    }
}