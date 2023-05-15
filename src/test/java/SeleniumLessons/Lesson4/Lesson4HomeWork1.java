package SeleniumLessons.Lesson4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lesson4HomeWork1 {
    @Test
    public void test() {

        WebDriverManager.chromedriver().setup();
        var driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        driver.close();
    }
}
