import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTest {

    private static WebDriver driver;
    private static final String USERNAME = "usuario";
    private static final String AUTOMATE_KEY = "password";
    private static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void loginTest() throws Exception {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("browser", "safari");
        capabilities.setCapability("browser_version", "latest");
        capabilities.setCapability("os", "OS X");
        capabilities.setCapability("os_version", "Big Sur");
        capabilities.setCapability("build", "browserstack-build-1");
        capabilities.setCapability("name", "Thread 3");

        driver=new RemoteWebDriver(new URL(URL),capabilities);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(20000);
    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }
}
