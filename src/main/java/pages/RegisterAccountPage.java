package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BrowserSettings;

public class RegisterAccountPage {

    public static WebDriverWait waitThreeSeconds = new WebDriverWait(BrowserSettings.driver, 3);

    @FindBy(css = ".btn-primary")
    public static WebElement continueButtonRegistrationField;

    @FindBy(id = "input-firstname")
    public static WebElement firstNameRegistrationField;

    @FindBy(id = "input-lastname")
    public static WebElement lastNameRegistrationField;

    @FindBy(id = "input-email")
    public static WebElement emailRegistrationField;

    @FindBy(id = "input-telephone")
    public static WebElement phoneNumberRegistrationField;

    @FindBy(id = "input-password")
    public static WebElement passwordRegistrationField;

    @FindBy(id = "input-confirm")
    public static WebElement confirmPasswordRegistrationField;

    @FindBy(css = "[name='newsletter']:nth-of-type(1)")
    public static WebElement yesToNewsletterRegistrationField;

    @FindBy(name = "agree")
    public static WebElement privacyPolicyRegistrationField;

    static {
        PageFactory.initElements(BrowserSettings.driver, RegisterAccountPage.class);
    }

    public static void registrateUser(String firstName, String lastName){

        DashboardUserPage.goTo();
        DashboardUserPage.goToRegisterAccountPage();

        String emailRandom = RandomStringUtils.randomAlphanumeric(5) + "@" + RandomStringUtils.randomAlphabetic(3) + "." + RandomStringUtils.randomAlphabetic(3);
        String phoneNumber = RandomStringUtils.randomNumeric(10);
        String pass = RandomStringUtils.randomAlphanumeric(5);

        waitThreeSeconds.until(ExpectedConditions.visibilityOf(continueButtonRegistrationField));

        firstNameRegistrationField.sendKeys(firstName);
        lastNameRegistrationField.sendKeys(lastName);
        emailRegistrationField.sendKeys(emailRandom);
        phoneNumberRegistrationField.sendKeys(phoneNumber);
        passwordRegistrationField.sendKeys(pass);
        confirmPasswordRegistrationField.sendKeys(pass);

        if (!yesToNewsletterRegistrationField.isSelected()){
            yesToNewsletterRegistrationField.click();
        }

        if (!privacyPolicyRegistrationField.isSelected()){
            privacyPolicyRegistrationField.click();
        }

        continueButtonRegistrationField.click();
    }

}
