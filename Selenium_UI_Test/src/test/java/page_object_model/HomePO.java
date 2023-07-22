package page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePO extends BasePO{
    @FindBy(xpath = "//span[@class='aui-icon aui-icon-small aui-iconfont-configure']")
    private WebElement buttonSetting;

    @FindBy(xpath = "//a[@id='admin_system_menu']")
    private WebElement systemMenu;

    @FindBy(xpath = "//input[@id='login-form-authenticatePassword']")
    private WebElement enterPassword;

    @FindBy(xpath = "//input[@id='login-form-submit']")
    private WebElement confirmButton;
    public void gotoSystem() {
        systemMenu.click();
    }
    public void clickSettingBtn() {
        buttonSetting.click();
    }
    public void enterPassword(String password) {
        enterPassword.sendKeys(password);
    }
    public void clickConfirmButton() {
        confirmButton.click();
    }
}