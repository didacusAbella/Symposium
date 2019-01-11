package it.blackhat.symposium.system;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Gozzetto
 */
public class TestAdminChangeTag extends SystemTestCase {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestCase.seleniumDriver;
    }

    @Test
    public void testChangeTagOk() {
        driver.get("http://localhost:8080/Symposium/adminSignIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("supergoku");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("adminForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/admin/QuestionController?action=showQuestion&questionId=53");
        WebElement changeTagStuff = driver.findElements(By.name("changeTag")).get(0);
        changeTagStuff.click();
        WebElement changeTag1Stuff = driver.findElements(By.name("tag")).get(0);
        changeTag1Stuff.clear();
        changeTag1Stuff.sendKeys("diego");
        WebElement changeTag2Stuff = driver.findElements(By.name("change")).get(0);
        changeTag2Stuff.click();
        changeTag2Stuff.click();
        boolean registered1 = driver.getPageSource().contains("diego");
        Assert.assertTrue(registered1);

    }
}