package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.SearchPage;


import java.time.Duration;

public class GoogleSearch {

    WebDriver driver;
    SearchPage searchPage;
    String driverPath = "//src//test//resources//drivers//chromedriver.exe";

    @Given("browser is open")
    public void browserIsOpen() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath);
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @And("user is on search page")
    public void userIsOnSearchPage() {
        driver.get("https://www.google.com/");
        driver.manage().window().fullscreen();
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
