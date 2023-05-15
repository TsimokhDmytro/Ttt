package SeleniumLessons.Lesson6.Pages;

import SeleniumLessons.Lesson6.helpers.RozetkaProductPageHelpers;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class RozetkaProductPage extends RozetkaProductPageHelpers {


    public RozetkaProductPage(WebDriver driver) {
        super(driver);
    }
    @Step("Click btn big tiles")
    public void clickBtnBigTiles() {
        getBtnBigTiles().click();
    }
    @Step("Click btn small tiles")
    public void clickBtnSmallTiles() {
        getBtnSmallTiles().click();
    }
    @Step("Does displayed btn big tiles")
    public boolean isDisplayedBigTiles() {
        return assertIsDisplayed(getBtnBigTiles());
    }
    @Step("Does displayed btn big tiles")
    public boolean isDisplayedSmallTiles() {
        return assertIsDisplayed(getBtnSmallTiles());
    }
    @Step("Get attribute class btn big tiles")
    public String attributeBigTiles(){
       return getAttributeBtnBigTiles("class");
    }
    @Step("Get attribute class btn small tiles")
    public String attributeSmallTiles(){
        return getAttributeBtnSmallTiles("class");
    }
    @Step("Get all attributes data-tile found products")
    public ArrayList<String> allAttributesFoundProducts(){
        return getAttributesListProduct("data-tile");
    }
    @Step("Get text that product no found")
    public String textProductNotFound(){
        return getTextProductNotFound();
    }
}
