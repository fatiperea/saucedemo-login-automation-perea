import com.epam.training.perea_fatima.saucedemo.utils.DriverFactory;
import com.epam.training.perea_fatima.saucedemo.utils.pages.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class testLoginPage {

    @Test
    public void testLoginPageChrome(){

        WebDriver driver = DriverFactory.createWebDriver("chrome");

        driver.get("https://www.saucedemo.com/");

        LoginPage login = new LoginPage(driver);

        login.login("wrongUser", "wrongPass");

        assertThat(login.getErrorMesagge(), containsString("Username and password do not match"));

        driver.quit();
    }

    @Test
    public void testLoginPageEdge(){

        WebDriver driver = DriverFactory.createWebDriver("edge");

        driver.get("https://www.saucedemo.com/");

        LoginPage login = new LoginPage(driver);

        login.login("wrongUser", "wrongPass");

        assertThat(login.getErrorMesagge(), containsString("Username and password do not match"));

        driver.quit();
    }

}
