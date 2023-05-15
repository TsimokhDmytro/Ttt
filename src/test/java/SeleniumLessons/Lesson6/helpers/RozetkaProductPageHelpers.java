package SeleniumLessons.Lesson6.helpers;

import SeleniumLessons.Lesson6.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class RozetkaProductPageHelpers extends BasePage {

    private String btnBigTiles = "//rz-view-switch/div/button[1]";
    private String btnSmallTiles = "//rz-view-switch/div/button[2]";
    private String listFoundProducts = "//rz-grid/ul/li/rz-catalog-tile/app-goods-tile-default/div";
    private String productNotFound = "//span[@_ngcontent-rz-client-c105]";

    public RozetkaProductPageHelpers(WebDriver driver){
        super(driver);
    }

    public WebElement getBtnBigTiles(){
       return waitForClickableElement(btnBigTiles);
    }
    public WebElement getBtnSmallTiles(){
       return waitForClickableElement(btnSmallTiles);
    }

    public String getAttributeBtnBigTiles(String attribute){
        return getAttribute(btnBigTiles, attribute);
    }
    public String getAttributeBtnSmallTiles(String attribute){
        return getAttribute(btnSmallTiles, attribute);
    }
    public ArrayList<String> getAttributesListProduct(String attribute){
        return getAttributesElementsList(listFoundProducts, attribute);
    }
    public String getTextProductNotFound(){
        return getText(productNotFound);
    }
}
