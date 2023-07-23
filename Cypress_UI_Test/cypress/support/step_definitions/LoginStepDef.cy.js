import LogInPO from '../../pages/LogInPO.cy';
import {Then, When} from "@badeball/cypress-cucumber-preprocessor";

When('I log in with {string} and {string}', (username, password) => {
    // Define actions to navigate to the login page
    LogInPO.visit();
    LogInPO.type(username, password);
});

Then('I click log in button', () => {
    LogInPO.login();
});