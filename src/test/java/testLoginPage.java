import com.epam.training.perea_fatima.saucedemo.utils.DriverFactory;
import com.epam.training.perea_fatima.saucedemo.pages.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class testLoginPage {

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
    //@ValueSource( strings = {"chrome", "edge"} )
    public void testLoginPage(String browser, String uc, String user, String password){

        WebDriver driver = DriverFactory.createWebDriver(browser);

        driver.get("https://www.saucedemo.com/");

        LoginPage login = new LoginPage(driver);

        login.login(user, password);

        switch (uc){

            case "UC-1":
                assertThat(login.getErrorMesagge(), containsString("Username is required"));
                break;

            case "UC-2":
                assertThat(login.getErrorMesagge(), containsString("Password is required"));
                break;

            case "UC-3":
                assertThat(login.getErrorMesagge(), containsString("Swag Labs"));
                break;
        }
        driver.quit();
    }

}
