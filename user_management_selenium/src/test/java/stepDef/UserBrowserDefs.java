package stepDef;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageObjects.UserBrowserPO;

import static drivers.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class UserBrowserDefs {
    private final UserBrowserPO userBrowserPO = new UserBrowserPO();
    @When("I enter the admin password {string}")
    public void iEnterTheAdminPasswordAdminPassword(String adminPassword) {
        userBrowserPO.enterAuthenticationPassword(adminPassword);
    }

    @And("I click confirm button for authentication")
    public void iClickConfirmButtonForAuthentication() {
        userBrowserPO.clickConfirmBtn();
    }

    @And("I click create user button on the authentication page")
    public void iClickCreateUserButton() {
        userBrowserPO.clickCreateUserLink();
    }

    @Then("I should view the add user page")
    public void iShouldViewTheAddUserPage() {
        assertEquals(getDriver().getCurrentUrl(),
                "http://localhost:8080/secure/admin/user/AddUser!default.jspa");
    }

    @And("I click the edit link of the new user {string} on the user browser page")
    public void iClickTheEditLinkOfTheNewUserOnTheUserBrowserPage(String name) {
        String userEditXPath =  "//a[@id='edituser_link_" + name + "']";
        getDriver().findElement(By.xpath(userEditXPath)).click();
    }

    @And("I click the active checkbox to uncheck active status")
    public void iClickTheActiveCheckboxToUncheckActiveStatus() {
        userBrowserPO.uncheckActiveCheckbox();
    }

    @And("I click update button of the edit user profile form to submit status change")
    public void iClickUpdateButtonOfTheEditUserProfileForm() {
        userBrowserPO.clickUpdateBtn();
    }

    @And("I click the status filter menu")
    public void iClickTheStatusFilterMenu() {
        userBrowserPO.clickStatusSelectMenu();
    }

    @And("I click inactive status")
    public void iClickInactiveStatus() {
        userBrowserPO.clickInactiveOption();
    }

    @And("I press enter on filter text input")
    public void iPressEnterOnFilterTextInput() {
        userBrowserPO.enterOnFilterInput();
    }

    @Then("I should view the user {string} in the result set")
    public void iCanViewTheUserNameInTheResultSet(String name) {
        String userRowXPath = "//tr[@data-user='" + name + "']";
        assertEquals(getDriver().findElements(By.xpath(userRowXPath)).size(), 1);
    }


    @When("I reset the user filter")
    public void iRestTheUserFilter() {
        userBrowserPO.clickResetUserFilterBtn();
    }

    @And("I reactivate the user {string} status")
    public void iReactivateTheUserNameStatus(String name) {
        iClickTheEditLinkOfTheNewUserOnTheUserBrowserPage(name);
        iClickTheActiveCheckboxToUncheckActiveStatus();
        iClickUpdateButtonOfTheEditUserProfileForm();
    }

    @And("I click the full name of user {string} in the users list")
    public void iClickTheFullNameOfUserNameInTheUsersList(String username) {
        String userFullNameLinkXPath = "//a[@id='" + username + "']";
        getDriver().findElement(By.xpath(userFullNameLinkXPath)).click();
    }

    @And("I apply the group filter {string} and return the search")
    public void iApplyTheGroupFilterGroupName(String groupName) {
        userBrowserPO.enterGroupFilterInputAndReturn(groupName);
    }

}
