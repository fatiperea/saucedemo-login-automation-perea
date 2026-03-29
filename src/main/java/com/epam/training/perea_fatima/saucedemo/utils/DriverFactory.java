package com.epam.training.perea_fatima.saucedemo.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    public static WebDriver createWebDriver(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "edge":
                //WebDriverManager.edgedriver().setup(); problems with WebDriverManager and Edge, so using manual setup
                System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException(browser + " Not supported");
        }

    }
}
