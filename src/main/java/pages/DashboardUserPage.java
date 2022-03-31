package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BrowserSettings;

public class DashboardUserPage {

    public static WebDriverWait waitThreeSeconds = new WebDriverWait(BrowserSettings.driver, 3);

    @FindBy(css = ".fa.fa-user")
    public static WebElement myAccount;

    @FindBy(css = ".dropdown-menu-right li:nth-of-type(1)")
    public static WebElement registerDropDown;

    static {
        PageFactory.initElements(BrowserSettings.driver, DashboardUserPage.class);
    }

        /**
     * this method makes browser goes to first page
    */
    public static void goTo(){
    BrowserSettings.driver.get("http://shop.pragmatic.bg/");
}
    /**
     * this method clicked myAccount and goes to Register Account Page
     */
    public static void goToRegisterAccountPage() {
        myAccount.click();
        waitThreeSeconds.until(ExpectedConditions.visibilityOf(registerDropDown));
        registerDropDown.click();
}

}
