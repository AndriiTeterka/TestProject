package Cucumber.Steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$x;

public class LoginStep1 {
    private final SelenideElement loginInput = $x("//input[@id='username']");

    @When("User entered correct email")
    public void userEnteredCorrectEmail() {
        loginInput.sendKeys("student");
    }
}
