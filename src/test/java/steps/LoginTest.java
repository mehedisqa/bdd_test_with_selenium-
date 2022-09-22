package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
    @Given("get to the login page")
    public void getToTheLoginPage() {
        System.out.println("given");
    }

    @When("enter username and password")
    public void enterUsernameAndPassword() {
        System.out.println("when");
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        System.out.println("and");
    }

    @Then("navigate to the home page")
    public void navigateToTheHomePage() {
        System.out.println("then");
    }
}
