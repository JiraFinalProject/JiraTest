package page_object_model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPO extends BasePO{
    @FindBy(xpath = "//span[@class='aui-icon aui-icon-small aui-iconfont-configure']")
    private WebElement administrationIcon;

    @FindBy(xpath = "//a[@id='admin_issues_menu']")
    private WebElement issuesOption;

    public void clickAdminIcon(){
        administrationIcon.click();
    }

    public void clickIssueOption(){
        issuesOption.click();
    }

}
