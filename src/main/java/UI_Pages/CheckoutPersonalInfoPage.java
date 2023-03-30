package UI_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPersonalInfoPage extends BasePage {

    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    public CheckoutPersonalInfoPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String name) {
        firstName.sendKeys(name);
    }

    public void enterLastName(String last) {
        lastName.sendKeys(last);
    }

    public void enterPostalCode(String code) {
        postalCode.sendKeys(code);
    }

    public void continueButtonClick() {
        continueButton.click();
    }


    public void enterPersonalInfoDetails(String name, String lastName, String zipCode) {
        enterFirstName(name);
        enterLastName(lastName);
        enterPostalCode(zipCode);
    }
}
