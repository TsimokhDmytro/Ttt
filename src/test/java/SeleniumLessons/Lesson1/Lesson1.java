package SeleniumLessons.Lesson1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class Lesson1 {
    public static void main(String[] args) {
//        System.setProperty("age","35");
//        String str = System.getProperty("os/name");

        WebDriverManager.chromedriver().setup();
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        WebDriverWait wait2 = new WebDriverWait(browser,Duration.ofSeconds(5));
//        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        browser.get("https://rozetka.com.ua/");
//        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        browser.manage().logs();

        JavascriptExecutor js = (JavascriptExecutor) browser;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        browser.findElement(By.xpath("//div[@class='main-sidebar__block main-copyright']//img[@alt='MasterCard Secure']")).click();
        browser.findElement(By.xpath("//button[@class='modal__close']")).click();
    }
}


//    @BeforeMethod
//    public void setupDriver() {
//        WebDriverManager.chromedriver().setup();
////        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TSIMOKH\\Downloads\\chromedriver_win32\\chromedriver.exe");
////        ChromeOptions options = new ChromeOptions();
////        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver();
//    }