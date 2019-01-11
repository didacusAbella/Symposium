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
public class TestAdminLogin extends SystemTestCase {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestCase.seleniumDriver;
    }

    @Test
    public void testSignUpAdminOk() {
        driver.get("http://localhost:8080/Symposium/adminSignIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("supergoku");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("adminForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("Sezione Amministratore");
        Assert.assertTrue(registered);
        // driver.close();

    }
    @Test
    public void testSignUpUsernameInvalid() {
        driver.get("http://localhost:8080/Symposium/adminSignIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("su");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("adminForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("Inserisci un username valido");
        Assert.assertTrue(registered);
        // driver.close();

    }
    @Test
    public void testSignUpUsernameNotPresent() {
        driver.get("http://localhost:8080/Symposium/adminSignIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("supergoku1");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("adminForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("Credenziali Errate");
        Assert.assertTrue(registered);
        // driver.close();

    }
    @Test
    public void testSignUpPasswordNotPresent() {
        driver.get("http://localhost:8080/Symposium/adminSignIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("supergoku");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd1");
        WebElement form = driver.findElement(By.name("adminForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("Credenziali Errate");
        Assert.assertTrue(registered);
        // driver.close();

    }
    @Test
    public void testSignUpPasswordInvalid() {
        driver.get("http://localhost:8080/Symposium/adminSignIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("supergoku1");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P");
        WebElement form = driver.findElement(By.name("adminForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("Inserisci una password");
        Assert.assertTrue(registered);
        // driver.close();

    }
}
