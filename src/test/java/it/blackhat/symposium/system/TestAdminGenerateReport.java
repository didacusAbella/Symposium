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
public class TestAdminGenerateReport extends SystemTestCase {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestCase.seleniumDriver;
    }

    @Test
    public void testGenerateReportAdminOk() {
        driver.get("http://localhost:8080/Symposium/adminSignIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("supergoku");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("adminForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/admin/StatsController?action=showStats");
        WebElement reportStuff = driver.findElement(By.name("stats"));
        reportStuff.submit();
        boolean registered = driver.getPageSource().contains("Report Anno: 2018");
        Assert.assertTrue(registered);
    }
}