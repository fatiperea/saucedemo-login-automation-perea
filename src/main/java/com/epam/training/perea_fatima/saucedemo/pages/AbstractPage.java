package com.epam.training.perea_fatima.saucedemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected final Logger logger = LogManager.getLogger(getClass());
    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver driver){ this.driver = driver;}

}
