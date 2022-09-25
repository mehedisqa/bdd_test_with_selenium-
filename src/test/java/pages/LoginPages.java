package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {
    protected WebDriver driver;

    public LoginPages(WebDriver driver) {
        this.driver = driver;

        //init page factory
        PageFactory.initElements(driver, this);

        if (!driver.getTitle().equals("TestProject Demo")) {
            throw new IllegalStateException("This is not Login Page."
                    + "The current page is" + driver.getCurrentUrl());
        }
    }

    @FindBy(id = "name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginBtn;
    @FindBy(id = "logout")
    WebElement validateBtn;


    public void enterUser(String name) {
        username.sendKeys(name);
    }

    public void enterPassword(String passcode) {
        password.sendKeys(passcode);
    }

    public void loginBtn() {
        loginBtn.click();
    }

    public void validate() {
        if (validateBtn.isDisplayed()) {
            validateBtn.click();
        } else {
            System.out.println("Something went wrong!");
            driver.quit();
        }
    }

}
