package UI_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> checkoutInventoryItemsName;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    List<WebElement> checkoutInventoryItemsPrice;

    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    WebElement totalPrice;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getAllCartInventoryItemsName() {
        List<String> list = new ArrayList<>();
        checkoutInventoryItemsName.forEach(x -> list.add(x.getText()));
        return list;
    }

    public List<String> getAllCartInventoryItemsPrices() {
        List<String> list = new ArrayList<>();
        checkoutInventoryItemsPrice.forEach(x -> list.add(x.getText()));
        return list;
    }

    public void finishButtonClick() {
        finishButton.click();
    }

    public Double getTotalPrice() {
        String price = Arrays.stream(totalPrice.getText().split("\\$")).collect(Collectors.toList()).get(1);
        return Double.valueOf(price);
    }
}
