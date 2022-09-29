package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchPage;


import java.time.Duration;

public class GoogleSearch {

    WebDriver driver;
    SearchPage searchPage;
    String driverPath = "src/test/resources/drivers/chromedriver.exe";

    @Before

    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver",  driverPath);
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("browser is open")
    public void browserIsOpen() {
        searchPage = new SearchPage(driver);
    }

    @And("user is on search page")
    public void userIsOnSearchPage() {
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @When("user enters a search text in the search box")
    public void userEntersASearchTextInTheSearchBox() {
        searchPage.entersASearchText("hello");
    }

    @And("hit enter")
    public void hitEnter() {
        searchPage.hitEnter();
    }

    @Then("user is navigated to search results")
    public void userIsNavigatedToSearchResults() {
        searchPage.navigatedToSearchResults();

    }
}
