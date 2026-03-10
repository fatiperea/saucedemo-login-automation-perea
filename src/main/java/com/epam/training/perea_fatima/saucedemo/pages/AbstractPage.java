package com.epam.training.perea_fatima.saucedemo.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver driver){ this.driver = driver;}

}
