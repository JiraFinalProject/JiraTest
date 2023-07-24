package page_object_model;

import drivers.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//page_url = http://localhost:8080/secure/admin/user/UserBrowser.jspa
public class UserBrowserPO_ML extends BasePO_ML {
    @FindBy(xpath = "//input[@id='login-form-authenticatePassword']")
    private WebElement authenticationPasswordInput;
    @FindBy(xpath = "//input[@id='login-form-submit']")
    private WebElement confirmBtn;
    @FindBy(xpath = "//a[@id='create_user']")
    private WebElement createUserLink;
    @FindBy(xpath = "//fieldset/div[1]/label")
    private WebElement activeCheckbox;
    @FindBy(xpath = "//input[@id='user-edit-submit']")
    private WebElement updateBtn;
    @FindBy(xpath = "//select[@id='user-filter-user-filter-active']")
    private WebElement statusSelectMenu;
    @FindBy(xpath = "//option[normalize-space()='Inactive']")
    private WebElement inactiveOption;
    @FindBy(xpath = "//input[@id='user-filter-userSearchFilter']")
    private WebElement filterInput;
    @FindBy(xpath = "//a[@id='user-filter-cancel']")
    private WebElement resetUserFilterBtn;
    @FindBy(xpath = "//input[@id='user-filter-group-field']")
    private WebElement groupFilterInput;

    @FindBy(xpath = "//input[@id='user-filter-submit']")
    private WebElement filterButton;
    public void enterAuthenticationPassword(String adminPassword) { authenticationPasswordInput.sendKeys(adminPassword); }
    public void clickConfirmBtn() { confirmBtn.click(); }
    public void clickCreateUserLink() { createUserLink.click(); }
    public void uncheckActiveCheckbox() { activeCheckbox.click(); }
    public void clickUpdateBtn() {
        updateBtn.click();
        //re-obtain page DOM
        DriverFactory.getDriver().navigate().to("http://localhost:8080/secure/admin/user/UserBrowser.jspa");
    }
    public void clickStatusSelectMenu() { statusSelectMenu.click(); }
    public void clickInactiveOption() { inactiveOption.click(); }
    public void enterOnFilterInput() {
        filterInput.sendKeys(Keys.RETURN);
        //filterButton.click();
    }
    public void clickResetUserFilterBtn() { resetUserFilterBtn.click(); }
    public void enterGroupFilterInputAndReturn(String groupName) {
        groupFilterInput.clear();
        groupFilterInput.sendKeys(groupName);

        groupFilterInput.sendKeys(Keys.RETURN);
        filterButton.click();
    }
}
