package UI_Tests;

import UI_Pages.BaseTest;
import Utils.TestListener;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.$x;

public class uiTests extends BaseTest {


    @Step("Search value on google")
    private void assertAnswer(String value) {
        Selenide.open("https://www.google.com/");
        $x("//input[@name='q']").sendKeys(value + "=" + Keys.ENTER);
        String answer = $x("//span[@id='cwos']").getText();
        Assert.assertEquals("4", answer);
    }


    @Description("2+2 test")
    @Test
    public void calcPlusTest() {
        assertAnswer("2+2");
    }

    @Description("1+3 test")
    @Test
    public void calcPlusTest2() {
        assertAnswer("1+3");
    }

    @Description("6-2 test")
    @Test
    public void calcMinusTest() {
        assertAnswer("1+14");
    }

    @Description("2*2 test")
    @Test
    public void calcMultiplyTest() {
        assertAnswer("2*2");
    }

    @Description("8/2 test")
    @Test
    public void calcDivideTest() {
        assertAnswer("8/2");
    }

}
