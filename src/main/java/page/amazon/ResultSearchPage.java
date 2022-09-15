package page.amazon;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ResultSearchPage extends BasePage {

    public ResultSearchPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[@class=\"a-size-medium a-color-base a-text-normal\"]")
    private List<WebElement> results;

    @FindBy(xpath = "//span[@class=\"a-size-medium a-color-base a-text-normal\"]//parent::a")
    private List<WebElement> link;

    @FindBy(id = "s-result-sort-select")
    private WebElement sortSelectBox;

    @FindBy(xpath = "//span[@class=\"a-dropdown-container\"]")
    private WebElement selectBox;

    public boolean verifyProductMention(String nameProduct){
        getWait().until(ExpectedConditions.visibilityOfAllElements(results));
        return results.stream().filter(product -> product.getText().contains(nameProduct)).collect(Collectors.toList()).isEmpty();
    }

    public void sortByPrice(){
        Select selectBox = new Select(sortSelectBox);
        selectBox.selectByValue("price-asc-rank");
        getWait().until(ExpectedConditions.visibilityOfAllElements(results));
    }

    public String getTitleWebsite(){
        return getDriver().getTitle();
    }

    public void getLink(){
        for (WebElement element : link) {
            System.out.println(element.getAttribute("href"));
        }
    }

    public void getText(){
        for (WebElement element : results) {
            System.out.println(element.getText());
        }
    }
}
