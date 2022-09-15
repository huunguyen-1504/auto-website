package page.ebay;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class ResultSearchPage extends BasePage {

    public ResultSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()=\"Best Match\"]")
    private WebElement buttonSort;

    @FindBy(xpath = "//span[text()=\"Price + Shipping: lowest first\"]")
    private WebElement selectSort;

    @FindBy(xpath = "//div[@class=\"s-item__wrapper clearfix\"]")
    private List<WebElement> elements;

    @FindBy(xpath = "//div[@class=\"s-item__title\"]")
    private List<WebElement> titleProduct;

    @FindBy(xpath = "//div[@class=\"s-item__title\"]//parent::a")
    private List<WebElement> allLink;

    public void sortPrice(){
        buttonSort.click();
        getWait().until(ExpectedConditions.visibilityOf(selectSort));
        selectSort.click();
        getWait().until(ExpectedConditions.visibilityOfAllElements(titleProduct));
    }

    public boolean verifyProductMention(String nameProduct){
        getWait().until(ExpectedConditions.visibilityOfAllElements(titleProduct));
        return titleProduct.stream().filter(product -> product.getText().contains(nameProduct)).collect(Collectors.toList()).isEmpty();
    }

    public void getAllProduct(){
        for (WebElement element : titleProduct){
            System.out.println(element.getText());
        }
    }

    public void getAllLink(){
        for (WebElement element : allLink){
            System.out.println(element.getText());
        }
    }

    public String getTitle(){
       return getDriver().getTitle();
    }
}
