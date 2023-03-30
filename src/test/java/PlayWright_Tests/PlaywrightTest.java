package PlayWright_Tests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PlaywrightTest {

    private Browser browser;
    private Page page;
    private BrowserContext browserContext;

    @BeforeSuite
    public void launchBrowser() {
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeTest
    public void createContextAndPage() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @Test
    public void playwrightDataShuffleTest() {
        page.navigate("https://datatables.net/examples/api/form.html");
        page.selectOption("//*[@name='example_length']", "100");
        page.locator("//input[contains(@id,'age')]")
                .all()
                .forEach(x -> x.fill(String.valueOf(ThreadLocalRandom.current().nextInt(18, 55))));
        page.locator("//input[contains(@id,'position')]")
                .all()
                .forEach(x -> {
                    List<String> positionsList = new ArrayList<>();
                    positionsList.add(x.inputValue());
                    x.fill(positionsList.get(ThreadLocalRandom.current().nextInt(0, positionsList.size())));
                });
        List<String> officeList = List.of(page.locator("//select[contains(@id,'office')]")
                .first()
                .allTextContents()
                .get(0)
                .replaceAll("\t", "")
                .trim()
                .split("\n{3}"));

        page.locator("//select[contains(@id,'office')]")
                .all()
                .forEach(x -> x.selectOption(officeList.get(ThreadLocalRandom.current().nextInt(0, officeList.size()))));
    }

    @AfterTest
    public void closeContext() {
        browserContext.close();
    }

    @AfterSuite
    public void closeBrowser() {
        browser.close();
    }
}
