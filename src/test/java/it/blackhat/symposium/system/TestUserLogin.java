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
public class TestUserLogin  extends SystemTestCase{
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestCase.seleniumDriver;
    }

    @Ignore
    public void testLoginClientOk() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        boolean logged = driver.getPageSource().contains("oromis95");
        Assert.assertTrue(logged);
    }

    @Test
    public void testLoginClientEmailNotOk() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("g.gianni22@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        boolean b1 = driver.getPageSource().contains("Email o password errata");
        Assert.assertTrue(b1);
    }
    @Test
    public void testLoginClientPasswordNotOk() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd1");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        boolean b1 = driver.getPageSource().contains("Email o password errata");
        Assert.assertTrue(b1);
    }
    @Test
    public void testLoginClientPasswordWrong() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("pa");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        boolean b1 = driver.getPageSource().contains("Inserisci una password valida");
        Assert.assertTrue(b1);
    }
    @Test
    public void testLoginClientEmailWrong() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("tropeano@live.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd1");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        boolean b1 = driver.getPageSource().contains("Inserisci una mail valida");
        Assert.assertTrue(b1);
    }
    @Test
    public void testLoginClientEmailPasswordWrong() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("tropeano@live.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("pa");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        boolean b1 = driver.getPageSource().contains("Inserisci una mail valida");
        Assert.assertTrue(b1);
        boolean b2 = driver.getPageSource().contains("Inserisci una password valida");
        Assert.assertTrue(b2);
    }
}
