package legacy;

import com.epam.training.perea_fatima.saucedemo.pages.LoginPage;
import com.epam.training.perea_fatima.saucedemo.pages.MainPage;
import com.epam.training.perea_fatima.saucedemo.utils.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class MainPageTest {

    private static final Logger logger = LogManager.getLogger(MainPageTest.class);
    private static final String PASSWORD = "secret_sauce";

    @ParameterizedTest
    @CsvSource({
            "chrome, standard_user",
            "edge, standard_user",
            "chrome, problem_user",
            "edge, problem_user",
            "chrome, error_user",
            "edge, error_user",
            "chrome, visual_user",
            "edge, visual_user",
            "chrome, performance_glitch_user",
            "edge, performance_glitch_user"
    })
    public void testMainPage(String browser, String user) {

        logger.info("Starting test case {} on {}", browser, user);

        WebDriver driver = DriverFactory.createWebDriver(browser);

        driver.get("https://www.saucedemo.com/");

        logger.debug("Navigated to Main page");

        LoginPage login = new LoginPage(driver);
        MainPage mainPage = login.login(user, PASSWORD);

        assertThat(mainPage.getPageTitle(), containsString("Swag Labs"));

        driver.quit();
        logger.info("Closed browser for MainPage test");

    }
}
