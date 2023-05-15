package SeleniumLessons.Lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Lesson2 {
    public static void main(String[] args) {
//        System.setProperty("age","35");
//        String str = System.getProperty("os/name");

        WebDriverManager.chromedriver().setup();
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
//        WebElement element = new (new WebDriverWait(browser, 3)).until(ExpectedCondition.pre)
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        browser.get("https://rozetka.com.ua/");

//        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        browser.manage().logs();

        Actions actions = new Actions(browser);
//        actions.doubleClick(element).click().keyDown(Keys.ALT).;

        WebElement element2 = browser.findElement(By.xpath("//input [@name='search']"));
        element2.sendKeys("654654");
        actions.doubleClick(element2).keyDown(Keys.BACK_SPACE).perform();
//3-я версия
//        WebDriverWait wait = new WebDriverWait(browser, 5);
//4-я версия
        WebDriverWait wait2 = new WebDriverWait(browser,Duration.ofSeconds(5));

//        wait.until(webDriver ->)
//        почитать
//                wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input [@name='search']")));
    }
}
