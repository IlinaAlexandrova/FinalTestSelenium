package dataPageModelTests;

import org.testng.annotations.Test;
import pages.DashboardUserPage;
import setup.BaseTests;

public class DashboardUserPageTests extends BaseTests {

    @Test
    public static void goToRegistrationForm(){
        DashboardUserPage.goTo();
        DashboardUserPage.goToRegisterAccountPage();
        }

}
