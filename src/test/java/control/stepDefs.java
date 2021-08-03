package control;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.pageObjectTest.PropertiesReader;
//import selenium.pageObjectTest.pageobject.LoginPage;
//import selenium.pageObjectTest.pageobject.MainPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class stepDefs {
    private static ChromeDriver driver;
    private static Properties properties;

    @Before()
    public void init() {
        properties = PropertiesReader.getProperties();
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After()
    public void close() {
        driver.close();
    }

    @Given("I visit {string} page")
    @When("open {string} page")
    public void open_page(String string) {
        driver.get(properties.getProperty(string));
    }

    @Then("{string} page should be opened")
    @When("{string} page opened")
    public void page_opened(String string) {
        Assertions.assertEquals(properties.getProperty(string), driver.getCurrentUrl());
    }

    @When("I enter {string} in the {string} field")
    @When("type text: {string} to input with name {string}")
    public void type_to_input_with_name_text(String string, String string2) {
        WebElement input = driver.findElement(By.xpath(string2));
        input.sendKeys(string);
    }

    @When("I press the {string} button")
    @When("press button with id {string}")
    public void press_button_with_value(String string) {
        WebElement button = driver.findElement(By.id(string));
        button.click();
    }

    @Then("I should see the find {string} on the page")
    public void i_should_see_the_find_on_the_page(String string) {
        WebElement text = driver.findElement(By.id("messages"));
        Assertions.assertTrue(text.getText().contains(string));
    }
}
