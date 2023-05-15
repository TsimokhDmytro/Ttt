package SeleniumLessons.Lesson6.Tests;

import SeleniumLessons.Lesson6.Pages.RozetkaHomePage;
import SeleniumLessons.Lesson6.Pages.RozetkaProductPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaTestBtnTiles extends TestInit {

    @Test
    @Description("Checking changes after clicked to buttons big tiles and small tiles of displaying list" +
            "found products")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Tsimokh D. seniorQA")
    public void checkBtnTiles() {

        RozetkaHomePage homePage = new RozetkaHomePage(getDriver());

        homePage.openRozetka()
                .searchProduct("cars");

        RozetkaProductPage productPage = new RozetkaProductPage(getDriver());

        Assert.assertTrue(productPage.isDisplayedBigTiles());
        Assert.assertTrue(productPage.isDisplayedSmallTiles());
        Assert.assertTrue(productPage.attributeSmallTiles().contains("state_active"));
        Assert.assertFalse(productPage.attributeBigTiles().contains("state_active"));
        Assert.assertTrue(productPage.allAttributesFoundProducts().contains("small"));

        productPage.clickBtnBigTiles();

        Assert.assertTrue(productPage.attributeBigTiles().contains("state_active"));
        Assert.assertFalse(productPage.attributeSmallTiles().contains("state_active"));
        Assert.assertTrue(productPage.allAttributesFoundProducts().contains("big"));

        productPage.clickBtnSmallTiles();

        Assert.assertTrue(productPage.attributeSmallTiles().contains("state_active"));
        Assert.assertFalse(productPage.attributeBigTiles().contains("state_active"));
        Assert.assertTrue(productPage.allAttributesFoundProducts().contains("small"));
    }
}
