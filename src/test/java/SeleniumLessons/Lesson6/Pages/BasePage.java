package SeleniumLessons.Lesson6.Pages;

import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Log4j
public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Duration TIMEOUT = Duration.ofSeconds(15);

    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, TIMEOUT);
        this.driver = driver;
    }


    public void openUrl(String url) {
        driver.get(url);
    }

public WebElement findElementBy(String xpath) {
    return driver.findElement(By.xpath(xpath));
}

    public List<WebElement> findElementsBy(String xpath) {
       return driver.findElements(By.xpath(xpath));
    }
    /**
     * This method returns WebElement by xpath. This method uses method "findClickableElementBy(xpath)" which used
     * method "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))" and accepts string parameter
     * "xpath"
     */
    public WebElement getElement(String xpath) {
        waitForClickableElement(xpath);
        waitForVisibleElement(xpath);
        return findElementBy(xpath);
    }


    //    @Step("Find clickable element By xpath")
    public WebElement waitForClickableElement(String xpath) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    //    @Step("Find clickable element By element")
    public WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //    @Step("Find visible element By xpath")
    public WebElement waitForVisibleElement(String xpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    //    @Step("Find visible element By element")
    public WebElement waitForVisibleElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //    @Step("Find list with visibility of all elements By path")
    public List<WebElement> waitForVisibilityOfAllElements(String xpath) {
        return Allure.step("Waiting for visibility of all elements By %s" + xpath,
                () -> wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))));
    }

    //    @Step("Find list with visibility of all elements By element")
    public List<WebElement> waitForVisibilityOfAllElements(WebElement element) {
        return Allure.step("Waiting for visibility of all elements By %s" + element,
                () -> wait.until(ExpectedConditions.visibilityOfAllElements(element)));
    }


    //    @Step("Switch new tab")
    public BasePage switchNewTab() {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
        return this;
    }

    //    @Step("Switch on tab")
    public BasePage switchOnTab(int index) {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(index));
        return this;
    }

    //    @Step("Wait for is selected element By xpath")
    public void waitForElementToBeSelected(String xpath) {
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
    }

    //    @Step("Wait for is selected element By element")
    public void waitForElementToBeSelected(WebElement element) {
       wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    //    @Step("Assert is selected element By xpath")
//    public boolean assertIsSelectedElement(String xpath) {
//        return waitForElementToBeSelected(xpath).isSelected();
//    }

//    //    @Step("Assert is selected element By element")
//    public boolean assertIsSelectedElement(WebElement element) {
//        return waitForElementToBeSelected(element).isSelected();
//    }

    /**
     * An expectation for checking the element to be invisible
     * This method expects for checking the element to be invisible and returns "true" if the element will be invisible.
     * on the page. This method uses wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath)))).
     * This method accepts parameter WebDriver "driver" and string parameter "xpath"
     */

    public boolean isElementNoDisplay(String xpath) {
        return wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
    }

    /**
     * This method returns true if finding elements by WebElement will not be display on the page and returns false
     * if finding element will be display. This method uses "try" "catch" blocks with method
     * "findClickableElementBy(element)" which used "wait.until(ExpectedConditions.elementToBeClickable(element))".
     * This method accepts parameter WebDriver "driver" and string parameter "xpath"
     */
    public boolean isElementsNoDisplay(String xpath) {
        return wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath(xpath))));
    }

    /**
     * This method returns true if the finding element by WebElement will not be display and returns false if finding
     * element will be display on the page. This method uses "try" "catch" blocks with method
     * "findClickableElementBy(element)" which used "wait.until(ExpectedConditions.elementToBeClickable(element))".
     * This method accepts parameter WebDriver "driver" and string parameter "xpath"
     */
    public boolean isElementNotDisplayed(WebDriver driver, WebElement element) {
//        try {
        waitForClickableElement(element).isDisplayed();
        return false;
//        } catch (NoSuchElementException e) {
//            Allure.step(String.format("Actual result: element %s was found on the page, but expected result: " +
//                    "element %s was not found on the page"));
//            return true;
//        }
    }

    /**
     * This method returns true if the finding element by xpath will not be displayed on the page and returns false if
     * finding element will be display. This method uses "try" "catch" blocks with method
     * "findClickableElementBy(xpath)" which used "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))".
     * This method accepts parameter WebDriver "driver" and string parameter "xpath"
     */
    public boolean isElementNoDisplay(WebDriver driver, String xpath) {
        try {
            waitForClickableElement(xpath).isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("Actual result: element " + xpath + "was found on the page, but expected result: " +
                    "element " + xpath + "was not found on the page");
        }
        return true;
    }

    /**
     * This method returns WebElement by WebElement. This method uses method "findClickableElementBy(element)" which
     * used method "wait.until(ExpectedConditions.elementToBeClickable(element))" and accepts WebElement parameter
     * "element"
     */
//    public WebElement getElement(WebElement element) {
//        return waitForClickableElement(element);
//    }

    /**
     * This method returns WebElement by xpath. This method uses method "findClickableElementBy(xpath)" which used
     * method "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))" and accepts string parameter
     * "xpath"
     */
