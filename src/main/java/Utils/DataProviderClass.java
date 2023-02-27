package Utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "testData")
    public static Object[][] provideTestData() {
        return new Object[][]{
                {"student", "Password123", "Logged In Successfully"},
        };
    }
}
