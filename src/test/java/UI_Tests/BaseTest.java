package UI_Tests;

import UI_Pages.*;
import Utils.ConfigProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected CartPage cartPage;
    protected CheckoutPersonalInfoPage checkoutPersonalInfoPage;
    protected CheckoutOverviewPage checkoutOverviewPage;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        createWebDriver(browser);
        initPages();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigProvider.URL);
        loginPage.performSuccessfulLogin(ConfigProvider.USER_NAME, ConfigProvider.PASSWORD);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void initPages() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
        checkoutPersonalInfoPage = PageFactory.initElements(driver, CheckoutPersonalInfoPage.class);
        checkoutOverviewPage = PageFactory.initElements(driver, CheckoutOverviewPage.class);
    }

    private void createWebDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }
    }
}
