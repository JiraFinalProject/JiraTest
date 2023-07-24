package stepDef;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_object_model.LoginPO;
import page_object_model.ScrumBoardPO;

public class ScrumBoardSteps {

    private final ScrumBoardPO scrumBoardPO;
    private final WebDriver driver;

    public ScrumBoardSteps() {
        scrumBoardPO = new ScrumBoardPO();
        driver = DriverFactory.getDriver();
    }

    @When("I click on profile icon")
    public void i_click_on_profile_icon(){
        scrumBoardPO.clickProfileIcon();
    }

    @And("click on Boards")
    public void click_on_boards(){
        scrumBoardPO.clickBoards();
    }

    @And("click on Board drop down menu")
    public void click_on_board_drop_down_menu(){
        scrumBoardPO.clickBoardDropdown();
    }

    @And("click on Create Board")
    public void click_on_create_board(){
        scrumBoardPO.clickCreateBoardOption();
    }
    //a[@role='menuitem'][normalize-space()='Create board']

    @And("click on Create a Scrum board button")
    public void click_on_create_a_scrum_board_button(){
        scrumBoardPO.clickCreateScrumBoardBtn();

    }
    //button[@id='ghx-wizard-methodology-scrum']

    @And("select board from an existing project")
    public void select_board_from_an_existing_project(){
        //radio groups!!
        scrumBoardPO.clickRadioBtn();
    }
    //label[@for='ghx-wizard-method-existing-project']

    @And("click Next")
    public void click_next(){
        scrumBoardPO.clickNext();
    }
    //button[@class='button-panel-button aui-button aui-button-primary js-wizard-button-next']

    @And("enter the name of the board {string}")
    public void enter_the_name_of_the_board(String boardName){
        scrumBoardPO.enterBoardName(boardName);
    }
    //input[@id='ghx-wizard-project-board-name']

//    @And("enter the project name")
//    public void enter_the_project_name(){
//        scrumBoardPO.enterProjectName();
//
//    }
    //hit enter
    //textarea[@id='ghx-wizard-choose-project-textarea']
    @And("click the Create board button")
    public void click_the_create_board_button(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        scrumBoardPO.clickCreateBoardButton();
    }
    ////button[@class='button-panel-button aui-button aui-button-primary js-wizard-button-complete']
//    @And("click on Board drop down menu")
//    public void click_on_board_drop_down_menu(){
//        scrumBoardPO.clickBoardDropdown();
//    }

    @And("click on Configure")
    public void click_on_configure(){
        scrumBoardPO.clickConfigure();
    }
    //a[normalize-space()='Configure']
    @And("click on Columns")
    public void click_on_column(){
        scrumBoardPO.clickColumns();
    }
    //a[normalize-space()='Columns']
    @And("click on Add Column button")
    public void click_on_add_column_button(){
        scrumBoardPO.clickAddColumnBtn();
    }
    //button[@id='ghx-config-addcolumn']
    @And("type in the column name Resolved")
    public void type_in_the_column_name_resolved() throws InterruptedException {
        scrumBoardPO.enterColumnNameResolved();
    }
    //input[@id='ghx-column-name']
    @And("click the column add button")
    public void click_the_column_add_button(){
        scrumBoardPO.clickColumnAddBtn();
    }
    //button[@class='button-panel-button aui-button']



//    @And("update the column name from Done to Closed")
//    public void update_the_column_name_from_done_to_closed(){
//        scrumBoardPO.updateColumnNameToClosed();
//    }
    //h3[@title='Done']

    @And("type in the column name Closed")
    public void type_in_the_column_name_closed(){
        scrumBoardPO.enterColumnNameClosed();
    }

    @And("delete Done Column")
    public void delete_done_column(){
        scrumBoardPO.deleteDoneColumn();
    }



    @And("I can drag an issue from To Do to In Progress")
    public void i_can_drag_an_issue_from_to_do_to_in_progress(){
        scrumBoardPO.dragIssueToInProgress();
    }
    //to perform drag and drop (to do to in progress)
    //drag
        //div[@data-statusid=10000]
    //drop
    //(//ul[@data-column-id="16"])



     @And("I can drag an issue from In Progress to Resolved")
     public void i_can_drag_an_issue_from_in_progress_to_resolved(){
         scrumBoardPO.dragIssueToResolved();
     }
             //(in progress to resolved)
    //drag
        //div[@data-statusid=10000]
    //drop
    //(//ul[@data-column-id="18"])

     @And("I can drag an issue from Resolved to Closed")
    public void i_can_drag_an_issue_from_resolved_to_closed(){
         scrumBoardPO.dragIssueToClosed();
     }
            //drag
             //div[@data-statusid=10000]
             //drop
             //(//ul[@data-column-id="17"])
}
