package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import page_object_model.AdminIssuesPO;

import static drivers.DriverFactory.getDriver;

public class AdminIssuesStepDefs {
    private final AdminIssuesPO adminIssuesPO = new AdminIssuesPO();

    @And("I click issue type schemes link at the side bar")
    public void iClickIssueTypeSchemesLinkAtTheSideBar() {
        adminIssuesPO.clickIssueTypeSchemesLink();
    }

    @And("I click associate link of the first existing issue type schemes")
    public void iClickAssociateLinkOfTheFirstExistingIssueTypeSchemes() {
        adminIssuesPO.clickAssociateLinkOfFirstExistingScheme();
    }

    @And("I select the new project {string} in the projects list")
    public void iSelectTheNewProjectInTheProjectsList(String projectName) {
        String targetProjectXPath = "//select[@name='projects']/option[normalize-space()='" + projectName + "']";
        getDriver().findElement(By.xpath(targetProjectXPath)).click();
    }

    @And("I click associate button to complete association of current scheme to the new project")
    public void iClickAssociateButtonToCompleteAssociationOfCurrentSchemeToTheNewProject() {
        adminIssuesPO.clickAssociateSubmitBtn();
    }

    @When("I click projects link in administration")
    public void iClickProjectsLinkInAdministration() {
        adminIssuesPO.clickProjectsLink();
    }

    @And("I click the new project {string} in projects list")
    public void iClickTheNewProjectProjectNameInProjectsList(String projectName) {
        String targetProjectLinkXPath = "//a[normalize-space()='" + projectName +  "']";
        getDriver().findElement(By.xpath(targetProjectLinkXPath)).click();
    }
}
