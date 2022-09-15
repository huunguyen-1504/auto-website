package tests;

import core.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.amazon.HomePageAmazon;
import page.amazon.ResultSearchPage;

public class Amazon extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 0)
    @Parameters({"url", "nameProduct"})
    public void navigateAmazon(String urlWeb, String nameProduct){
        HomePageAmazon homePageAmazon = new HomePageAmazon(getDriver());
        homePageAmazon.navigate(urlWeb);
        homePageAmazon.searchProduct(nameProduct);
    }

    @Test(priority = 1)
    @Parameters({"url", "nameProduct"})
    public void verifyResults(String urlWeb, String nameProduct){
        ResultSearchPage resultSearchPage = new ResultSearchPage(getDriver());
        softAssert.assertEquals(resultSearchPage.verifyProductMention(nameProduct),false, "No product mention in results page");
        resultSearchPage.sortByPrice();
        System.out.println("===============================================================");
        System.out.println("Title is: " + resultSearchPage.getTitleWebsite());
        resultSearchPage.getLink();
        resultSearchPage.getText();
        softAssert.assertAll("At least one condition fail");
    }

}
