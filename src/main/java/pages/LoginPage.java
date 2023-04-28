package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends PageBase {
    //Locators
    private static final By signupLoginButton = By.xpath("//a[text()=' Signup / Login']");
    private static final By signInEmailField = By.xpath("//input[@data-qa='login-email']");
    private static final By signInPwdField = By.xpath("//input[@data-qa='login-password']");
    private static final By signInBtn = By.xpath("//button[@data-qa='login-button']");
    private static final By signOutBtn=By.xpath("//a[@href='/logout']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage signInAction(String email , String password)
    {
        clickOnElement(signupLoginButton);
        setElementText(signInEmailField, email);
        setElementText(signInPwdField, password);
        clickOnElement(signInBtn);
        return this;
    }

    public LoginPage verifySuccessfulLogin()
    {
        Assert.assertTrue(driver.findElement(signOutBtn).isDisplayed());
        return this;
    }
}
