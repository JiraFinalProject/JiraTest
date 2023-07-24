package page_object_model;

import drivers.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrentProjectPO_ML extends BasePO_ML {
    @FindBy(xpath = "//a[@id='view_project_roles']")
    private WebElement usersAndRolesLink;
    @FindBy(xpath = "//button[@class='css-1yx6h60']")
    private WebElement addUsersToARoleBtn;
    @FindBy(xpath = "//input[@id='react-select-2-input']")
    private WebElement userOrGroupsInput;
    @FindBy(xpath = "//input[@id='react-select-3-input']")
    private WebElement roleInput;
    @FindBy(xpath = "//button[@form='ADD_USER_OR_GROUP_FORM']")
    private WebElement addBtnForAddingUser;
    @FindBy(xpath = "//input[@id='project-field']")
    private WebElement projectNameInput;
    @FindBy(xpath = "//input[@id='summary']")
    private WebElement summaryInput;
    @FindBy(xpath = "//input[@id='create-issue-submit']")
    private WebElement createIssueBtn;

    public void clickUsersAndRolesLink() { usersAndRolesLink.click(); }
    public void clickAddUsersToARoleBtn() { addUsersToARoleBtn.click(); }
    public void enterUserOrGroupsInput(String user) throws InterruptedException {
        userOrGroupsInput.sendKeys(user);
        Thread.sleep(1000);
        userOrGroupsInput.sendKeys(Keys.RETURN);
    }
    public void enterRoleInputAndPressReturn(String role) {
        roleInput.sendKeys(role);
        roleInput.sendKeys(Keys.RETURN);
    }
    public void clickAddBtnForAddingUser() {
        new WebDriverWait(DriverFactory.getDriver(), 30).until(ExpectedConditions.elementToBeClickable(addBtnForAddingUser));
        addBtnForAddingUser.click();
    }
    public void clickIssueCreateLink() throws InterruptedException {
        Thread.sleep(1000);
        new WebDriverWait(DriverFactory.getDriver(), 1000)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    d.findElement(By.id("create_link")).click();
                    return true;
                });
    }
    public void enterProjectNameInputAndPressReturn(String projectName) {
        projectNameInput.clear();
        projectNameInput.sendKeys(projectName);
    }
    public void enterEpicNameInput(String epicName) {
        new WebDriverWait(DriverFactory.getDriver(), 100)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    d.findElement(By.id("customfield_10104")).click();
                    d.findElement(By.id("customfield_10104")).sendKeys(epicName);
                    return true;
                });
    }
    public void enterSummaryInput(String epicName) {
        summaryInput.clear();
        summaryInput.sendKeys("this is epic summary for " + epicName);
    }
    public void clickCreateIssueBtn() { createIssueBtn.click(); }

}
