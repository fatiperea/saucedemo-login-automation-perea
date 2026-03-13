import com.epam.training.perea_fatima.saucedemo.models.User;
import com.epam.training.perea_fatima.saucedemo.pages.LoginPage;
import com.epam.training.perea_fatima.saucedemo.services.UserCreator;
import com.epam.training.perea_fatima.saucedemo.utils.DriverFactory;

import com.epam.training.perea_fatima.saucedemo.pages.MainPage;
import com.epam.training.perea_fatima.saucedemo.utils.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginPageTestWithUser extends AbstractTest {

    private static final Logger logger = LogManager.getLogger(LoginPageTestWithUser.class);

    @ParameterizedTest
    @ValueSource(strings = {"chrome","edge"})
    void loginWithEmptyCredentialsMustFail(String browser){
        logger.info("Validating UC-1: both empty");
        setUp(browser);
        LoginPage login = getLoginPage();
        User user= UserCreator.emptyCredentials();
        login.login(user);
        assertThat(login.getErrorMessage(), containsString("Username is required"));
        closeDriver();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome","edge"})
    void loginWithEmptyPasswordsMustFail(String browser){
        logger.info("Validating UC-2: cleared password");
        setUp(browser);
        LoginPage login = getLoginPage();
        User user= UserCreator.validUserEmptyPassword();
        login.loginClearedPassword(user);
        assertThat(login.getErrorMessage(), containsString("Password is required"));
        closeDriver();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome","edge"})
    void loginWithValidCredentials(String browser){
        logger.info("Validating // UC-3: valid login");
        setUp(browser);
        LoginPage login = getLoginPage();
        User user = UserCreator.validUser();
        MainPage mainPage= login.login(user);

            logger.info("Validating // UC-3: valid login" + mainPage.getPageTitle());
            assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
            assertEquals("Swag Labs", mainPage.getPageTitle());

        closeDriver();

    }
}
