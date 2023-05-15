package SeleniumLessons.Lesson6.Tests;

import SeleniumLessons.Lesson6.Pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.*;

public abstract class TestInit {

    //    WebDriver driver;
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TSIMOKH\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver.set(new ChromeDriver(chromeOptions));
        getDriver().manage().window().maximize();
//        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void closeBrowse() {
        getDriver().quit();
    }
}
