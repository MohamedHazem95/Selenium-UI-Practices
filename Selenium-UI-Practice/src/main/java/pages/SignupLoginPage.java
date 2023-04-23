package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends PageBase {
    private static final By signUpNameField = By.xpath("//input[@data-qa='signup-name']");
    private static final By signUpEmailField = By.xpath("//input[@data-qa='signup-email']");
    private static final By signUpBtn = By.xpath("//button[@data-qa='signup-button']");

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    public SignupLoginPage setSignupName() {
        setElementText(signUpNameField, "testing");
        return this;
    }

    public SignupLoginPage setSignupEmail() {
        setElementText(signUpEmailField, generateRandomText(8) + "@m.com");
        return this;
    }

    public SignupLoginPage clickOnSignupButton() {
        clickOnElement(signUpBtn);
        return this;
    }

    public SignupPage signupPage() {
        return new SignupPage(driver);
    }
}
