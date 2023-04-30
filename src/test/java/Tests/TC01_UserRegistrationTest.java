package Tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupLoginPage;
import pages.SignupPage;
import resources.JSONReader;

import java.lang.reflect.Method;
import io.qameta.allure.selenide.AllureSelenide;


public class TC01_UserRegistrationTest extends TestBase{

    public static String email;
    public static String password;

    @BeforeMethod
    public void setup(Method method)
    {
        email = JSONReader.readJSON(getTestClassName(),method.getName(),"email");
        password = JSONReader.readJSON(getTestClassName(),method.getName(),"password");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
    @Test
    @Description("Verify that user can login successfully")
    public void verifySignInSuccessfully()
    {
        new LoginPage(driver)
                .signInAction(email , password)
                .verifySuccessfulLogin();
    }
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
