package it.blackhat.symposium.system;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

/**
 * @author Gozzetto
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        //TestUserDeleteQuestion.class
        TestNewAnswer.class

})
public class SystemTestSuite {
    public static WebDriver seleniumDriver;

    @BeforeClass
    public static void InitDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless");
        ChromeDriverManager.getInstance(CHROME).setup();
        SystemTestSuite.seleniumDriver = new ChromeDriver(chromeOptions);
    }
}
