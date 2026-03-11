package com.epam.training.perea_fatima.saucedemo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LoginPage extends AbstractPage{

    private final String PAGE_URL ="https://www.saucedemo.com/";

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");

    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
        logger.info("Login initiated");
    }

    @Override
    protected AbstractPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Login page opened");
        return this;
    }

    public void enterUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
        logger.info("Login button clicked");
    }

    public MainPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new MainPage(driver);
    }

    public String getErrorMessage() {

        List<WebElement> elements = driver.findElements(errorMessage);

        if (elements.isEmpty()) {
            return "";
        }
        return elements.get(0).getText();
    }

}
