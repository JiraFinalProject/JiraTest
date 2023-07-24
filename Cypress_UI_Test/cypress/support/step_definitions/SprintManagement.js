import {When} from "@badeball/cypress-cucumber-preprocessor";

//notice: The fastest with Edge. using Google chorme is slow
When("As a team leader user, I can create and start a new sprint. {} and {}",(tl_username,tl_password)=>{
    //login as a team leader user
    cy.visit("http://localhost:8080/login.jsp")
    cy.get("#login-form-username").type(tl_username)
    cy.get("#login-form-password").type(tl_password)
    cy.get("#login-form-submit").click()

    //go to Final project
    cy.get("#browse_link").click()
    cy.get("#project_type_software_lnk").click()
    cy.get('a[data-track-click="projects.browse.project"]:eq(0)').click()

    //go to Backlog
    cy.get('a[data-label="Backlog"]').click()

    //create a sptint
    cy.get(".js-add-sprint").click()
    cy.get("input[resolved]").clear().type("FIN Sprint 1")
    cy.get("#sprint-goal").type("For UI Testing")
    cy.get("#ghx-sprint-duration").select("7")
    cy.get('button[type="submit"]').click()

    //create a issue for sprint to start
    //cy.get('button[type="button"]:eq(1)').should("be.visible").click()
    //cy.get('textarea[name="summary"]:eq(0)').type("create a issue for sprint to start it").type('{enter}')

    /* cy.get("#create_link").click()
     //Depending on whether the computer is lagging.
     cy.get("#summary").should("be.visible").type("create a issue for sprint to start")
   //  cy.get('#customfield_10100-field').click()
     cy.get('#customfield_10100-field').scrollIntoView().type("FIN Sprint 1").wait(2000).type('{enter}')
     cy.get("#create-issue-submit").click().wait(2000)
 */

    cy.get('button[type="button"][resolved=""]:eq(0)').click()
    cy.get('textarea[name="summary"]:eq(0)').type("create a issue for sprint to start").wait(1000).type('{enter}')


    //start a sprint
    cy.reload()
    cy.get(".js-sprint-start").should("be.enabled").click()
    cy.get('button[type="submit"]').click()
})

When("As a team leader user, I can move issues from the backlog to the current sprint.",()=>{
    //go to Backlog
    cy.reload()
    cy.get('a[data-label="Backlog"]').click()

    //create a issue for backlog
    cy.get("#create_link").click()
    cy.get("#summary").should("be.visible").type("create a issue for backlog")
    cy.get("#create-issue-submit").click()

    //move
    cy.reload()
    cy.wait(1000)
    //cy.get(".ghx-issues:eq(1) div").eq(1).trigger("mousedown",{which:1})
    cy.get('.ghx-issues:eq(-1)').children().then((children) => {
        cy.wrap(children.get(children.length - 2)).trigger("mousedown",{which:1})
    })
    //cy.get(".ghx-backlog-header:eq(0)").scrollIntoView().trigger("mousemove").trigger("mouseup",focus(true))
    cy.get(".ghx-issues:eq(0)").trigger("mousemove").trigger("mouseup",focus(true))

    cy.get('button[class="button-panel-button aui-button"]').should("be.visible").click()
})

When("As a developer user, I can view all the issues in the current sprint. {} and {}",(de_username,de_password)=>{
    //log out
    cy.get("#header-details-user-fullname").click()
    cy.get("#log_out").click()

    //login as a developer user
    cy.visit("http://localhost:8080/login.jsp")
    cy.get("#login-form-username").type(de_username)
    cy.get("#login-form-password").type(de_password)
    cy.get("#login-form-submit").click()

    //go to Final project
    cy.get("#browse_link").click()
    cy.get("#project_type_software_lnk").click()
    cy.get('a[data-track-click="projects.browse.project"]:eq(0)').click()

    //go to Active sprints
    cy.get('a[data-label="Active sprints"]').should("be.visible").click()

})

When("As a team lead user, I can end the current active sprint. {} and {}",(tl_username,tl_password)=>{

    //login as a team leader user
    cy.visit("http://localhost:8080/login.jsp")
    cy.get("#login-form-username").type(tl_username)
    cy.get("#login-form-password").type(tl_password)
    cy.get("#login-form-submit").click()

    //go to Final project
    cy.get("#browse_link").should("be.visible").click()
    cy.get("#project_type_software_lnk").click()
    cy.get('a[data-track-click="projects.browse.project"]:eq(0)').click()

    //go to Active sprints
    cy.get('a[data-label="Active sprints"]').should("be.visible").click()

    //end the sprint
    //  cy.get("#ghx-complete-sprint").click()
    // cy.get(".button-panel-button").click()
})

When("As a team lead user, I can download the velocity chart of the last 6 months as an image.",()=>{
    //go to Reports
    cy.get('a[data-label="Reports"]').should("be.visible").click()

    //go to velocityChart
    cy.get('button[aria-label="Switch report"]').should("be.visible").click()
    cy.contains('Velocity Chart').click()


    //select 6 months
    cy.get('button[aria-controls="velocity-chart-timeframe-dropdown"]').should("be.visible").click()
    cy.get('aui-item-radio[data-timeframe="6"]').click()
    cy.get("#js-apply-btn").click()
    //cy.get('#velocity-echarts > div:nth-child(1)').click();


    cy.get("canvas").should("be.visible").then($thiscanvas=>{
        const width=$thiscanvas.width();
        const height=$thiscanvas.height();

        const buttonX = width-10;
        const buttonY = height/15;

        cy.wrap($thiscanvas).click(buttonX,buttonY);
    })
})
