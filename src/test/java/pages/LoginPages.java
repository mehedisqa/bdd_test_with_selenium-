package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPages {
    protected WebDriver driver;

    public LoginPages(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("TestProject Demo")) {
            throw new IllegalStateException("This is not Login Page." +
                    "The current page is" + driver.getCurrentUrl());
        }
    }

    private By username = By.id("name");
    private By password = By.id("password");
    private By loginBtn = By.id("login");
    private By validateBtn = By.id("logout");

    public void enterUser(String name) {
        driver.findElement(username).sendKeys(name);
    }

    public void enterPassword(String passcode) {
        driver.findElement(password).sendKeys(passcode);
    }

    public void loginBtn() {
        driver.findElement(loginBtn).click();
    }

    public void validate() {
        if (driver.findElement(validateBtn).isDisplayed()) {
            driver.findElement(validateBtn).click();
        } else {
            System.out.println("Something went wrong!");
            driver.quit();
        }


    }

}
