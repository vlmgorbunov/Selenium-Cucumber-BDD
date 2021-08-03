package control;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

import java.util.Properties;

public class LoginPage {
    private final WebDriver driver;
    @FindBy(xpath = "//*[@id=\"eu_enter\"]/input[1]")
    private WebElement loginField;
    @FindBy(xpath = "//*[@id=\"eu_enter\"]/input[2]")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"eu_enter\"]/input[3]")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"top-panel\"]/div/div[1]/a")
    private WebElement openFormLink;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openLoginForm() {
        openFormLink.click();
    }

    public void enterUsername(String username) {
        loginField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void submit() {
        submitButton.click();
    }

    public void open() {
        driver.get("https://kpfu.ru/");
    }

    public boolean atPage() {
        return driver.getCurrentUrl().equals("https://kpfu.ru/");
    }

    public boolean isLoggedIn(){
        return driver.getCurrentUrl().contains("shelly.kpfu.ru");
    }
}
