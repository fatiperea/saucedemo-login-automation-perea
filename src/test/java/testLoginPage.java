import com.epam.training.perea_fatima.saucedemo.utils.DriverFactory;
import com.epam.training.perea_fatima.saucedemo.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class testLoginPage {

    private static final Logger logger = LogManager.getLogger(testLoginPage.class);

    @ParameterizedTest
    @CsvSource({
            // UC-1: both empty
            "UC-1, chrome, , ",
            "UC-1, edge, , ",

            // UC-2: empty password
            "UC-2, chrome, user, ",
            "UC-2, edge, user, ",

            // UC-3: valid login
            "UC-3, chrome, standard_user, secret_sauce",
            "UC-3, edge, standard_user, secret_sauce",
    })

    public void testLoginPage(String browser, String uc, String user, String password){

        logger.info("Starting test case {} on {}", uc, browser);

        WebDriver driver = DriverFactory.createWebDriver(browser);

        driver.get("https://www.saucedemo.com/");

        logger.debug("Navigated to login page");

        LoginPage login = new LoginPage(driver);

        login.login(user, password);

        logger.info("Attempted login with user='{}' and password='{}'", user, password);

        switch (uc){

            case "UC-1":
                logger.info("Validating UC-1: both empty");
                assertThat(login.getErrorMesagge(), containsString("Username is required"));
                break;

            case "UC-2":
                logger.info("Validating // UC-2: empty password");
                assertThat(login.getErrorMesagge(), containsString("Password is required"));
                break;

            case "UC-3":
                logger.info("Validating // UC-3: valid login");
                assertThat(login.getErrorMesagge(), containsString("Swag Labs"));
                break;
        }
        driver.quit();
        logger.info("Closed browser for test case {}", uc);
    }

}
