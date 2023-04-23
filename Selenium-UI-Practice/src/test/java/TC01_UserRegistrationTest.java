import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupLoginPage;
import pages.SignupPage;

import java.time.Duration;

public class TC01_UserRegistrationTest extends testBase{

    @Test
    public void verifyThatUserCanRegisterSuccessfully() {

        new SignupLoginPage(driver)
                .clickOnSignupLoginButton();

        new SignupLoginPage(driver)
                .setSignupName()
                .setSignupEmail()
                .clickOnSignupButton();

        new SignupPage(driver)
                .signUpActions()
                .assertThatAccountCreatedSuccessfully()
                .clickOnContinueButton();
               // .clickOnCloseAd()
               // .clickOnContinueButton()

        new HomePage(driver)
                .clickOnDeleteButton()
                .assertThatAccountDeletedSuccessfully();
    }


}
