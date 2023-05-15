package SeleniumLessons.Lesson4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Lesson4HomeWork3 {

    private WebDriver driver;
    private WebDriverWait wait;
    private org.openqa.selenium.WebElement WebElement;

    public void goToSite(WebDriver driver, String url){
        driver.get(url);
    }

    public void closeBrowse(){
        driver.quit();
    }

    public boolean isElementNoDisplay1 (String xpath){
        return wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
    }

    public boolean isElementsNoDisplay2 (String xpath){
        return wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath(xpath))));
    }

    public boolean isElementNoDisplay3(WebDriver driver, String locator){
        try{
            driver.findElement(By.xpath(locator)).click();
            return false;
        }catch (NoSuchElementException e){
            System.out.println("Елемента " + locator + "на сторінці не знайдено");
        }
        return true;
    }

    public WebElement getProduct(String xpath){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    public void clickOnProduct(String xpath){
        getProduct(xpath).click();
    }

    public WebElement getBtnAddProductToCart(String xpath){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    public void addProductToCart(String xpath){
        getBtnAddProductToCart(xpath).click();
    }

    public WebElement getListAddingProductToCart(String xpath){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    public WebElement getPointMenu(String xpath){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    public void clickPointMenu(String xpath){
        getPointMenu(xpath).click();
    }
    public WebElement getBtnDellProductFromCart (String xpath){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    public void clickBtnDellProductFromCart(String xpath){
        getBtnDellProductFromCart (xpath).click();
    }

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        var driver = new ChromeDriver();

        driver.manage().window().maximize();

        Lesson4HomeWork3 element = new Lesson4HomeWork3();

        element.goToSite(driver, "https://rozetka.com.ua/ua/");
        element.clickOnProduct("//a[@class='tile__title']");
        element.addProductToCart("//a[@class='tile__title']");

        element.isElementNoDisplay1("//span[@class='badge badge--green ng-star-inserted']");
        element.isElementsNoDisplay2("//span[@class='badge badge--green ng-star-inserted']");
        element.isElementNoDisplay3(driver, "//span[@class='badge badge--green ng-star-inserted']");
        closeBrowse();
    }
}
