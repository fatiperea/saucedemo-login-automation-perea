import com.epam.training.perea_fatima.saucedemo.pages.LoginPage;
import com.epam.training.perea_fatima.saucedemo.utils.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractTest {

    protected WebDriver driver;
    protected Logger logger = LogManager.getLogger(MainPageTestWithUser.class);

    protected void setUp(String browser) {

        driver= DriverFactory.createWebDriver(browser);
        driver.get("https://www.saucedemo.com/");
        logger.info("Browser started" + browser);

    }

    protected void closeDriver(){

        if (driver != null){
            driver.quit();
            logger.info("Closed browser");
        }
    }

}
