package Cucumber.Steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;

public class AfterStep {

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @io.cucumber.java.AfterStep
    public void makeScreenshot() {
        Selenide.screenshot(System.currentTimeMillis() + "step");
    }
}
