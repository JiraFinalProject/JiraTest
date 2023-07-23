package page_object_model;

import drivers.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ScrumBoardPO extends BasePO{
    @FindBy(xpath = "//a[@id='header-details-user-fullname']")
    private WebElement profileIcon;

    @FindBy(xpath = "//a[@id='greenhopper-my-jira-home-set']")
    private WebElement boardsBtn;
    @FindBy(xpath = "//button[@id='board-tools-section-button']")
    private WebElement boardDropdown;

    //And click on Create Board
    //a[@role='menuitem'][normalize-space()='Create board']
    @FindBy(xpath = "//a[@role='menuitem'][normalize-space()='Create board']")
    private WebElement createBoardOption;


    //And click on Create a Scrum board button
    //button[@id='ghx-wizard-methodology-scrum']
    @FindBy(xpath ="//button[@id='ghx-wizard-methodology-scrum']")
    private WebElement createScrumBoardBtn;

    //And select board from an existing project
    //label[@for='ghx-wizard-method-existing-project']
    @FindBy(xpath ="//label[@for='ghx-wizard-method-existing-project']")
    private WebElement radioBtn;

    //And click Next
    //button[@class='button-panel-button aui-button aui-button-primary js-wizard-button-next']
    @FindBy(xpath ="//button[@class='button-panel-button aui-button aui-button-primary js-wizard-button-next']")
    private WebElement nextBtn;

    //And enter the name of the board
    //input[@id='ghx-wizard-project-board-name']
    @FindBy(xpath ="//input[@id='ghx-wizard-project-board-name']")
    private WebElement boardNameInput;

    //And enter the project name
    //hit enter
    //textarea[@id='ghx-wizard-choose-project-textarea']
    @FindBy(xpath ="//textarea[@id='ghx-wizard-choose-project-textarea']")
    private WebElement projectNameInput;

    //And click the Create board button
    ////button[@class='button-panel-button aui-button aui-button-primary js-wizard-button-complete']
    @FindBy(xpath ="//button[@class='button-panel-button aui-button aui-button-primary js-wizard-button-complete']")
    private WebElement createBoardBtn;

    //And click on Board dropdown

    //And click on Configure
    //a[normalize-space()='Configure']
    @FindBy(xpath = "//a[normalize-space()='Configure']")
    private WebElement configureOption;

    //And click on Columns
    //a[normalize-space()='Columns']
    @FindBy(xpath = "//a[normalize-space()='Columns']")
    private WebElement columnsOption;

    //And click on Add Column button
    //button[@id='ghx-config-addcolumn']
    @FindBy(xpath = "//button[@id='ghx-config-addcolumn']")
    private WebElement addColumnBtn;

    //And type in the column name Resolved
    //input[@id='ghx-column-name']
    @FindBy(xpath = "//input[@id='ghx-column-name']")
    private WebElement columnNameInput;

    //And click the column add button
    //button[@class='button-panel-button aui-button']
    @FindBy(xpath = "//button[@class='button-panel-button aui-button']")
    private WebElement columnAddBtn;


    //And update the column name from Done to Closed
    //h3[@title='Done']
    @FindBy(xpath = "//h3[@title='Done']")
    private WebElement columnNameUpdate;



    //And I can drag an issue from To Do to In Progress
    //to perform drag and drop (to do to in progress)
    //drag
        //div[@data-statusid=10000]
    //drop
    //(//ul[@data-column-id="16"])
    @FindBy(xpath = "//div[@data-statusid=10000]")
    private WebElement issueToBeDragged;

//    @FindBy(xpath = "//ul[@data-column-id=\"16\"]")
//    @FindBy(xpath = "//div[@id='ghx-mapping-columns-wrapper']//ul[1]")
//    @FindBy(css =  ".ghx-issues:eq(1) div")
    @FindBy(xpath = "//ul[@class='ghx-column-wrapper ghx-config-status ghx-mapped ghx-last ui-sortable']")
    private WebElement inProgressColumn;



     //And I can drag an issue from In Progress to Resolved
             //(in progress to resolved)
    //drag
        //div[@data-statusid=10000]
    //drop
    //(//ul[@data-column-id="18"])
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/ul[3]")
    private WebElement resolvedColumn;

     //And I can drag an issue from Resolved to Closed
             //drag
             //div[@data-statusid=10000]
             //drop
             //(//ul[@data-column-id="17"])
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/ul[4]")
    private WebElement closedColumn;

    @FindBy(xpath = "//ul[@class='ghx-column-wrapper ghx-config-status ghx-mapped ghx-last ui-sortable']//div[@class='ghx-action ghx-config-delete']")
    private WebElement deleteDoneColIcon;


    //When I click on profile icon
    public void clickProfileIcon(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        profileIcon.click();
    }

    //And click on Boards
    public void clickBoards(){
        boardsBtn.click();
        try {
            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
    }

    //And click on Board drop down menu
    public void clickBoardDropdown(){
        try {
            Thread.sleep(15000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(260, TimeUnit.SECONDS);
        boardDropdown.click();
    }

    //And click on Create Board
    //a[@role='menuitem'][normalize-space()='Create board']
    public void clickCreateBoardOption(){
        createBoardOption.click();
    }

    //And click on Create a Scrum board button
    //button[@id='ghx-wizard-methodology-scrum']
    public void clickCreateScrumBoardBtn(){
        createScrumBoardBtn.click();
    }

    //And select board from an existing project
    //label[@for='ghx-wizard-method-existing-project']
    //RadioGroups!!!
    public void clickRadioBtn(){
        radioBtn.click();
    }


    //And click Next
    //button[@class='button-panel-button aui-button aui-button-primary js-wizard-button-next']
    public void clickNext(){
        nextBtn.click();
    }


    //And enter the name of the board
    //input[@id='ghx-wizard-project-board-name']
    public void enterBoardName(String boardName){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        boardNameInput.sendKeys(boardName);
    }


    //And enter the project name
    //hit enter
    //textarea[@id='ghx-wizard-choose-project-textarea']
    public void enterProjectName(){
        projectNameInput.sendKeys("JYK");
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }


        //And click the Create board button
    ////button[@class='button-panel-button aui-button aui-button-primary js-wizard-button-complete']
    public void clickCreateBoardButton(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        createBoardBtn.click();
    }


        //And click on Board drop down menu

    //And click on Configure
    //a[normalize-space()='Configure']
    public void clickConfigure(){
        try {
            Thread.sleep(1000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        configureOption.click();
    }


    //And click on Columns
    //a[normalize-space()='Columns']
    public void clickColumns(){
        try {
            Thread.sleep(1000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        columnsOption.click();
    }


    //And click on Add Column button
    //button[@id='ghx-config-addcolumn']
    public void clickAddColumnBtn(){
        try {
            Thread.sleep(1000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        addColumnBtn.click();
    }


    //And type in the column name Resolved
    //input[@id='ghx-column-name']
    public void enterColumnNameResolved(){
        try {
            Thread.sleep(1000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        columnNameInput.sendKeys("Resolved");
    }

    public void enterColumnNameClosed(){
        try {
            Thread.sleep(1000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        columnNameInput.sendKeys("Closed");
    }


    //And click the column add button
    //button[@class='button-panel-button aui-button']
    public void clickColumnAddBtn(){
        try {
            Thread.sleep(1000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        columnAddBtn.click();
    }



    //And update the column name from Done to Closed
    //h3[@title='Done']
    public void updateColumnNameToClosed(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        columnNameUpdate.click();
        columnNameUpdate.clear();
        columnNameUpdate.sendKeys("Closed");
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void deleteDoneColumn(){

        deleteDoneColIcon.click();
    }



    //And I can drag an issue from To Do to In Progress
    //to perform drag and drop (to do to in progress)
    //drag
        //div[@data-statusid=10000]
    //drop
    //(//ul[@data-column-id="16"])
    public void dragIssueToInProgress(){
        WebDriver driver = DriverFactory.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        try {
            Thread.sleep(10000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
//        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.dragAndDrop(issueToBeDragged, inProgressColumn).build().perform();


    }



     //And I can drag an issue from In Progress to Resolved
             //(in progress to resolved)
    //drag
        //div[@data-statusid=10000]
    //drop
    //(//ul[@data-column-id="18"])

    public void dragIssueToResolved(){
        try {
            Thread.sleep(10000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.dragAndDrop(issueToBeDragged, resolvedColumn).build().perform();

    }

     //And I can drag an issue from Resolved to Closed
             //drag
             //div[@data-statusid=10000]
             //drop
             //(//ul[@data-column-id="17"])

    public void dragIssueToClosed(){
        try {
            Thread.sleep(10000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.dragAndDrop(issueToBeDragged, closedColumn).build().perform();

    }
}
