package SeleniumLessons.Lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lesson4HomeWork2 {
    @Test
    public void test() {

        WebDriverManager.chromiumdriver().setup();
        var driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        driver.close();
    }
}
