package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.BrowserSettings;

public class SuccessfulRegisterPage {

    public static WebDriverWait waitThreeSeconds = new WebDriverWait(BrowserSettings.driver, 3);

    @FindBy(tagName = "h1")
    public static WebElement successfulRegister;

    static {
        PageFactory.initElements(BrowserSettings.driver, SuccessfulRegisterPage.class);
    }

    public static void validateSuccessfulRegister(){
        Assert.assertEquals(successfulRegister.getText(), "Your Account Has Been Created!");
    }
}
