package UI_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> cartInventoryItemsName;
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    List<WebElement> cartInventoryItemsPrice;
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getAllCartInventoryItemsName() {
        List<String> list = new ArrayList<>();
        cartInventoryItemsName.forEach(x -> list.add(x.getText()));
        return list;
    }

    public List<String> getAllCartInventoryItemsPrices() {
        List<String> list = new ArrayList<>();
        cartInventoryItemsPrice.forEach(x -> list.add(x.getText()));
        return list;
    }

    public void checkoutButtonClick() {
        checkoutButton.click();
    }

    public double getTotalPrice() {
        double sum = 0;
        for (int i = 0; i < cartInventoryItemsPrice.size(); i++) {
            String price = Arrays.stream(cartInventoryItemsPrice.get(i).getText().split("\\$")).collect(Collectors.toList()).get(1);
            sum = sum + Double.parseDouble(price);
        }
        return sum;
    }
}
