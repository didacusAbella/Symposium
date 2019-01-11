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
public class TestDeleteQuestionUser  extends SystemTestCase{
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestCase.seleniumDriver;
    }
    @Test
    public void testDeleteQuestion() {
    driver.get("http://localhost:8080/Symposium/signIn.jsp");
    WebElement usernameStuff = driver.findElements(By.name("email")).get(0);
    usernameStuff.sendKeys("d.tropeano@studenti.unisa.it");
    WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
    passwordStuff.sendKeys("P@ssw0rd");
    WebElement form = driver.findElement(By.name("SignInForm"));
    form.submit();
    driver.get("http://localhost:8080/Symposium/user/QuestionController?action=showQuestion&questionId=53");
    WebElement button = driver.findElements(By.name("buttonDeleteUser")).get(0);
    button.click();
    driver.get("http://localhost:8080/Symposium/user/QuestionController?action=showQuestionByAuthor");
    Boolean b1 = driver.getPageSource().contains("Fashion");
    Assert.assertFalse(b1);
    }
}
