import com.epam.training.perea_fatima.saucedemo.models.User;
import com.epam.training.perea_fatima.saucedemo.pages.LoginPage;
import com.epam.training.perea_fatima.saucedemo.pages.MainPage;
import com.epam.training.perea_fatima.saucedemo.services.UserCreator;
import com.epam.training.perea_fatima.saucedemo.utils.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTestWithUser extends AbstractTest{

    @ParameterizedTest
    @ValueSource(strings = {"chrome","edge"})
    void accessMainPaige(String browser){

        setUp(browser);

        User user= UserCreator.validUser();
        MainPage mainPage= new LoginPage(driver).login(user);
        assertEquals(mainPage.getPAGE_URL(), driver.getCurrentUrl());
        assertThat(mainPage.getPageTitle(), containsString("Swag Labs"));

        closeDriver();

    }


}
