package page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// page_url = "http://localhost:8080/secure/admin/user/AddUser!default.jspa"
public class UserCreationPO extends BasePO{
    @FindBy(xpath = "//input[@id='user-create-email']")
    private WebElement emailAddressInput;
    @FindBy(xpath = "//input[@id='user-create-fullname']")
    private WebElement fullNameInput;
    @FindBy(xpath = "//input[@id='user-create-username']")
    private WebElement userNameInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@id='user-create-submit']")
    private WebElement createUserBtn;

    public void enterEmailAddress(String email) { emailAddressInput.sendKeys(email); }
    public void enterFullName(String fullName) { fullNameInput.sendKeys(fullName); }
    public void enterUserName(String username) { userNameInput.sendKeys(username); }
    public void enterPassword(String password) { passwordInput.sendKeys(password); }
    public void clickCreateUserBtn() { createUserBtn.click(); }

}