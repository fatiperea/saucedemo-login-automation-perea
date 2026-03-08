package com.epam.training.perea_fatima.saucedemo.utils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");;
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username){
        driver.findElement(this.username).sendKeys("username");
    }

    public void enterPassword(String password){
        driver.findElement(this.password).sendKeys("password");
    }

    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }

    public void login(String username, String password){

        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMesagge(){
        return driver.findElement(errorMessage).getText();
    }

}
