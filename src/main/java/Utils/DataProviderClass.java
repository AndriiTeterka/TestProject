package Utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "checkoutUser")
    public static Object[][] checkoutUser() {
        return new Object[][]{
                {"TestName", "TestUserName", "79000"},
        };
    }
}
