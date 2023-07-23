package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminIssuesPO extends BasePO{
    @FindBy(xpath = "//a[@id='issue_type_schemes']")
    public WebElement issueTypeSchemesLink;
    @FindBy(xpath = "//a[@id='associate_10000']")
    public WebElement associateLinkOfFirstExistingScheme;
    @FindBy(xpath = "//input[@id='associate_submit']")
    public WebElement associateSubmitBtn;
    @FindBy(xpath = "//span[normalize-space()='Projects']")
    public WebElement projectsLink;
    public void clickIssueTypeSchemesLink() { issueTypeSchemesLink.click(); }
    public void clickAssociateLinkOfFirstExistingScheme() { associateLinkOfFirstExistingScheme.click(); }
    public void clickAssociateSubmitBtn() { associateSubmitBtn.click(); }
    public void clickProjectsLink() { projectsLink.click(); }
}
