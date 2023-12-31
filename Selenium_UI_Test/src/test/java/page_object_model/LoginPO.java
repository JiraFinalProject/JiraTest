package page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{
    @FindBy(xpath = "//input[@id='login-form-submit']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//input[@id='login-form-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='login-form-username']")
    private WebElement inputUsername;


    public void enterUserName(String username) {
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLoginBtn() {
        buttonLogin.click();
    }


}