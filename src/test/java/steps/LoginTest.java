package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.LoginPages;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    LoginPages loginPages;
    String driverPath = "//src//test//resources//drivers//chromedriver.exe";

    @Given("get to the login page")
    public void getToTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath);
        driver = new ChromeDriver();
        loginPages = new LoginPages(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://example.testproject.io/web/");
        driver.manage().window().fullscreen();
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
        driver.quit();
    }

}
