import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.epam.training.perea_fatima.saucedemo.utils.DriverFactory;

public class testDriverFactory {

    @Test
    public void testChromeDriverOpensPage() {

        WebDriver driver = DriverFactory.createWebDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        driver.quit();
    }




}
