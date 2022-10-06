package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BackgroundPage;

import java.time.Duration;

public class BackgroundLogin {

    WebDriver driver;
    BackgroundPage page;

    String driverPath = "src/test/resources/drivers/chromedriver.exe";

    @Before("@sanity")
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @After("@sanity")
    public void tearDown() {
        driver.quit();
    }

    @Given("user in the login screen")
    public void userInTheLoginScreen() {
        page = new BackgroundPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }


    @When("user enters username and password")
    public void userEntersUsernameAndPassword() throws InterruptedException {
        Thread.sleep(30);
        page.enterName("Admin");
        page.enterPassword("admin123");
    }


    @And("clicks on login button")
    public void clicksOnLoginButton() throws InterruptedException {
        Thread.sleep(30);
        page.pressBtn();
    }

    @Then("user is navigated to the home screen")
    public void userIsNavigatedToTheHomeScreen() {
        page.getTitle();
    }

    @When("user click on welcome link")
    public void userClickOnWelcomeLink() {
        page.click();

    }

    @Then("logout option is visible")
    public void logoutOptionIsVisible() {
        page.checkLogoutBtn();
    }

    @When("user click on dashboard screen")
    public void userClickOnDashboardScreen() {
        page.dashboardCheck();
    }


}
