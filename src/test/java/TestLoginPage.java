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

public class TestLoginPage {

    private static final Logger logger = LogManager.getLogger(TestLoginPage.class);
    private static final String PASSWORD="secret_sauce";

    @ParameterizedTest
    @CsvSource({
            // UC-1: both empty
            "UC-1, chrome, '', ''",
            "UC-1, edge, '', ''",

            // UC-2: empty password
            "UC-2, chrome, user",
            "UC-2, edge, user",

            // UC-3: valid login
            "UC-3, chrome, standard_user",
            "UC-3, edge, standard_user",
            "UC-3, chrome, problem_user",
            "UC-3, edge, problem_user",
            "UC-3, chrome, error_user",
            "UC-3, edge, error_user",
            "UC-3, chrome, visual_user",
            "UC-3, edge, visual_user",
            "UC-3, chrome, performance_glitch_user",
            "UC-3, edge, performance_glitch_user"

    })

    public void testLoginPage(String uc, String browser, String user) {

        logger.info("Starting test case {} on {}", uc, browser);

        WebDriver driver = DriverFactory.createWebDriver(browser);

        driver.get("https://www.saucedemo.com/");

        logger.debug("Navigated to login page");

        LoginPage login = new LoginPage(driver);
        String password= "";
        if ("UC-3".equals(uc)) password = PASSWORD;

        login.login(user, password);

        logger.info("Attempted login with user='{}' and password='{}'", user, password);

        switch (uc) {

            case "UC-1":
                logger.info("Validating UC-1: both empty");
                assertThat(login.getErrorMessage(), containsString("Username is required"));
                break;

            case "UC-2":
                logger.info("Validating // UC-2: empty password");
                assertThat(login.getErrorMessage(), containsString("Password is required"));
                break;

            case "UC-3":
                logger.info("Validating // UC-3: valid login");
                MainPage mainPage = new MainPage(driver);
                assertThat(mainPage.getPageTitle(), containsString("Swag Labs"));
                break;
        }
        driver.quit();
        logger.info("Closed browser for test case {}", uc);
    }

}
