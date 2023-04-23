package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends PageBase {
    private static final By deleteAccountBtn = By.xpath("//a[text()=' Delete Account']");
    private static final By accountDeletionSuccessMsg = By.xpath("//h2[@data-qa='account-deleted']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnDeleteButton() {
        clickOnElement(deleteAccountBtn);
        return this;
    }
    public void assertThatAccountDeletedSuccessfully(){
        Assert.assertEquals(driver.findElement(accountDeletionSuccessMsg).getText(),"ACCOUNT DELETED!");
    }
}
