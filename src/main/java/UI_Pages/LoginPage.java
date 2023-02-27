package UI_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitButton;

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
