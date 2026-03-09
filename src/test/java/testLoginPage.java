import com.epam.training.perea_fatima.saucedemo.utils.DriverFactory;
import com.epam.training.perea_fatima.saucedemo.pages.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class testLoginPage {

    @ParameterizedTest
    @ValueSource( strings = {"chrome", "edge"} )
    public void testLoginPage(String browser){

        WebDriver driver = DriverFactory.createWebDriver(browser);

        driver.get("https://www.saucedemo.com/");

        LoginPage login = new LoginPage(driver);

        login.login("standard_user", "secret_sauce");

        assertThat(login.getErrorMesagge(), containsString("Username and password do not match"));

        driver.quit();
    }

}
