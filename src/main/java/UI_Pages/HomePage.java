package UI_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    List<WebElement> inventoryItemsName;

    @FindBy(xpath = "//*[@class='inventory_item_price']")
    List<WebElement> inventoryItemsPrice;
    @FindBy(xpath = "//div[@class='pricebar']/button")
    List<WebElement> addToCartButtons;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement addedItemsToCartCounter;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public List<String> getAllInventoryItemsName() {
        List<String> list = new ArrayList<>();
        inventoryItemsName.forEach(x -> list.add(x.getText()));
        return list;
    }

    public String getAddedItemsToCartCounter() {
        return addedItemsToCartCounter.getText();
    }

    public void addAllItemsToCart() {
        for (WebElement button : addToCartButtons
        ) {
            button.click();
        }
    }

    public String getAddToCartButtonText() {
        return addToCartButtons.stream().map(WebElement::getText).findAny().get();
    }

    public List<String> getAllInventoryItemsPrice() {
        List<String> list = new ArrayList<>();
        inventoryItemsPrice.forEach(x -> list.add(x.getText()));
        return list;
    }

    public void cartLinkClick() {
        cartLink.click();
    }
}
