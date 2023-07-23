package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static drivers.DriverFactory.getDriver;

public class CurrentProjectPO extends BasePO{
    @FindBy(xpath = "//a[@id='view_project_roles']")
    public WebElement usersAndRolesLink;
    @FindBy(xpath = "//button[@class='css-1yx6h60']")
    public WebElement addUsersToARoleBtn;
    @FindBy(xpath = "//input[@id='react-select-2-input']")
    public WebElement userOrGroupsInput;
    @FindBy(xpath = "//input[@id='react-select-3-input']")
    public WebElement roleInput;
    @FindBy(xpath = "//button[@form='ADD_USER_OR_GROUP_FORM']")
    public WebElement addBtnForAddingUser;
    @FindBy(xpath = "//input[@id='project-field']")
    public WebElement projectNameInput;
    @FindBy(xpath = "//input[@id='summary']")
    public WebElement summaryInput;
    @FindBy(xpath = "//input[@id='create-issue-submit']")
    public WebElement createIssueBtn;

    public void clickUsersAndRolesLink() { usersAndRolesLink.click(); }
    public void clickAddUsersToARoleBtn() { addUsersToARoleBtn.click(); }
    public void enterUserOrGroupsInput(String user) {
        userOrGroupsInput.clear();
        userOrGroupsInput.sendKeys(user);
        userOrGroupsInput.sendKeys(Keys.RETURN);
    }
    public void enterRoleInputAndPressReturn(String role) {
        roleInput.sendKeys(role);
        roleInput.sendKeys(Keys.RETURN);
    }
    public void clickIssueCreateLink() {
        new WebDriverWait(getDriver(), 30)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    d.findElement(By.id("create_link")).click();
                    return true;
                });
    }
    public void clickAddBtnForAddingUser() { addBtnForAddingUser.click(); }
    public void enterProjectNameInputAndPressReturn(String projectName) {
        projectNameInput.clear();
        projectNameInput.sendKeys(projectName);
    }
    public void enterEpicNameInput(String epicName) {
        new WebDriverWait(getDriver(), 30)
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
