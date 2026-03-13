package com.epam.training.perea_fatima.saucedemo.pages;

import com.epam.training.perea_fatima.saucedemo.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage extends AbstractPage {

    private final String PAGE_URL = "https://www.saucedemo.com/";

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");

    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
        logger.info("Login initiated");
    }

    public LoginPage openPage() {
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

    public MainPage login(User user){

        enterUsername(user.getUsername());
        enterPassword(user.getPassword());

        clickLogin();

        return new MainPage(driver);
    }

    public void loginClearedPassword(User user){

        driver.findElement(By.id("user-name")).sendKeys(user.getUsername());
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(user.getPassword());
        passwordField.clear();
        driver.findElement(By.id("login-button")).click();

    }

    public String getErrorMessage() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return error.getText();
        } catch (Exception e) {
            return "";
        }
    }

}
