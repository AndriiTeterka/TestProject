package UI_Tests;

import Utils.DataProviderClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class uiTests extends BaseTest {

    @Test(dataProvider = "testData", dataProviderClass = DataProviderClass.class)
    public void LoginTest(String username, String password, String expectedOutput) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage.performSuccessfulLogin(username, password);
        Assert.assertEquals(homePage.getSuccessTitle(), expectedOutput);
    }
}
