package page.amazon;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageAmazon extends BasePage {
    public HomePageAmazon(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement inputSearch;

    @FindBy(id = "s-result-sort-select")
    private WebElement sortSelectBox;

    public void navigate(String url) {
        getDriver().get(url);
    }

    public void searchProduct(String name) {
        getWait().until(ExpectedConditions.visibilityOf(inputSearch));
        inputSearch.sendKeys(name);
        inputSearch.submit();
        getWait().until(ExpectedConditions.visibilityOf(sortSelectBox));
    }
}
