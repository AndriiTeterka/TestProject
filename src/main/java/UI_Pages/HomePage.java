package UI_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='post-title']")
    WebElement successLoginTitle;

    @FindBy(xpath = "//a[contains(@class, 'button')]")
    WebElement logOutButton;

    public String getSuccessTitle() {
        return successLoginTitle.getText();
    }

    public void logOutButtonClick() {
        logOutButton.click();
    }
}
