package UI_Pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeTest
    public void init() {
        setUp();
    }

    @AfterTest
    public void shutDown() {
        Selenide.closeWebDriver();
    }
}
