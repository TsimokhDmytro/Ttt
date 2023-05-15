package SeleniumLessons.Lesson6.Tests;

import SeleniumLessons.Lesson6.Pages.RozetkaHomePage;
import SeleniumLessons.Lesson6.Pages.RozetkaProductPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSearchFieldNegative extends TestInit {

    @DataProvider(parallel = true)
    public Object[][] setUp() {
        return new Object[][]{
                {"zdgsfgdfhjr"}, {"ыавркоyвапр"}, {"2565465656566"},
                {"@@@@"}, {"........"},
                {"%%%%%%"},
                {"******"}, {"}}}}}}"}, {")))))"}, {"((((("}, {"!!!!!"},
                {"+++++"}, {"-----"}, {"____"},
                {"$$$$"}, {"#####"}, {"&&&&&"}, {"^^^^^"}, {">>>>>"}, {"<<<<"}, {";;;;;"}, {":::::"}, {"  "}
////                {"====="},{",,,,,,,"},{""}
        };
    }

    String expectedResultText = "За заданими параметрами не знайдено жодної моделі";

    @Test(dataProvider = "setUp")
    @Description("Check search field with invalid data")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Tsimokh D. seniorQA")
    public void checkSearchFieldNegative(String invalidText) {

        RozetkaHomePage homePage = new RozetkaHomePage(getDriver());

        homePage.openRozetka()
                .searchProduct(invalidText);

        RozetkaProductPage productPage = new RozetkaProductPage(getDriver());

        Assert.assertEquals(productPage.textProductNotFound(), expectedResultText);
    }
}

