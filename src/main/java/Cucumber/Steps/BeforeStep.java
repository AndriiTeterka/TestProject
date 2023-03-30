package Cucumber.Steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import org.openqa.selenium.chrome.ChromeOptions;

public class BeforeStep {
    @Given("Opening site {string}")
    public void openUrl(String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = options;
        Selenide.open(url);
    }
}
