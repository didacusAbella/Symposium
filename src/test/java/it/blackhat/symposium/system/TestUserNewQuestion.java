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
public class TestUserNewQuestion {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestSuite.seleniumDriver;
    }

    @Test
    public void testNewQuestionOk() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/newQuestion.jsp");
        WebElement titleStuff = driver.findElements(By.name("title")).get(0);
        titleStuff.sendKeys("titolook");
        WebElement contentStuff = driver.findElements(By.name("content")).get(0);
        contentStuff.sendKeys("contenuto prova");
        WebElement tagsStuff = driver.findElements(By.id("tags_1_tag")).get(0);
        tagsStuff.sendKeys("prova");
        tagsStuff.sendKeys(Keys.TAB);
        WebElement form1 = driver.findElement(By.name("newQuestion"));
        form1.submit();
        boolean b1 = driver.getPageSource().contains("titolook");
        Assert.assertTrue(b1);

    }
    @Test
    public void testNewQuestionTitleInvalid() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/newQuestion.jsp");
        WebElement contentStuff = driver.findElements(By.name("content")).get(0);
        contentStuff.sendKeys("contenuto prova");
        WebElement tagsStuff = driver.findElements(By.id("tags_1_tag")).get(0);
        tagsStuff.sendKeys("prova");
        tagsStuff.sendKeys(Keys.TAB);
        WebElement form1 = driver.findElement(By.name("newQuestion"));
        form1.submit();
        boolean b1 = driver.getPageSource().contains("Error 400!");
        Assert.assertTrue(b1);

    }
    @Test
    public void testNewQuestionContentInvalid() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/newQuestion.jsp");
        WebElement titleStuff = driver.findElements(By.name("title")).get(0);
        titleStuff.sendKeys("titolook");
        WebElement tagsStuff = driver.findElements(By.id("tags_1_tag")).get(0);
        tagsStuff.sendKeys("prova");
        tagsStuff.sendKeys(Keys.TAB);
        WebElement form1 = driver.findElement(By.name("newQuestion"));
        form1.submit();
        boolean b1 = driver.getPageSource().contains("Error 400!");
        Assert.assertTrue(b1);
    }
    @Test
    public void testNewQuestionWithoutTag() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/newQuestion.jsp");
        WebElement titleStuff = driver.findElements(By.name("title")).get(0);
        titleStuff.sendKeys("titolooka");
        WebElement contentStuff = driver.findElements(By.name("content")).get(0);
        contentStuff.sendKeys("contenuto prova");
        WebElement form1 = driver.findElement(By.name("newQuestion"));
        form1.submit();
        boolean b1 = driver.getPageSource().contains("titolooka");
        Assert.assertTrue(b1);

    }
}