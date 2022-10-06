package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BackgroundPage {
    WebDriver driver;

    public BackgroundPage(WebDriver driver) {
        this.driver = driver;
        //init page factory
        PageFactory.initElements(driver, this);
    }


    @FindBy(name = "username")
    WebElement name;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(css = "div[class='oxd-form-actions orangehrm-login-action']")
    WebElement btn;

    @FindBy(css = "p[class='oxd-userdropdown-name']")
    WebElement checkBtn;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutBtn;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[8]/a[1]")
    WebElement clickDashboard;

    public void enterName(String username) {
        name.sendKeys(username);
    }

    public void enterPassword(String passcode) {
        password.sendKeys(passcode);
    }

    public void pressBtn() {
        btn.click();
    }

    public void getTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    public void click() {
        checkBtn.click();
    }

    public void checkLogoutBtn() {
        logoutBtn.isDisplayed();
    }

    public void dashboardCheck(){
        clickDashboard.click();
    }

}
