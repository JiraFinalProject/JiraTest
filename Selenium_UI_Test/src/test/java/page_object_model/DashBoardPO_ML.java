package page_object_model;


import drivers.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

// page_url = http://localhost:8080/secure/Dashboard.jspa
public class DashBoardPO_ML extends BasePO_ML {
    @FindBy(xpath = "//a[@id='admin_users_menu']")
    private WebElement linkUserManagement;
    @FindBy(xpath = "//a[@id='browse_link']")
    private WebElement projectsTab;
    @FindBy(xpath = "//a[@id='project_template_create_link_lnk']")
    private WebElement createProjectLink;
    @FindBy(xpath = "//div[@id='project-template-group-software']//div[@class='templates']/div[1]")
    private WebElement scrumSoftwareDevelopmentOption;
    @FindBy(xpath = "//div[@class='dialog-button-panel']/button[normalize-space()='Next']")
    private WebElement nextBtn;
    @FindBy(xpath = "(//button[normalize-space()='Select'])")
    private WebElement selectBtn;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement projectNameInput;
//    @FindBy(xpath = "//input[@id='lead-field']")
//    private WebElement projectLeadInput;
    @FindBy(xpath = "//a[@id='admin_issues_menu']")
    private WebElement issuesLink;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement submitProjectCreationBtn;
    public void clickLinkAdmin() {
        new WebDriverWait(DriverFactory.getDriver(), 5000)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    d.findElement(By.xpath("//span[@class='aui-icon aui-icon-small aui-iconfont-configure']")).click();
                    return true;
                });
    }
    public void clickLinkUserManagement() { linkUserManagement.click(); }
    public void clickProjectsTab() { projectsTab.click(); }
    public void clickCreateProjectLink() { createProjectLink.click(); }
    public void clickScrumSoftwareDevelopmentOption() { scrumSoftwareDevelopmentOption.click(); }
    public void clickNextBtn() { nextBtn.click(); }
    public void clickSelectBtn() { selectBtn.click(); }
    public void enterProjectNameInput(String projectName) throws InterruptedException {
        projectNameInput.sendKeys(projectName);
        Thread.sleep(1000);
    }
//    public void enterProjectLeadInput(String adminUsername) throws InterruptedException {
//        projectLeadInput.click();
//        projectLeadInput.sendKeys(adminUsername);
//        //Thread.sleep(1000);
//        projectLeadInput.sendKeys(Keys.RETURN);
//    }
    public void clickSubmitProjectCreationBtn() throws InterruptedException {
        submitProjectCreationBtn.click();
        Thread.sleep(1000);
    }
    public void clickIssuesLink() { issuesLink.click(); }
}