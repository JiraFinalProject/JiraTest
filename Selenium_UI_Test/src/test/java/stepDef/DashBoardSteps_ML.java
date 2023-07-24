package stepDef;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object_model.DashBoardPO_ML;

import static org.testng.Assert.assertEquals;


public class DashBoardSteps_ML {
    private final DashBoardPO_ML dashBoardPO = new DashBoardPO_ML();



    @And("I click the user management in the drop down menu")
    public void iClickTheUserManagementInTheDropDownMenu() {
        dashBoardPO.clickLinkUserManagement();
    }

    @Then("I should view the user browser page for authentication")
    public void iShouldViewTheUserBrowserPageForAuthentication() {
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
                "http://localhost:8080/secure/admin/user/UserBrowser.jspa");
    }

    @When("I click projects tab in the top banner")
    public void iClickProjectsTabInTheTopBanner() {
        dashBoardPO.clickProjectsTab();
    }

    @And("I click create project link")
    public void iClickCreateProjectLink() {
        dashBoardPO.clickCreateProjectLink();
    }

    @And("I select scrum software development for a software project")
    public void iSelectScrumSoftwareDevelopmentForASoftwareProject() {
        dashBoardPO.clickScrumSoftwareDevelopmentOption();
    }

    @And("I click next button in the create project window")
    public void iClickNextButtonInTheCreateProjectWindow() {
        dashBoardPO.clickNextBtn();
    }

    @And("I click select button in the create project window")
    public void iClickSelectButtonInTheCreateProjectWindow() {
        dashBoardPO.clickSelectBtn();
    }

    @And("I enter project name {string} in the project name input field")
    public void iEnterProjectNameProjectNameInTheProjectNameInputField(String projectName) throws InterruptedException {
        dashBoardPO.enterProjectNameInput(projectName);
    }

//    @And("I enter lead {string} in the project lead input field")
//    public void iEnterLeadLeadInTheProjectLeadInputFiledAndReturn(String adminUsername) throws InterruptedException {
//        dashBoardPO.enterProjectLeadInput(adminUsername);
//    }
    @And("I click submit button to to submit project creation")
    public void iClickSubmitButtonToToSubmitProjectCreation() throws InterruptedException {
        dashBoardPO.clickSubmitProjectCreationBtn();
    }

    @When("I click administrator setting link at the top banner")
    public void iClickAdministratorSettingLinkOnTheTopBanner() {
        dashBoardPO.clickLinkAdmin();
    }
    @And("I click the issues in the drop down menu")
    public void iClickTheIssuesInTheDropDownMenu() {
        dashBoardPO.clickIssuesLink();
    }
}
