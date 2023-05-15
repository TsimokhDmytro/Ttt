package SeleniumLessons.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SimplyCodes {

    WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
//    public void setUpDriver(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get(url);
//    }

    @Test
    public void checkMethods1() {
        openUrl("https://rozetka.com.ua/");
        maximizeWindow();
        WebElement searchFieldRozetka = driver.findElement(By.xpath("//input[@name ='search']"));
        searchElement1("//input[@name ='search']");
        clickElement(searchFieldRozetka);
        sendKeysElement(searchFieldRozetka, "iphone");
        clickEnter();
        closeBrowse();
    }
@Test
    public void checkMethods2(){
        openUrl("https://compx.ua/ru/");
        maximizeWindow();
        WebElement searchFieldCompx = driver.findElement(By.cssSelector("input.search__input"));
        searchElement2("input.search__input");
        clickElement(searchFieldCompx);
        sendKeysElement(searchFieldCompx, "iphone");
        clickElement(searchFieldCompx);
        clickEnter();
        closeBrowse();
    }

    public void openUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(url);
    }
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void closeBrowse(){
        driver.quit();
    }

//    public void

    public WebElement searchElement1(String xpathLocator){
        return driver.findElement(By.xpath(xpathLocator));
    }

    public List<WebElement> searchElements(String xpathLocator){
        return driver.findElements(By.xpath(xpathLocator));
    }

    public void switchNewTab (){
        List<String> windowHandles =new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(windowHandles.size()-1));
    }

//    public void switchOnTab (int index){
//        List<String> windowHandles =new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(driver.getWindowHandle());
//    }

    public WebElement searchElement2(String cssLocator){
        return driver.findElement(By.cssSelector(cssLocator));
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void sendKeysElement(WebElement element, String productName){
        element.sendKeys(productName);
    }
    public void clickEnter(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

//    public boolean isDisplayed (String ){
//
//    }

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
}
