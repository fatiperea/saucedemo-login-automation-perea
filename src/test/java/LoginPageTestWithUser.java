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

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginPageTestWithUser {

    private static final Logger logger = LogManager.getLogger(LoginPageTestWithUser.class);
    private WebDriver driver;
    private LoginPage login;

    void setUp(String browser){

        driver=DriverFactory.createWebDriver(browser);
        driver.get("https://www.saucedemo.com/");
        login = new LoginPage(driver);
        logger.debug("Navigated to login page");
    }

    @AfterEach
    void close(){

        if (driver != null){
            driver.quit();
            logger.info("Closed browser");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome","edge"})
    void loginWithEmptyCredentialsMustFail(String browser){
        logger.info("Validating UC-1: both empty");
        setUp(browser);
        User user= UserCreator.emptyCredentials();
        login.login(user);
        assertEquals("Username is required",login.getErrorMessage());
        close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome","edge"})
    void loginWithEmptyPasswordsMustFail(String browser){
        logger.info("Validating UC-2: cleared password");
        setUp(browser);
        User user= UserCreator.validUser();
        login.loginClearedPassword(user);
        assertEquals("Password is required", login.getErrorMessage());
        close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome","edge"})
    void loginWithValidCredentials(String browser){
        logger.info("Validating // UC-3: valid login");
        setUp(browser);
        for (User u : UserCreator.validUsers().toList()){

            MainPage mainPage= login.login(u);
            assertEquals("Swag Labs", mainPage.getPageTitle());
            mainPage.openPage();

        }
        close();

    }
}
