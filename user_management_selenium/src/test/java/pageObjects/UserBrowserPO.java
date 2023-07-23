package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//page_url = http://localhost:8080/secure/admin/user/UserBrowser.jspa
public class UserBrowserPO extends BasePO{
    @FindBy(xpath = "//input[@id='login-form-authenticatePassword']")
    public WebElement authenticationPasswordInput;
    @FindBy(xpath = "//input[@id='login-form-submit']")
    public WebElement confirmBtn;
    @FindBy(xpath = "//a[@id='create_user']")
    public WebElement createUserLink;
    @FindBy(xpath = "//fieldset/div[1]/label")
    public WebElement activeCheckbox;
    @FindBy(xpath = "//input[@id='user-edit-submit']")
    public WebElement updateBtn;
    @FindBy(xpath = "//select[@id='user-filter-user-filter-active']")
    public WebElement statusSelectMenu;
    @FindBy(xpath = "//option[normalize-space()='Inactive']")
    public WebElement inactiveOption;
    @FindBy(xpath = "//input[@id='user-filter-userSearchFilter']")
    public WebElement filterInput;
    @FindBy(xpath = "//a[@id='user-filter-cancel']")
    public WebElement resetUserFilterBtn;
    @FindBy(xpath = "//input[@id='user-filter-group-field']")
    public WebElement groupFilterInput;

    public void enterAuthenticationPassword(String adminPassword) { authenticationPasswordInput.sendKeys(adminPassword); }
    public void clickConfirmBtn() { confirmBtn.click(); }
    public void clickCreateUserLink() { createUserLink.click(); }
    public void uncheckActiveCheckbox() { activeCheckbox.click(); }
    public void clickUpdateBtn() {
        updateBtn.click();
        //re-obtain page DOM
        getDriver().navigate().to("http://localhost:8080/secure/admin/user/UserBrowser.jspa");
    }
    public void clickStatusSelectMenu() { statusSelectMenu.click(); }
    public void clickInactiveOption() { inactiveOption.click(); }
    public void enterOnFilterInput() { filterInput.sendKeys(Keys.RETURN); }
    public void clickResetUserFilterBtn() { resetUserFilterBtn.click(); }
    public void enterGroupFilterInputAndReturn(String groupName) {
        groupFilterInput.clear();
        groupFilterInput.sendKeys(groupName);
        groupFilterInput.sendKeys(Keys.RETURN);
    }
}
