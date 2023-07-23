import { Given, When, Then } from "@badeball/cypress-cucumber-preprocessor";
import DashboardPage from "../../pages/DashboardPage";
import CreateIssuePage from "../../pages/CreateIssuePage";
import IssuesPage from "../../pages/IssuesPage";

const dashboardPage = Object.create(DashboardPage);;
const createIssuePage = Object.create(CreateIssuePage);
const issuesPage = Object.create(IssuesPage);

// When("I create a blocking {string} type of issue with the summary {string}", (issueType, summary) => {
//     dashboardPage.clickCreateButton();
//     cy.wait(2000);
//     createIssuePage.selectIssueType(issueType);
//     cy.wait(2000);
//     createIssuePage.fillSummary(summary);
//     createIssuePage.clickCreateButton();
// })

// Then("store the key of this issue", () => {
//     dashboardPage.goToIssuesPage()
//     issuesPage.setTheLatestIssueKey();
// }) 

// Then("I create an {string} type of issue with the name {string} and summary {string}", (issueType, issueName, summary) => {
//     dashboardPage.clickCreateButton();
//     cy.wait(2000);
//     createIssuePage.selectIssueType(issueType);
//     cy.wait(2000);
//     createIssuePage.fillSummary(summary);
//     createIssuePage.fillEpicName(issueName);
//     createIssuePage.clickCreateButton();
//     cy.wait(2000);
// })

// Then("I log out", () => {
//     dashboardPage.logout();
// })

// Then("I can create a {string} issue with epic link to {string}, priority 1, and summary {string}", (issueType, epicName, summary) => {
//     dashboardPage.clickCreateButton();
//     cy.wait(2000);
//     createIssuePage.selectIssueType(issueType);
//     cy.wait(2000);
//     createIssuePage.fillSummary(summary);
//     createIssuePage.fillEpicLink(epicName);
//     createIssuePage.fillPriority(1);
//     createIssuePage.clickCreateButton();
//     cy.wait(2000);
// })

// Then("I can specify the issue has the relationship {string} with the blocking issue", (linkType) => {
//     dashboardPage.goToIssuesPage();
//     cy.wait(3000);
//     cy.get("@blockingIssueKey").then((value) => {
//         issuesPage.specifyTheRelationshipToTheLatestIssue(linkType, value);
//     })
// })

// Then("I can assign this issue to the user {string}", (username) => {
//     issuesPage.assignTheLatestIssueToUser(username);
// })

Then("I can view the issues assigned to me {string}", (username) => {
    cy.get(".issuekey>.issue-link").click();
    cy.get("#issue_summary_assignee_charlie").invoke("attr", "rel").then((name) => {      
        expect(name.toLowerCase()).to.contain(username.toLowerCase());
    });
})

Then("I can add a comment {string} to the issue", (comment) => {
    cy.get("#comment-issue").click();
    cy.iframe("#mce_0_ifr").clear().type(comment).should("contain.text", comment);
})

Then("I can update the comment {string}", (comment) => {
    cy.get("#comment-issue").click();
    cy.iframe("#mce_0_ifr").clear().type(comment).should("contain.text", comment);
})

Then("I reply to the comment with {string}", (comment) => {
    cy.get("#comment-issue").click();
    cy.iframe("#mce_0_ifr").clear().type(comment).should("contain.text", comment);
})

