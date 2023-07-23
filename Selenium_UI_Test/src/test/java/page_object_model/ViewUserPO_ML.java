package page_object_model;

import drivers.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewUserPO_ML extends BasePO_ML {
    @FindBy(xpath = "//a[@id='editgroups_link']")
    private WebElement manageGroupsBtn;
    @FindBy(xpath = "//textarea[@id='groupsToJoin-textarea']")
    private WebElement searchGroupTextFiled;
    @FindBy(xpath = "//input[@id='user-edit-groups-join']")
    private WebElement joinSelectedGroupsBtn;
    @FindBy(xpath = "//nav[@id='admin-nav-heading']//li[@class='aui-nav-selected']//a")
    private WebElement userManagementBtn;
    public void clickManagementGroupBtn() { manageGroupsBtn.click(); }
    public void enterGroupNameInSearchGroupTextFiled(String groupName) {
        searchGroupTextFiled.sendKeys(groupName);
        searchGroupTextFiled.sendKeys(Keys.RETURN);
    }
    public void clickJoinSelectedGroupsBtn() {
        joinSelectedGroupsBtn.click();
        DriverFactory.getDriver().navigate().refresh();
    }
    public void clickUserManagementBtn() { userManagementBtn.click(); }
}
