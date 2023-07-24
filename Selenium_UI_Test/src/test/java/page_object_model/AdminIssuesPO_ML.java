package page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminIssuesPO_ML extends BasePO_ML {
    @FindBy(xpath = "//a[@id='issue_type_schemes']")
    private WebElement issueTypeSchemesLink;
    @FindBy(xpath = "//a[@id='associate_10000']")
    private WebElement associateLinkOfFirstExistingScheme;
    @FindBy(xpath = "//input[@id='associate_submit']")
    private WebElement associateSubmitBtn;
    @FindBy(xpath = "//span[normalize-space()='Projects']")
    private WebElement projectsLink;
    public void clickIssueTypeSchemesLink() { issueTypeSchemesLink.click(); }
    public void clickAssociateLinkOfFirstExistingScheme() { associateLinkOfFirstExistingScheme.click(); }
    public void clickAssociateSubmitBtn() { associateSubmitBtn.click(); }
    public void clickProjectsLink() { projectsLink.click(); }
}
