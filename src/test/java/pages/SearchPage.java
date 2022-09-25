package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class SearchPage {
    protected WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    WebElement interSearch;
    @FindBy(name = "q")
    WebElement enterBtn;

    /* @FindBy(partialLinkText = "test")
    List<WebElement> list;*/

   /* @FindBy(how = How.ID, using = "name")
    WebElement test;*/

    public void entersASearchText(String text) {
        interSearch.sendKeys(text);
    }

    public void hitEnter() {
        enterBtn.sendKeys(Keys.ENTER);
    }

    public  void  navigatedToSearchResults(){
        String title = String.valueOf(driver.getPageSource().contains("Adele - Hello - YouTube"));
        Assert.assertEquals(title, title);
        driver.quit();
    }

}




