package Beymen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BeymenElements {

    public BeymenElements(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[placeholder=\"Ürün, Marka Arayın\"]")
    public WebElement searchBox;

    @FindBy(css = "[class='col-sm-4 col-md-4 col-lg-4 col-xl-4 col-xxl-3 o-productList__itemWrapper']")
    public List<WebElement> productList;

    @FindBy(css = "[class='o-productDetail__description']")
    public WebElement productInf;

    @FindBy(id = "priceNew")
    public WebElement productPrice;

    @FindBy(id = "addBasket")
    public WebElement addBasket;

    @FindBy(xpath = "//div[@class='m-variation']/span")
    public WebElement selectSize;

    @FindBy(xpath = "//span[contains(text(), 'Sepetim')]")
    public WebElement basket;

    @FindBy(xpath = "(//span[@class='m-orderSummary__value'])[3]")
    public WebElement basketPrice;

    @FindBy(id = "quantitySelect0-key-0")
    public WebElement quantity;
    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cookies;

    @FindBy(css = "[class='m-notification__button btn']")
    public WebElement alertBasket;

    @FindBy(css = "[class='m-orderSummary__item -grandTotal'] span+ span")
    public WebElement newBasketPrice;

}
