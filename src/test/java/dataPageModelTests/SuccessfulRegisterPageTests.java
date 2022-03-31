package dataPageModelTests;

import org.testng.annotations.Test;
import pages.DashboardUserPage;
import pages.RegisterAccountPage;
import pages.SuccessfulRegisterPage;
import setup.BaseTests;

public class SuccessfulRegisterPageTests extends RegisterAccountPageTests {

    @Test
    public static void validateRegister(){
        RegisterAccountPage.registrateUser("Ilina", "Alexandrova");
        SuccessfulRegisterPage.validateSuccessfulRegister();

    }
}
