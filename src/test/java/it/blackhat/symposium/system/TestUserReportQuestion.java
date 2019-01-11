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
public class TestUserReportQuestion  extends SystemTestCase {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestCase.seleniumDriver;
    }

    @Test
    public void testReportQuestionOk() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.get("http://localhost:8080/Symposium/user/QuestionController?action=showQuestion&questionId=56");
        driver.get("http://localhost:8080/Symposium/user/ReportController?action=showInsertReport&questionId=56");
        WebElement categoryStuff = driver.findElements(By.name("category")).get(0);
        categoryStuff.sendKeys("spam");
        WebElement reasonStuff = driver.findElements(By.name("reason")).get(0);
        reasonStuff.sendKeys("Per me non deve essere sul sito");
        WebElement insertReportStuff = driver.findElement(By.name("insertReport"));
        insertReportStuff.submit();
        boolean logged = driver.getPageSource().contains("Domande Top");
        Assert.assertTrue(logged);
    }
}