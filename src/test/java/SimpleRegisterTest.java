import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleRegisterTest {

    static WebDriver driver;
    static WebDriverWait waitThreeSeconds;

    @BeforeMethod
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Petar\\Desktop\\Selenium\\BrowsersDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        waitThreeSeconds = new WebDriverWait(driver, 3);
        driver.get("http://shop.pragmatic.bg/");
    }

    @AfterMethod
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public static void registerNewCustomer(){

        WebElement myAccount = driver.findElement(By.cssSelector(".fa.fa-user"));
        myAccount.click();

        WebElement registerDropDown = waitThreeSeconds.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dropdown-menu-right li:nth-of-type(1)")));
        registerDropDown.click();

        waitThreeSeconds.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".btn-primary")));

        WebElement firstNameRegistrationField = driver.findElement(By.id("input-firstname"));
        firstNameRegistrationField.sendKeys("Ilina");

        WebElement lastNameRegistrationField = driver.findElement(By.id("input-lastname"));
        lastNameRegistrationField.sendKeys("Alexandrova");

        String emailRandom = RandomStringUtils.randomAlphanumeric(5) + "@" + RandomStringUtils.randomAlphabetic(3) + "." + RandomStringUtils.randomAlphabetic(3);
        WebElement emailRegistrationField = driver.findElement(By.id("input-email"));
        emailRegistrationField.sendKeys(emailRandom);

        String phoneNumber = RandomStringUtils.randomNumeric(10);
        WebElement telephoneRegistrationField = driver.findElement(By.id("input-telephone"));
        telephoneRegistrationField.sendKeys(phoneNumber);

        String pass = RandomStringUtils.randomAlphanumeric(5);
        WebElement passwordRegistrationField = driver.findElement(By.id("input-password"));
        passwordRegistrationField.sendKeys(pass);

        WebElement confirmPasswordRegistrationField = driver.findElement(By.id("input-confirm"));
        confirmPasswordRegistrationField.sendKeys(pass);

        WebElement yesToNewsletterRegistrationField = driver.findElement(By.cssSelector("[name='newsletter']:nth-of-type(1)"));
        if (!yesToNewsletterRegistrationField.isSelected()){
            yesToNewsletterRegistrationField.click();
        }

        WebElement privacyPolicyRegistrationField = driver.findElement(By.name("agree"));
        if (!privacyPolicyRegistrationField.isSelected()){
            privacyPolicyRegistrationField.click();
        }

        WebElement continueButtonRegistrationField = driver.findElement(By.cssSelector(".btn-primary"));
        continueButtonRegistrationField.click();

        WebElement successfulRegister = waitThreeSeconds.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));
        Assert.assertEquals(successfulRegister.getText(), "Your Account Has Been Created!");








    }

}
