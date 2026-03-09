package com.epam.training.perea_fatima.saucedemo.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createWebDriver(String browser){

        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }/*else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return  new FirefoxDriver();
        }*/
        throw new IllegalArgumentException(browser + "Not supported");

    }
}
