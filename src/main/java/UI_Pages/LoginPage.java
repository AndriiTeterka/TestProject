package UI_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement usernameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        usernameInput.click();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void submitButtonClick() {
        submitButton.click();
    }

    public void performSuccessfulLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        submitButtonClick();
    }
}
