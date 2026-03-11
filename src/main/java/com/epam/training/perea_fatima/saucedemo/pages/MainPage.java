package com.epam.training.perea_fatima.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    private final String PAGE_URL = "https://www.saucedemo.com/inventory.html";
    private final By pageTitle = By.className("app_logo");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page opened");
        return this;
    }

    public String getPageTitle() {
        String title = driver.findElement(pageTitle).getText();
        logger.info("Main page title: ", title);
        return title;
    }
}
