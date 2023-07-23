package page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminAccessPO extends BasePO{
    @FindBy(xpath = "//input[@id='login-form-authenticatePassword']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-form-submit']")
    private WebElement confirmBtn;

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickConfirmBtn(){
        confirmBtn.click();
    }
}
