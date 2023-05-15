package SeleniumLessons.Lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lesson2HomeWork {
    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.manage().window().maximize();
        browser.get("https://rozetka.com.ua/");
        wait.until(ExpectedConditions.visibilityOf(browser.findElement(By.xpath("(//button[@class='header__button ng-star-inserted'])[2]")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='modal__close']"))).click();
        wait.until(ExpectedConditions.titleContains("≤нтернет-магазин ROZETKAЩ: оф≥ц≥йний сайт найпопул€рн≥шого онлайн-г≥пермаркету в ”крањн≥"));
    }
}
