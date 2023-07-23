package page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// page_url = http://localhost:8080/login.jsp
public class LoginPO extends BasePO{
    @FindBy(xpath = "//input[@id='login-form-username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@id='login-form-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='login-form-submit']")
    private WebElement buttonLogin;
    public void clickLoginButton() {
        buttonLogin.click();
    }

    public void enterUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }
}