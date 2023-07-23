package stepDef;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import pageObjects.ViewUserPO;

import static drivers.DriverFactory.getDriver;

public class ViewUserStepDefs {
    private final ViewUserPO viewUserPO = new ViewUserPO();

    @And("I click the manage groups button on view user page")
    public void iClickTheManageGroupsButtonOnViewUserPage() {
        viewUserPO.clickManagementGroupBtn();
    }

    @And("I enter group name {string} in the search bar and press return")
    public void iEnterGroupNameGroupNameInTheSearchBar(String groupName) {
        viewUserPO.enterGroupNameInSearchGroupTextFiled(groupName);
    }

    @And("I click join selected groups button")
    public void iClickJoinSelectedGroupsButton() {
        viewUserPO.clickJoinSelectedGroupsBtn();
    }

    @And("I click the user management button to go back to user management page")
    public void iClickTheUserManagementButtonToGoBackToUserManagementPage() {
        viewUserPO.clickUserManagementBtn();
    }
}
