package Cucumber.Steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.$x;

public class LoginStep4 {
    private final SelenideElement successLoginTitle = $x("//h1[@class='post-title']");

    @Then("Home page is displayed")
    public void homePageIsDisplayed() {
        successLoginTitle.shouldBe(Condition.visible);
    }
}
