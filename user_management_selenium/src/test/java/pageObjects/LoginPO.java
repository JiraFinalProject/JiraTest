package pageObjects;

import constants.URL;
import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// page_url = http://localhost:8080/login.jsp
public class LoginPO extends BasePO{
    @FindBy(xpath = "//input[@id='login-form-username']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@id='login-form-password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@id='login-form-submit']")
    public WebElement buttonLogin;
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