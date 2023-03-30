package Cucumber.Steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;

import static com.codeborne.selenide.Selenide.$;

public class LoginStep2 {
    private final SelenideElement passwordInput = $("#password");

    @And("User entered correct password")
    public void userEnteredCorrectPassword() {
        passwordInput.sendKeys("Password123");
    }
}
