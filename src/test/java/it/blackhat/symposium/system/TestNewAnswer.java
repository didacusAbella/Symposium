/**
 * 
 */
package it.blackhat.symposium.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Parrilli Carminantonio
 *
 */
public class TestNewAnswer {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestSuite.seleniumDriver;
    }
    @Test
    public void testNewAnswerOk() {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.findElement(By.linkText("http://localhost:8080/Symposium/user/QuestionController?action=showQuestion&questionId=56")).click();
        driver.findElement(By.linkText("http://localhost:8080/Symposium/user/AnswerController?action=showAnswerPage&questionId=56")).click();
        WebElement textarea = driver.findElements(By.name("answerContent")).get(0);
        textarea.sendKeys("Questo è un test");
        WebElement newInseredAnswer = driver.findElement(By.name("submitAnswer")); //Rinominare bottone in newAnswer.JSP
        newInseredAnswer.submit();
        Boolean b1 = driver.getPageSource().contains("Questo è un test");
        Assert.assertTrue(b1);
        
        
    }
    @Test
    public void testNewAnswerNoContenent() 
    {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.findElement(By.linkText("http://localhost:8080/Symposium/user/QuestionController?action=showQuestion&questionId=56")).click();
        driver.findElement(By.linkText("http://localhost:8080/Symposium/user/AnswerController?action=showAnswerPage&questionId=56")).click();
        WebElement textarea = driver.findElements(By.name("answerContent")).get(0);
        textarea.sendKeys("");
        WebElement newInseredAnswer = driver.findElement(By.name("submitAnswer"));//Rinominare bottone in newAnswer.JSP
        newInseredAnswer.submit();
        Boolean b1 = driver.getPageSource().contains("");
        Assert.assertTrue(b1);
    }
    @Test
    public void testNewAnswerTooManyCharacters() 
    {
        driver.get("http://localhost:8080/Symposium/signIn.jsp");
        WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
        usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("P@ssw0rd");
        WebElement form = driver.findElement(By.name("SignInForm"));
        form.submit();
        driver.findElement(By.linkText("http://localhost:8080/Symposium/user/QuestionController?action=showQuestion&questionId=56")).click();
        driver.findElement(By.linkText("http://localhost:8080/Symposium/user/AnswerController?action=showAnswerPage&questionId=56")).click();
        WebElement textarea = driver.findElements(By.name("answerContent")).get(0);
        String maxString = String.valueOf(Long.MAX_VALUE);
        textarea.sendKeys(maxString);
        WebElement newInseredAnswer = driver.findElement(By.name("submitAnswer"));//Rinominare bottone in newAnswer.JSP
        newInseredAnswer.submit();
        Boolean b1 = driver.getPageSource().contains(maxString);
        Assert.assertFalse(b1);
        
    }
}
