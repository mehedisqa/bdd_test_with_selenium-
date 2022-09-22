package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPages {
    protected WebDriver driver;

    public LoginPages(WebDriver driver) {
        this.driver = driver;
    }

    private By username = By.id("name");
    private By password = By.id("password");
    private By loginBtn = By.id("login");

    public void enterUser(String name) {
        driver.findElement(username).sendKeys(name);
    }

    public void enterPassword(String passcode) {
        driver.findElement(password).sendKeys(passcode);
    }

    public void loginBtn() {
        driver.findElement(loginBtn).click();
    }

}
