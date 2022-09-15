package page.ebay;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomeEbayPage extends BasePage {

    public HomeEbayPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gh-ac")
    private WebElement inputSearch;

    @FindBy(xpath = "//span[text()=\"Best Match\"]")
    private WebElement buttonSort;

    @FindBy(xpath = "//span[text()=\"Price + Shipping: lowest first\"]")
    private WebElement selectSort;

    @FindBy(xpath = "//div[@class=\"s-item__wrapper clearfix\"]")
    private List<WebElement> elements;

    public void navigate(String url){
        getDriver().get(url);
    }

    public void searchProduct(String nameProduct){
        getWait().until(ExpectedConditions.visibilityOf(inputSearch));
        inputSearch.sendKeys(nameProduct);
        inputSearch.submit();
        getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
