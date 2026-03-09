import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import com.epam.training.perea_fatima.saucedemo.utils.DriverFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class testDriverFactory {

    @ParameterizedTest
    @ValueSource( strings = {"chrome", "edge", "firefox"} )
    public void testBrowsers(String browser) {

        WebDriver driver = DriverFactory.createWebDriver(browser);
        driver.get("https://www.saucedemo.com/");
        assertThat(driver.getTitle(), containsString("Swag Labs"));
        driver.quit();
    }

    /*@Test
    public void testEdgeDriver() {

        WebDriver driver = DriverFactory.createWebDriver("edge");
        driver.get("https://www.saucedemo.com/");
        assertThat(driver.getTitle(), containsString("Swag Labs"));
        driver.quit();
    }

    @Test
    public void testFirefoxDriver() {

        WebDriver driver = DriverFactory.createWebDriver("firefox");
        driver.get("https://www.saucedemo.com/");
        assertThat(driver.getTitle(), containsString("Swag Labs"));
        driver.quit();
    }*/



}
