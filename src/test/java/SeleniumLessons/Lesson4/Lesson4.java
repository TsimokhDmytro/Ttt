package SeleniumLessons.Lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Lesson4 {
    @Test
    public void test() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TSIMOKH\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        WebDriverManager.chromiumdriver().setup();
        var driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
    }

//    public boolean isElementDisplay(WebDriver driver, String locator){
//        try{
//            driver.findElement("");
//
//        }catch (NoSuchElementException e){
//
//        }
//    }
}
