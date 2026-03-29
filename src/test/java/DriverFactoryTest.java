import com.epam.training.perea_fatima.saucedemo.utils.DriverFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class DriverFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "edge"})
    public void testBrowsers(String browser) {

        WebDriver driver = DriverFactory.createWebDriver(browser);
        driver.get("https://www.saucedemo.com/");
        assertThat(driver.getTitle(), containsString("Swag Labs"));
        driver.quit();
    }
}
