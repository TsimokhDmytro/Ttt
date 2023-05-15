package SeleniumLessons.Lesson6.Pages;

import SeleniumLessons.Lesson6.helpers.RozetkaHomePageHelpers;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static io.qameta.allure.Allure.step;

public class RozetkaHomePage extends RozetkaHomePageHelpers {

    private static final String ROZETKA = "https://rozetka.com.ua/ua/";

    public RozetkaHomePage(WebDriver driver) {
        super(driver);
    }
    @Step("Go to rozetka.com.ua")
    public RozetkaHomePage openRozetka() {
        openUrl(ROZETKA);
        waitCurrentUrl(ROZETKA);
        return this;
    }

    public void searchProduct(String productName) {
        step(String.format("Search %s", productName), () -> {
            waitForClickableElement(SEARCH_FIELD).sendKeys(productName);
            pressEnter();
        });
    }
}
