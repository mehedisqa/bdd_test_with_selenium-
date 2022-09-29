package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPages;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    LoginPages loginPages;
    String driverPath = "src/test/resources/drivers/chromedriver.exe";


    @Before("@retest")
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }


    @After("@retest")
    public void tearDown() {
        driver.quit();
    }

    @Given("get to the login page")
    public void getToTheLoginPage() {
        loginPages = new LoginPages(driver);
        driver.get("https://example.testproject.io/web/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }


    @When("enter {string} and {string}")
    public void enterAnd(String arg0, String arg1) throws InterruptedException {
        loginPages.enterUser(arg0);
        loginPages.enterPassword(arg1);
        Thread.sleep(2000);
    }

    @And("click on login button")
    public void clickOnLoginButton() throws InterruptedException {
        loginPages.loginBtn();
        Thread.sleep(2000);
    }

    @Then("navigate to the home page")
    public void navigateToTheHomePage() {

        loginPages.validate();
    }

}
