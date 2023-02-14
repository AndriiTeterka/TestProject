package UI_Tests;

import UI_Pages.BaseTest;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.$x;

public class uiTests extends BaseTest {

    private void assertAnswer(String value) {
        Selenide.open("https://www.google.com/");
        $x("//input[@name='q']").sendKeys(value + "=" + Keys.ENTER);
        String answer = $x("//span[@id='cwos']").getText();
        Assert.assertEquals("4", answer);
    }

    @Test
    public void calcPlusTest() {
        assertAnswer("2+2");
    }

    @Test
    public void calcPlusTest2() {
        assertAnswer("1+3");
    }


    @Test
    public void calcMinusTest() {
        assertAnswer("6-2");
    }

    @Test
    public void calcMultiplyTest() {
        assertAnswer("2*2");
    }

    @Test
    public void calcDivideTest() {
        assertAnswer("8/2");
    }

}
