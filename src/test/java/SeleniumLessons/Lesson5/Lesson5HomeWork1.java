package SeleniumLessons.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Lesson5HomeWork1 {

    WebDriver driver;

    public void openUrl(String url) {
        WebDriverManager.chromedriver().setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver();
        driver.get(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void closeBrowse() {
        driver.quit();
    }

    public WebElement findElementByXpath(String xpathLocator) {
        return driver.findElement(By.xpath(xpathLocator));
    }

    public WebElement findElementByCss(String cssLocator) {
        return driver.findElement(By.cssSelector(cssLocator));
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void sendKeysElement(WebElement element, String productName) {
        element.sendKeys(productName);
    }

    public void clickEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public int printNumber(int a) {
        System.out.println(a);
        return a;
    }

    public int getStringLength(String srting1) {
        System.out.println("Srting lenght " + "'" + srting1 + "'" + " = " + srting1.length() + " chars");
        return srting1.length();
    }

    public void evenNumber(int chislo) {
        if (chislo % 2 == 0) {
            System.out.println("Число " + "'" + chislo + "'" + " є парне");
        } else {
            System.out.println("Число " + chislo + " не є парне");
        }
    }

    public String stringReverseStringBuffer(String string2) {
        System.out.print("Reverse string " + "'" + string2 + "'" + " 1-st method: " + "'" + new StringBuffer(string2).reverse() + "'");
        return new StringBuffer(string2).reverse().toString();
    }

    public String stringReverseStringBuilder(String string3) {
        StringBuilder sb = new StringBuilder(string3.length());
        for (int i = string3.length() - 1; i >= 0; i--) {
            sb.append(string3.charAt(i)).toString();
        }
        System.out.println("Reverse string " + "'" + string3 + "'" + " 2-nd method: " + "'" + sb + "'");
        return sb.toString();
    }
}
