package page_object_model;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class IssueSettingPO extends BasePO{
    @FindBy(xpath = "//a[@id='admin_menu']")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@id='admin_issues_menu']")
    private WebElement issueButton;

    @FindBy(xpath = "//a[@id='permission_schemes']")
    private WebElement permissionButton;

    @FindBy(xpath = "//a[@id='add_permissions_scheme']")
    private WebElement addSchemeButton;

    @FindBy(xpath = "//input[@id='add-permissions-scheme-newSchemeName']")
    private WebElement schemeName;

    @FindBy(xpath = "//input[@id='add-permissions-scheme-submit']")
    private WebElement addSubmitButton;

    @FindBy(css = "body > div:nth-child(1) > div:nth-child(2) > section:nth-child(1) > div:nth-child(3) > div:nth-child(1) > main:nth-child(2) > table:nth-child(6) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(3) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")
    private WebElement editPermission;

    @FindBy(xpath = "//tr[@data-permission-key='MANAGE_SPRINTS_PERMISSION']//button[@class='aui-button aui-button-link add-trigger'][normalize-space()='Edit']")
    private WebElement manageSprint;

    @FindBy(xpath = "//label[normalize-space()='Project Role']")
    private WebElement selectProjectRole;

    @FindBy(xpath = "//input[@id='projectrole-field']")
    private WebElement selectTeamLead;

    @FindBy(xpath = "//button[@id='grant-permission-dialog-grant-button']")
    private WebElement grantButton;

    @FindBy(xpath = "//tr[@data-permission-key='ASSIGN_ISSUES']//button[@class='aui-button aui-button-link add-trigger'][normalize-space()='Edit']")
    private WebElement editAssignIssue;

    @FindBy(xpath = "//tr[@data-permission-key='RESOLVE_ISSUES']//button[@class='aui-button aui-button-link add-trigger'][normalize-space()='Edit']")
    private WebElement resolveIssue;

    @FindBy(xpath = "//tr[@data-permission-key='CLOSE_ISSUES']//button[@class='aui-button aui-button-link add-trigger'][normalize-space()='Edit']")
    private WebElement closeIssue;

    @FindBy(xpath = "//tr[@data-permission-key='BROWSE_PROJECTS']//button[@class='aui-button aui-button-link add-trigger'][normalize-space()='Edit']")
    private WebElement browseProject;

    @FindBy(xpath = "//label[normalize-space()='Application access']")
    private WebElement applicationAccess;

    @FindBy(xpath = "//a[@id='browse_link']")
    private WebElement projectButton;

    @FindBy(xpath = "//a[@id='admin_main_proj_link_lnk']")
    private WebElement selectProjectName;

    @FindBy(xpath = "//a[@class='aui-button aui-button-subtle aui-sidebar-settings-button']//span[@class='aui-icon aui-icon-small aui-iconfont-configure']")
    private WebElement projectSetting;

    @FindBy(xpath = "//a[@id='view_project_permissions']")
    private WebElement permissionSetting;

    @FindBy(xpath = "//button[@id='project-config-tab-actions']")
    private WebElement schemeAction;

    @FindBy(xpath = "//a[@id='project-config-permissions-scheme-change']")
    private WebElement diffScheme;

    @FindBy(xpath = "//select[@id='schemeIds_select']")
    private WebElement dropDownScheme;

    @FindBy(xpath = "//input[@id='associate_submit']")
    private WebElement submitScheme;


    //    @FindBy(xpath = "//tr[@data-permission-key='MANAGE_SPRINTS_PERMISSION']//button[@class='aui-button aui-button-link delete-trigger'][normalize-space()='Remove']")
//    private WebElement removeButton;
//
//    @FindBy(xpath = "//div[@class='aui-dialog2-content']//div[1]")
//    private WebElement checkBox;
//
//    @FindBy(xpath = "//button[@id='dialog-save-button']")
//    private WebElement submitRemove;
    public void goToPermissionScheme() {
        menuButton.click();
        issueButton.click();
        permissionButton.click();
    }
    public void addPermissionScheme() {
        addSchemeButton.click();
        schemeName.sendKeys("Project Scheme");
        addSubmitButton.click();
    }
    public void editScheme() throws InterruptedException {
        editPermission.click();
        manageSprint.click();
        selectProjectRole.click();
        selectTeamLead.click();
        selectTeamLead.sendKeys("team lead");
        Thread.sleep(1000);
        selectTeamLead.sendKeys(Keys.RETURN);
        grantButton.click();
//        removeButton.click();
//        checkBox.click();
//        submitRemove.click();

        editAssignIssue.click();
        selectProjectRole.click();
        selectTeamLead.click();
        selectTeamLead.sendKeys("team lead");
        Thread.sleep(1000);
        selectTeamLead.sendKeys(Keys.RETURN);
        grantButton.click();

        resolveIssue.click();
        selectProjectRole.click();
        selectTeamLead.click();
        selectTeamLead.sendKeys("developer");
        Thread.sleep(1000);
        selectTeamLead.sendKeys(Keys.RETURN);
        grantButton.click();

        closeIssue.click();
        selectProjectRole.click();
        selectTeamLead.click();
        selectTeamLead.sendKeys("QA");
        Thread.sleep(1000);
        selectTeamLead.sendKeys(Keys.RETURN);
        grantButton.click();

        browseProject.click();
        applicationAccess.click();
        grantButton.click();
    }

    public void assignScheme() {
        projectButton.click();
        selectProjectName.click();
        projectSetting.click();
        permissionSetting.click();
        schemeAction.click();
        diffScheme.click();
        Select dropDownMenu = new Select(dropDownScheme);
        dropDownMenu.selectByVisibleText("Project Scheme");
        submitScheme.click();
    }
}
