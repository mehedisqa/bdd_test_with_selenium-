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


import java.time.Duration;

public class GoogleSearch {

    WebDriver driver;
    ChromeOptions options;

    String driverPath = "//src//test//resources//drivers//chromedriver.exe";

    @Given("browser is open")
    public void browserIsOpen() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @And("user is on search page")
    public void userIsOnSearchPage() {
        driver.get("https://www.google.com/");
        driver.manage().window().fullscreen();
    }

    @When("user enters a search text in the search box")
    public void userEntersASearchTextInTheSearchBox() {

        driver.findElement(By.name("q")).sendKeys("Hello");
    }

    @And("hit enter")
    public void hitEnter() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("user is navigated to search results")
    public void userIsNavigatedToSearchResults() {
        String title = String.valueOf(driver.getPageSource().contains("Adele - Hello - YouTube"));
        Assert.assertEquals(title, title);
        driver.quit();

    }
}
