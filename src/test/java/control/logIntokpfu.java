package control;

import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.pageObjectTest.PropertiesReader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class logIntokpfu {
    private static ChromeDriver driver;
    private static LoginPage loginPage;

    @BeforeAll
    static void build() {
        System.setProperty("webdriver.chrome.driver", "/Users/ghghost/Downloads/chromedriver-3");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
    }

    @AfterAll
    static void destroy() {
        driver.close();
    }

    @Test
    void login() {
        loginPage.open();
        Assertions.assertTrue(loginPage.atPage());
        loginPage.openLoginForm();
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.submit();
        Assertions.assertTrue(loginPage.isLoggedIn());
    }
}
