package stepDef;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page_object_model.AdministrationPO;
import page_object_model.LoginPO;

import java.util.concurrent.TimeUnit;

public class AdministrationSteps {
    private final AdministrationPO administrationPO;
    private final WebDriver driver;

    public AdministrationSteps() {
        administrationPO = new AdministrationPO();
        driver = DriverFactory.getDriver();
    }

    @And("I click on Workflows on the left")
    public void i_click_on_workflows_on_the_left(){
        administrationPO.clickWorkflowOption();

    }
    @And("I click on Add workflow")
    public void i_click_on_add_workflow(){
        administrationPO.clickAddWorkflowBtn();
    }
    @And("I type in the name of the workflow {string}")
    public void i_type_in_the_name_of_the_workflow(String workflowName){
        administrationPO.enterWorkflowName(workflowName);
    }
    @And("I click Add button")
    public void i_click_add_button(){
        administrationPO.clickAddBtn();
    }

    //click on Add Status button
    ////button[@class='aui-button add-status']

    //type in "To Do"
    //input[@id='status-name-field']

    //select the To Do item in the drop down menu
    //a[@role='presentation']

    //click on Add Button
    ////input[@name='submit']



    //click on Add Status button
    ////button[@class='aui-button add-status']

    //type in "In Progress"
    //input[@id='status-name-field']

    //select the In Progress item in the drop down menu
    //a[@role='presentation']

    //click on Add Button
    ////input[@name='submit']



    //click on Add Status button
    ////button[@class='aui-button add-status']

    //type in "Resolved"
    //input[@id='status-name-field']

    //select the In Resolved item in the drop down menu
    //a[@role='presentation']

    //click on Add Button
    ////input[@name='submit']


    //click on Add Status button
    ////button[@class='aui-button add-status']

    //type in "Closed"
    //input[@id='status-name-field']

    //select the In Closed item in the drop down menu
    //a[@role='presentation']

    //click on Add Button
    ////input[@name='submit']


    @And("I click on Add Status button")
    public void i_click_on_add_status_button(){
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
//        try {
//            Thread.sleep(10000); // 5000 milliseconds = 5 seconds
//        } catch (InterruptedException e) {
//            // Handle the exception if necessary
//        }

        administrationPO.clickAddStatusBtn();
    }
    @And("I type in To Do")
    public void i_type_in_to_do(){
        administrationPO.enterToDoStatus();
    }
    @And("I select the To Do item in the drop down menu")
    public void i_select_the_to_do_item_in_the_drop_down_menu(){
        administrationPO.selectStatusInDropdownMenu();
    }
    @And("I click on Confirm Add Button")
    public void i_click_on_confirm_add_button(){
        administrationPO.clickConfirmAddBtn();
    }
    @And("I click on Add Status button for in progress")
    public void i_click_on_add_status_button_for_in_progress(){
//        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        administrationPO.clickAddStatusBtn();
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
    }
    @And("I type in In Progress")
    public void i_type_in_in_progress(){
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        administrationPO.enterInProgressStatus();
    }
    @And("I select the In Progress item in the drop down menu")
    public void i_select_the_in_progress_item_in_the_drop_down_menu(){
        administrationPO.selectStatusInDropdownMenu();
    }
//    @And("I click on Confirm Add Button")
//    public void i_click_on_add_button(){
//
//    }
    @And("I click on Add Status button for resolved")
    public void i_click_on_add_status_button_for_resolved(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        administrationPO.clickAddStatusBtn();
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
    }
    @And("I type in Resolved")
    public void i_type_in_resolved(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        administrationPO.enterResolvedStatus();
    }
    @And("I select the In Resolved item in the drop down menu")
    public void i_select_the_in_resolved_item_in_the_drop_down_menu(){
        administrationPO.selectStatusInDropdownMenu();
    }
//    @And("I click on Confirm Add Button")
//    public void i_click_on_add_button(){
//
//    }
    @And("I click on Add Status button for closed")
    public void i_click_on_add_status_button_for_closed(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        administrationPO.clickAddStatusBtn();
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
    }
    @And("I type in Closed")
    public void i_type_in_closed(){
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        administrationPO.enterClosedStatus();
    }
    @And("I select the In Closed item in the drop down menu")
    public void i_select_the_in_closed_item_in_the_drop_down_menu(){
        administrationPO.selectStatusInDropdownMenu();
    }
//    @And("I click on Confirm Add Button")
//    public void i_click_on_add_button(){
//
//    }

    @And("I click on Add Transition Button")
    public void i_click_on_add_transition_button(){
         driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

        administrationPO.clickAddTransitionBtn();
    }
    @And("I choose From Status to be Open")
    public void i_choose_from_status_to_be_open(){
        administrationPO.setFromStatusOpen();

    }
    @And("I choose To Status to be To Do")
    public void i_choose_to_status_to_be_to_do(){

        administrationPO.setToStatusToDo();
    }
    @And("I name the transition transition 1")
    public void i_name_the_transition_transition_1(){

        administrationPO.nameTransition1();
    }
    @And("I click Transition Add button")
    public void i_click_transition_add_button(){
//        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//        try {
//            Thread.sleep(30000); // 5000 milliseconds = 5 seconds
//        } catch (InterruptedException e) {
//            // Handle the exception if necessary
//        }
        administrationPO.clickTransitionAddBtn();
    }

//    @And("I click on Add Transition Button")
//    public void i_click_on_add_transition_button(){
//
//    }
    @And("I choose From Status to be To Do")
    public void i_choose_from_status_to_be_to_do(){
        administrationPO.setFromStatusToDo();
    }
    @And("I choose To Status to be In Progress")
    public void i_choose_to_status_to_be_in_progress(){

        administrationPO.setToStatusInProgress();
    }
    @And("I name the transition transition 2")
    public void i_name_the_transition_transition_2(){

        administrationPO.nameTransition2();
    }
//    @And("I click Add button")
//    public void i_click_add_button(){
//
//    }

//    @And("I click on Add Transition Button")
//    public void i_click_on_add_transition_button(){
//
//    }
    @And("I choose From Status to be In Progress")
    public void i_choose_from_status_to_be_in_progress(){
        administrationPO.setFromStatusInProgress();
    }
    @And("I choose To Status to be Resolved")
    public void i_choose_to_status_to_be_resolved(){

        administrationPO.setToStatusResolved();
    }
    @And("I name the transition transition 3")
    public void i_name_the_transition_transition_3(){

        administrationPO.nameTransition3();
    }
//    @And("I click Transition Add button")
//    public void i_click_add_button(){
//
//    }

//    @And("I click on Add Transition Button")
//    public void i_click_on_add_transition_button(){
//
//    }
    @And("I choose From Status to be Resolved")
    public void i_choose_from_status_to_be_resolved(){
        administrationPO.setFromStatusResolved();
    }
    @And("I choose To Status to be Closed")
    public void i_choose_to_status_to_be_closed(){
        administrationPO.setToStatusClosed();
    }
    @And("I name the transition transition 4")
    public void i_name_the_transition_transition_4(){
        administrationPO.nameTransition4();
    }
//    @And("I click Transition Add button")
//    public void i_click_add_button(){
//
//    }






}
