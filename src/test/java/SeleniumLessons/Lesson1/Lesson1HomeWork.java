package SeleniumLessons.Lesson1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lesson1HomeWork {
    @Test
    public static void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        WebDriverWait wait2 = new WebDriverWait(browser,Duration.ofSeconds(5));
        browser.get("https://rozetka.com.ua/");

        JavascriptExecutor js = (JavascriptExecutor) browser;
//By Web element
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        browser.findElement(By.xpath("//div[@class='main-sidebar__block main-copyright']//img[@alt='MasterCard Secure']")).click();
        browser.findElement(By.xpath("//button[@class='modal__close']")).click();
//By Web element+JavascriptExecutor
        WebElement element = browser.findElement(By.xpath("//div[@class='main-sidebar__block main-copyright']//img[@alt='Visa Verified']"));
        js.executeScript("arguments[0].click();", element);
        browser.findElement(By.xpath("//button[@class='modal__close']")).click();
//By JavascriptExecutor
        js.executeScript("document.getElementsByClassName('payments-buttons__button')[2].click()");
        browser.findElement(By.xpath("//button[@class='modal__close']")).click();
        js.executeScript("document.getElementsByClassName('modal__close')[1].click()");

//        clickElement.executeScript("simulateClick(document.getElementByXPath(\"//div[@class='main-sidebar__block main-copyright']//img[@alt='Visa Verified']\"))");
//        clickElement.executeScript("simulateClick(document.getElementByXPath('//div[@class='main-sidebar__block main-copyright']//img[@alt='Visa Verified'])");
//        js.executeScript("arguments[0].click","lokator");
    }
}
