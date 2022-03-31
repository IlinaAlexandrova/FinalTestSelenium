package setup;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {

    @BeforeMethod
    public static void setupBrowser(){
        BrowserSettings.setUp();
    }

    @AfterMethod
    public static void quitBrowser(){
        BrowserSettings.tearDown();
    }
}
