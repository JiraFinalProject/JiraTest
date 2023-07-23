package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewUserPO extends BasePO{
    @FindBy(xpath = "//a[@id='editgroups_link']")
    public WebElement manageGroupsBtn;
    @FindBy(xpath = "//textarea[@id='groupsToJoin-textarea']")
    public WebElement searchGroupTextFiled;
    @FindBy(xpath = "//input[@id='user-edit-groups-join']")
    public WebElement joinSelectedGroupsBtn;
    @FindBy(xpath = "//nav[@id='admin-nav-heading']//li[@class='aui-nav-selected']//a")
    public WebElement userManagementBtn;
    public void clickManagementGroupBtn() { manageGroupsBtn.click(); }
    public void enterGroupNameInSearchGroupTextFiled(String groupName) {
        searchGroupTextFiled.sendKeys(groupName);
        searchGroupTextFiled.sendKeys(Keys.RETURN);
    }
    public void clickJoinSelectedGroupsBtn() {
        joinSelectedGroupsBtn.click();
        getDriver().navigate().refresh();
    }
    public void clickUserManagementBtn() { userManagementBtn.click(); }
}
