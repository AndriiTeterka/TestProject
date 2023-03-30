package UI_Tests;

import Utils.ConfigProvider;
import Utils.DataProviderClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class uiTests extends BaseTest {

    @Test(priority = 1)
    public void LoginTest() {
        Assert.assertEquals(homePage.getPageUrl(), ConfigProvider.URL + "inventory.html");
    }

    @Test(priority = 2)
    public void AddAllItemsToCart() {
        homePage.addAllItemsToCart();
        Assert.assertEquals(
                homePage.getAddedItemsToCartCounter(),
                String.valueOf(homePage.getAllInventoryItemsName().size()));
        Assert.assertEquals(homePage.getAddToCartButtonText(), "Remove");
    }

    @Test(priority = 3)
    public void verifyAddedItemsOnCart() {
        homePage.addAllItemsToCart();
        List<String> names = homePage.getAllInventoryItemsName();
        List<String> prices = homePage.getAllInventoryItemsPrice();
        homePage.cartLinkClick();
        List<String> cartNames = cartPage.getAllCartInventoryItemsName();
        List<String> cartPrices = cartPage.getAllCartInventoryItemsPrices();
        Assert.assertEquals(names, cartNames);
        Assert.assertEquals(prices, cartPrices);
    }

    @Test(dataProvider = "checkoutUser", dataProviderClass = DataProviderClass.class, priority = 4)
    public void verifyAddedItemsOnCheckoutOverview(String firstName, String lastName, String postalCode) {
        homePage.addAllItemsToCart();
        homePage.cartLinkClick();
        double cartTotalPrice = cartPage.getTotalPrice();
        cartPage.checkoutButtonClick();
        checkoutPersonalInfoPage.enterPersonalInfoDetails(firstName, lastName, postalCode);
        checkoutPersonalInfoPage.continueButtonClick();
        double checkoutTotalPrice = checkoutOverviewPage.getTotalPrice();
        Assert.assertEquals(cartTotalPrice, checkoutTotalPrice);
    }
}
