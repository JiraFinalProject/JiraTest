package pageObjects;

import constants.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

// page_url = "http://localhost:8080/secure/admin/user/AddUser!default.jspa"
public class UserCreationPO extends BasePO{
    @FindBy(xpath = "//input[@id='user-create-email']")
    public WebElement emailAddressInput;
    @FindBy(xpath = "//input[@id='user-create-fullname']")
    public WebElement fullNameInput;
    @FindBy(xpath = "//input[@id='user-create-username']")
    public WebElement userNameInput;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;
    @FindBy(xpath = "//input[@id='user-create-submit']")
    public WebElement createUserBtn;

    public void enterEmailAddress(String email) { emailAddressInput.sendKeys(email); }
    public void enterFullName(String fullName) { fullNameInput.sendKeys(fullName); }
    public void enterUserName(String username) { userNameInput.sendKeys(username); }
    public void enterPassword(String password) { passwordInput.sendKeys(password); }
    public void clickCreateUserBtn() { createUserBtn.click(); }

}