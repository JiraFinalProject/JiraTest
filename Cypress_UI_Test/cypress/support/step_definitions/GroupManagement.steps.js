import { Given, When, Then } from "@badeball/cypress-cucumber-preprocessor";
import AdministrationAccessPage from "../../pages/AdministrationAccessPage";
import DashboardPage from "../../pages/DashboardPage";
import LoginPage from "../../pages/LoginPage";
import UserManagementPage from "../../pages/UserManagementPage";
import GroupsPage from "../../pages/GroupsPage";
import UsersPage from "../../pages/UsersPage"

const loginPage = Object.create(LoginPage);
const dashboardPage = Object.create(DashboardPage);
const administrationAccessPage = Object.create(AdministrationAccessPage);
const userManagementPage = Object.create(UserManagementPage);
const groupsPage = Object.create(GroupsPage);
const usersPage = Object.create(UsersPage);

Given("I am logged in as an {string} user with username {string} and password {string}", (role, username, password) => {
    loginPage.visit();
    loginPage.fillUsername(username);
    loginPage.fillPassword(password);
    loginPage.clickLoginButton();
});

When("I navigate to the group management page with password {string}", (password) => {
    dashboardPage.goToUserManagement();
    administrationAccessPage.fillPassword(password);
    administrationAccessPage.clickConfirmButton();
    userManagementPage.goToGroups();
});

When("I create the group {string}", (groupName) => {
    groupsPage.enterGroupName(groupName);
    groupsPage.clickAddGroupButton();
});

Then("the {string} group should be created successfully", (groupName) => {
    groupsPage.verifyTheFirstGroup(groupName);
});

When("I assign the user {string} to the {string} group", (username, groupName) => {
    groupsPage.editGroupMember(groupName, username);
});

Then("the user {string} should be assigned to the {string} group successfully", (username, groupName) => {
    usersPage.visit();
    usersPage.checkIfTheUserBelongToTheGroup(username, groupName);
});

Then("I can select users based on the group {string}", (groupName) => {
    usersPage.filterUserByGroups(groupName);
});