package page_object_model;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;
public class SettingPO extends BasePO{
    @FindBy(xpath = "//a[@id='project_role_browser']")
    private WebElement projectRoleButton;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement roleNameBox;

    @FindBy(xpath = "//input[@name='description']")
    private WebElement roleDesciptBox;

    @FindBy(xpath = "//input[@id='role_submit']")
    private WebElement addRoleButton;

    @FindBy(xpath = "//a[@id='manage_developer']")
    private WebElement manageButton;

    @FindBy(css = "tbody tr td:nth-child(2) a")
    private WebElement editLink;

    @FindBy(xpath = "//textarea[@id='userNames']")
    private WebElement addUsernameBox;

    @FindBy(xpath = "//input[@name='add']")
    private WebElement addUserButton;

    public void clickProjectRoleButton() {
        projectRoleButton.click();
    }
    public void enterRoleName(String roleName) {
        roleNameBox.sendKeys(roleName);
    }
    public void enterRoleDescript(String roleDescript) {
        roleDesciptBox.sendKeys(roleDescript);
    }
    public void clickAddRole() {
        addRoleButton.click();
    }
    public void clickManageMember() {
        manageButton.click();
    }
    public void setEditLink() {
        editLink.click();
    }
    public void setAddUsernameBox() {
        addUsernameBox.sendKeys("charlie");
        addUserButton.click();
    }


}
