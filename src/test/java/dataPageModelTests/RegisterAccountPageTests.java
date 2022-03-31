package dataPageModelTests;

import org.testng.annotations.Test;
import pages.RegisterAccountPage;

public class RegisterAccountPageTests extends DashboardUserPageTests{

    @Test
    public static void registerAccount(){
        RegisterAccountPage.registrateUser("Ilina", "Alexandrova");
    }
}
