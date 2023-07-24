package page_object_model;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;
public class ProjectPO extends BasePO{
    @FindBy(xpath = "//a[@id='browse_link']")
    private WebElement projectButton;

    @FindBy(xpath = "//a[@id='admin_main_proj_link_lnk']")
    private WebElement selectProjectName;

    @FindBy(xpath = "//a[@class='aui-button aui-button-subtle aui-sidebar-settings-button']//span[@class='aui-icon aui-icon-small aui-iconfont-configure']")
    private WebElement projectSetting;

    @FindBy(xpath = "//a[@id='view_project_roles']")
    private WebElement userRoleSetting;

    @FindBy(xpath = "//span[contains(text(),'Add users to a role')]")
    private WebElement addUserToRole;

    @FindBy(xpath = "//input[@id='react-select-2-input']")
    private WebElement projectUserBox;

    @FindBy(xpath = "//input[@id='react-select-3-input']")
    private WebElement projectRoleDropList;

    @FindBy(xpath = "//button[@class='_1tSDNSFo-vOBkDKqayIyHy css-18u3ks8']")

    private WebElement filterButton;

    @FindBy(xpath = "//span[@class='ItemParts__Content-sc-14xek3m-5 jRBaLt'][normalize-space()='team lead (1)']")
    private WebElement selectTeamLead;

    @FindBy(xpath = "//button[@class='css-1l4j2co']")
    private WebElement addUserRoleButton;
    public void setProjectButton() {
        projectButton.click();
        selectProjectName.click();
        projectSetting.click();
        userRoleSetting.click();
    }
    public void setProjectUserBox() throws InterruptedException{
        addUserToRole.click();
        projectUserBox.sendKeys("Junyu Deng");
        Thread.sleep(1000);
        projectUserBox.sendKeys(Keys.RETURN);
        projectRoleDropList.sendKeys("team lead");
        Thread.sleep(1000);
        projectRoleDropList.sendKeys(Keys.RETURN);
        addUserRoleButton.click();
    }
    public void setFilterButton() {
        filterButton.click();
        selectTeamLead.click();
    }
}
