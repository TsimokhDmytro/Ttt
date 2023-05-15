package SeleniumLessons.Lesson6.helpers;

import SeleniumLessons.Lesson6.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RozetkaHomePageHelpers extends BasePage {

    public RozetkaHomePageHelpers(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='search']")
    public WebElement SEARCH_FIELD;

}
