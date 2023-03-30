package Cucumber.Steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;

import static com.codeborne.selenide.Selenide.$x;

public class LoginStep3 {
    private final SelenideElement submitButton = $x("//button[@id='submit']");

    @And("User clicked submit button")
    public void userClickedSubmitButton() {
        submitButton.click();
    }
}
