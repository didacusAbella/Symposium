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
public class TestUserSignUp {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SystemTestSuite.seleniumDriver;
    }

    @Test
    public void testSignUpClientOk() {
        driver.get("http://localhost:8080/Symposium/signUp.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("giannino");
        WebElement nameStuff = driver.findElements(By.name("firstName")).get(0);
        nameStuff.sendKeys("Gianni");
        WebElement lastnameStuff = driver.findElements(By.name("lastName")).get(0);
        lastnameStuff.sendKeys("Demaio");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("password");
        WebElement emailStuff = driver.findElements(By.name("email")).get(0);
        emailStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement confirmStuff = driver.findElements(By.name("confirmMail")).get(0);
        confirmStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement checkStuff = driver.findElements(By.name("typeGrad")).get(0);
        checkStuff.sendKeys(Keys.SPACE);
        WebElement form = driver.findElement(By.name("SignUpForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("Accedi");
        Assert.assertTrue(registered);
        // driver.close();
    }
    @Test
    public void testSignUpClientUsernameWrong() {
        driver.get("http://localhost:8080/Symposium/signUp.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("g");
        WebElement nameStuff = driver.findElements(By.name("firstName")).get(0);
        nameStuff.sendKeys("Gianni");
        WebElement lastnameStuff = driver.findElements(By.name("lastName")).get(0);
        lastnameStuff.sendKeys("Demaio");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("password");
        WebElement emailStuff = driver.findElements(By.name("email")).get(0);
        emailStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement confirmStuff = driver.findElements(By.name("confirmMail")).get(0);
        confirmStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement checkStuff = driver.findElements(By.name("typeGrad")).get(0);
        checkStuff.sendKeys(Keys.SPACE);
        WebElement form = driver.findElement(By.name("SignUpForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("Inserisci un nome utente valido");
        Assert.assertFalse(registered);
        // driver.close();
    }
    @Test
    public void testSignUpClientFirstNameWrong() {
        driver.get("http://localhost:8080/Symposium/signUp.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("gianni");
        WebElement nameStuff = driver.findElements(By.name("firstName")).get(0);
        nameStuff.sendKeys("G");
        WebElement lastnameStuff = driver.findElements(By.name("lastName")).get(0);
        lastnameStuff.sendKeys("Demaio");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("password");
        WebElement emailStuff = driver.findElements(By.name("email")).get(0);
        emailStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement confirmStuff = driver.findElements(By.name("confirmMail")).get(0);
        confirmStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement checkStuff = driver.findElements(By.name("typeGrad")).get(0);
        checkStuff.sendKeys(Keys.SPACE);
        WebElement form = driver.findElement(By.name("SignUpForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("Inserisci un nome valido");
        Assert.assertTrue(registered);
        // driver.close();
    }
    @Test
    public void testSignUpClientLastNameWrong() {
        driver.get("http://localhost:8080/Symposium/signUp.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("gianni");
        WebElement nameStuff = driver.findElements(By.name("firstName")).get(0);
        nameStuff.sendKeys("Gianni");
        WebElement lastnameStuff = driver.findElements(By.name("lastName")).get(0);
        lastnameStuff.sendKeys("D");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("password");
        WebElement emailStuff = driver.findElements(By.name("email")).get(0);
        emailStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement confirmStuff = driver.findElements(By.name("confirmMail")).get(0);
        confirmStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement checkStuff = driver.findElements(By.name("typeGrad")).get(0);
        checkStuff.sendKeys(Keys.SPACE);
        WebElement form = driver.findElement(By.name("SignUpForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("Inserisci un cognome valido");
        Assert.assertTrue(registered);
        // driver.close();
    }
    @Test
    public void testSignUpClientPasswordWrong() {
        driver.get("http://localhost:8080/Symposium/signUp.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("gianni");
        WebElement nameStuff = driver.findElements(By.name("firstName")).get(0);
        nameStuff.sendKeys("Gianni");
        WebElement lastnameStuff = driver.findElements(By.name("lastName")).get(0);
        lastnameStuff.sendKeys("Demaio");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("a");
        WebElement emailStuff = driver.findElements(By.name("email")).get(0);
        emailStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement confirmStuff = driver.findElements(By.name("confirmMail")).get(0);
        confirmStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement checkStuff = driver.findElements(By.name("typeGrad")).get(0);
        checkStuff.sendKeys(Keys.SPACE);
        WebElement form = driver.findElement(By.name("SignUpForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("Inserisci una password valida");
        Assert.assertTrue(registered);
        // driver.close();
    }
    @Test
    public void testSignUpClientEmailWrong() {
        driver.get("http://localhost:8080/Symposium/signUp.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("gianni");
        WebElement nameStuff = driver.findElements(By.name("firstName")).get(0);
        nameStuff.sendKeys("Gianni");
        WebElement lastnameStuff = driver.findElements(By.name("lastName")).get(0);
        lastnameStuff.sendKeys("Demaio");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("password");
        WebElement emailStuff = driver.findElements(By.name("email")).get(0);
        emailStuff.sendKeys("g.gianni30@live.it");
        WebElement confirmStuff = driver.findElements(By.name("confirmMail")).get(0);
        confirmStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement checkStuff = driver.findElements(By.name("typeGrad")).get(0);
        checkStuff.sendKeys(Keys.SPACE);
        WebElement form = driver.findElement(By.name("SignUpForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("Inserisci una mail valida");
        Assert.assertTrue(registered);
        // driver.close();
    }
    @Test
    public void testSignUpClientVerifyWrong() {
        driver.get("http://localhost:8080/Symposium/signUp.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("g");
        WebElement nameStuff = driver.findElements(By.name("firstName")).get(0);
        nameStuff.sendKeys("Gianni");
        WebElement lastnameStuff = driver.findElements(By.name("lastName")).get(0);
        lastnameStuff.sendKeys("Demaio");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("password");
        WebElement emailStuff = driver.findElements(By.name("email")).get(0);
        emailStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement confirmStuff = driver.findElements(By.name("confirmMail")).get(0);
        confirmStuff.sendKeys("g.gianni30@studenti.unisa.i");
        WebElement checkStuff = driver.findElements(By.name("typeGrad")).get(0);
        checkStuff.sendKeys(Keys.SPACE);
        WebElement form = driver.findElement(By.name("SignUpForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("Inserisci una mail valida");
        Assert.assertTrue(registered);
        // driver.close();
    }
    @Test
    public void testSignUpClientEmailExists() {
        driver.get("http://localhost:8080/Symposium/signUp.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("giannino");
        WebElement nameStuff = driver.findElements(By.name("firstName")).get(0);
        nameStuff.sendKeys("Gianni");
        WebElement lastnameStuff = driver.findElements(By.name("lastName")).get(0);
        lastnameStuff.sendKeys("Demaio");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("password");
        WebElement emailStuff = driver.findElements(By.name("email")).get(0);
        emailStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement confirmStuff = driver.findElements(By.name("confirmMail")).get(0);
        confirmStuff.sendKeys("g.gianni30@studenti.unisa.it");
        WebElement checkStuff = driver.findElements(By.name("typeGrad")).get(0);
        checkStuff.sendKeys(Keys.SPACE);
        WebElement form = driver.findElement(By.name("SignUpForm"));
        form.submit();
        boolean registered = driver.getPageSource().contains("L'email immessa è già in uso");
        Assert.assertTrue(registered);
        // driver.close();
    }
}