//    public WebElement getElement(String xpath) {
//        return getElementBy(xpath);
//    }

    /**
     * This method clicks on element by xpath. This method uses method "getElement(xpath)" which used method
     * "findClickableElementBy(xpath)" which used method
     * "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))" and accepts string parameter "xpath"
     */
    public void clickOnElement(String xpath) {
        getElement(xpath).click();
    }

    /**
     * This method clicks on element by WebElement.This method uses method "getElement(element)" which used method
     * "findClickableElementBy(element)" which used method
     * "wait.until(ExpectedConditions.elementToBeClickable(element))" and accepts WebElement parameter "element"
     */
    public void clickOnElement(WebElement element) {
        getElement(element).click();
    }

    /**
     * This method returns string text of the element by WebElement. This method uses method
     * "findClickableElementBy(element)" which used "wait.until(ExpectedConditions.elementToBeClickable(element))"
     * and accepts WebElement parameter "element"
     */
    public String getText(WebElement element) {
        return waitForClickableElement(element).getText();
    }

    /**
     * This method returns string text of the element by xpath. This method uses method "findClickableElementBy(xpath)"
     * which used "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))" and accepts string parameter
     * "xpath"
     */
    public String getText(String xpath) {
        return waitForClickableElement(xpath).getText();
    }

    /**
     * This method sends keys to element by xpath. This method uses method "findClickableElementBy(xpath)"
     * which used "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))". This method accepts two
     * string parameters "xpath" and "text"
     */
    public void sendKeys(String xpath, String text) {
        waitForClickableElement(xpath).sendKeys(text);
    }

    /**
     * This method sends keys to element by WebElement. This method uses method "findClickableElementBy(element)"
     * which used "wait.until(ExpectedConditions.elementToBeClickable(element))". This method accepts WebElement
     * parameter "element" and string parameter "text"
     */
    public void sendKeys(WebElement element, String text) {
        waitForClickableElement(element).sendKeys(text);
    }

    /**
     * This method returns string value of the element by attribute name. This method uses method
     * "findClickableElementBy(element)" which used "wait.until(ExpectedConditions.elementToBeClickable(element))"
     * and accepts WebElement parameter "element" and string parameter "attributeName"
     */
    public String getAttribute(WebElement element, String attributeName) {
        return waitForClickableElement(element).getAttribute(attributeName);
    }

    /**
     * This method returns "true" if the current page will be expected url. This method uses method
     * "wait.until(ExpectedConditions.urlToBe(url))" and accepts string parameter expected "url"
     */
    public boolean waitCurrentUrl(String url) {
        return wait.until(ExpectedConditions.urlToBe(url));
    }

    /**
     * This method returns ArrayList<String> attributes of any elements from list. This method uses method
     * "findListWithVisibilityOfAllElementsBy(xpath)" which used
     * "wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))))" and gets any
     * attributes by cycle "for". This method accepts string parameters "xpath" and "attributeName"
     */
    public ArrayList<String> getAttributesElementsList(String xpath, String attributeName) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<WebElement> listElements = waitForVisibilityOfAllElements(xpath);
        for (int i = 0; i < listElements.size(); i++) {
            String getAttribute = listElements.get(i).getAttribute(attributeName);
            arrayList.add(getAttribute);
        }
        return arrayList;
    }

    /**
     * This method imitates press the key "ENTER" of a keyboard
     */
    public void pressEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    /**
     * This method returns "true" if the element will be selected. This method uses method
     * "findClickableElementBy(xpath)" which used "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))"
     * and accepts string parameter "xpath"
     */
    public boolean assertIsSelected(String xpath) {
        return waitForClickableElement(xpath).isSelected();
    }

    /**
     * This method returns "true" if the element will be displayed. This method uses method "findClickableElementBy(xpath)"
     * which used "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))" and accepts string
     * parameter "xpath"
     */
    public boolean assertIsDisplayed(String xpath) {
        return waitForClickableElement(xpath).isDisplayed();
    }

    /**
     * This method returns "true" if the element will be displayed. This method uses method
     * "findClickableElementBy(element)" which used "wait.until(ExpectedConditions.elementToBeClickable(element))" and
     * accepts WebElement parameter "element"
     */
    public boolean assertIsDisplayed(WebElement element) {
        return waitForClickableElement(element).isDisplayed();
    }

    /**
     * This method returns "true" if the element will be enabled. This method uses method "findClickableElementBy(xpath)"
     * which used "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))" and accepts string parameter
     * "xpath"
     */
    public boolean assertIsEnabled(String xpath) {
        return waitForClickableElement(xpath).isEnabled();
    }

    /**
     * This method returns "true" if the element is enabled. This method uses method "findClickableElementBy(element)"
     * which used "wait.until(ExpectedConditions.elementToBeClickable(element))" and accepts WebElement parameter
     * "element"
     */
    public boolean assertIsEnabled(WebElement element) {
        return waitForClickableElement(element).isEnabled();
    }

    /**
     * This method returns string attribute of the element. This method uses method "findClickableElementBy(xpath)"
     * which used "wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))". This method accepts
     * string parameters "xpath" and "attributeName"
     */
    public String getAttribute(String xpath, String attributeName) {
        return waitForClickableElement(xpath).getAttribute(attributeName);
    }
}
