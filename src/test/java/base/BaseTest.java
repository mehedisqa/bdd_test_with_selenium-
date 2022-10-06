package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;
    String driverPath = "src/test/resources/drivers/chromedriver.exe";

    @Before("@sanity")
    public void browserSetup(Scenario sc) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @After("@sanity")
    public void tearDown() {
        driver.quit();
    }
}
