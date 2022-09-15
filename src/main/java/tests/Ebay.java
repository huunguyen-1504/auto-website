package tests;

import core.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.ebay.HomeEbayPage;
import page.ebay.ResultSearchPage;

public class Ebay extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 0)
    @Parameters({"url", "nameProduct"})
    public void navigateAmazon(String urlWeb, String nameProduct){
        HomeEbayPage homeEbayPage = new HomeEbayPage(getDriver());
        homeEbayPage.navigate(urlWeb);
        homeEbayPage.searchProduct(nameProduct);
    }

    @Test(priority = 1)
    @Parameters({"nameProduct"})
    public void verify(String nameProduct){
        ResultSearchPage searchPage = new ResultSearchPage(getDriver());
        searchPage.sortPrice();
        softAssert.assertEquals(searchPage.verifyProductMention(nameProduct),false, "No product mention in results page");
        searchPage.getAllProduct();
        searchPage.getAllLink();
        searchPage.getTitle();
        softAssert.assertAll("At least one condition fail");
    }
}
