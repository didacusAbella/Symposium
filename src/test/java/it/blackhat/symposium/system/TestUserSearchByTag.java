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
public class TestUserSearchByTag  extends SystemTestCase {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestCase.seleniumDriver;
    }

    @Test
    public void testSearchNameOk() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        WebElement searchByStuff = driver.findElements(By.name("searchBy")).get(0);
        searchByStuff.sendKeys("#ferrucci");
        WebElement searchStuff = driver.findElements(By.name("search")).get(0);
        searchStuff.click();
        boolean logged = driver.getPageSource().contains("Ferrucci");
        Assert.assertTrue(logged);
        // driver.close();
    }

    @Test
    public void testSearchNameNotOk() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        WebElement searchByStuff = driver.findElements(By.name("searchBy")).get(0);
        searchByStuff.sendKeys("#aaaaaaaaaaaaaaa");
        WebElement searchStuff = driver.findElements(By.name("search")).get(0);
        searchStuff.click();
        boolean logged = driver.getPageSource().contains("Non ci sono domande");
        Assert.assertTrue(logged);
        driver.close();
    }
}