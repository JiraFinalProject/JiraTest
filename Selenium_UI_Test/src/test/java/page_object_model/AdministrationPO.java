package page_object_model;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdministrationPO extends BasePO{
    @FindBy(xpath = "//a[@id='workflows']")
    private WebElement workflowsOption;

    @FindBy(xpath = "//a[@id='add-workflow']")
    private WebElement addWorkflowBtn;

    @FindBy(xpath = "//input[@id='add-workflow-newWorkflowName']")
    private WebElement workflowNameInput;

    @FindBy(xpath = "//input[@id='add-workflow-submit']")
    private WebElement addBtn;

//    @FindBy(xpath = "//button[@class='aui-button add-status']")
//    @FindBy(xpath = "/html/body/div[2]/div/section/div[2]/div/main/div/div/div[1]/div[1]/div/div/div/div[1]/button[1]")
    @FindBy(xpath = "//button[@class='aui-button add-status']")
    private WebElement addStatusBtn;
//    int waitTime = 10;
//
//    // Use WebDriverWait to wait for the element to be present and clickable
//    WebDriver driver = DriverFactory.getDriver();
//    private WebElement addStatusBtn = new WebDriverWait(driver, waitTime)
//            .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='aui-button add-status']")));

    @FindBy(xpath = "//input[@id='status-name-field']")
    private WebElement statusNameInput;

    @FindBy(xpath = "//a[@role='presentation']")
    private WebElement statusItemInDropdownMenu;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement confirmAddBtn;

    @FindBy(xpath ="//button[@class='aui-button add-transition']")
    private WebElement addTransitionBtn;

    @FindBy(xpath ="//div[@id='new-transition-pane']//div//input[@id='transition-source-step-id-field']")
    private WebElement fromStatusField;


    @FindBy(xpath ="//div[@id='new-transition-pane']//div//input[@id='transition-target-step-id-field']")
    private WebElement toStatusField;


    @FindBy(xpath ="//input[@id='transition-name']")
    private WebElement nameTransitionField;

    @FindBy(xpath ="//input[@class='aui-button aui-button aui-button-primary']")
    private WebElement transitionAddBtn;



    public void clickWorkflowOption(){
        workflowsOption.click();
    }

    public void clickAddWorkflowBtn(){
        addWorkflowBtn.click();
    }

    public void enterWorkflowName(String workflowName){
        workflowNameInput.sendKeys(workflowName);
    }

    public void clickAddBtn(){
        addBtn.click();
    }

    public void clickAddStatusBtn(){
        addStatusBtn.click();
    }

    public void enterToDoStatus() throws InterruptedException {
        statusNameInput.clear();
        statusNameInput.sendKeys("To Do");
        Thread.sleep(1000);

    }

    public void enterInProgressStatus() throws InterruptedException {
        statusNameInput.clear();

        statusNameInput.sendKeys("In Progress");
        Thread.sleep(1000);
    }

    public void enterResolvedStatus() throws InterruptedException {
        statusNameInput.clear();

        statusNameInput.sendKeys("Resolved");
        Thread.sleep(1000);
    }

    public void enterClosedStatus() throws InterruptedException {
        statusNameInput.clear();
        statusNameInput.sendKeys("Closed");
        Thread.sleep(1000);
    }

    public void selectStatusInDropdownMenu(){
        statusItemInDropdownMenu.click();
    }

    public void clickConfirmAddBtn(){
        confirmAddBtn.click();
    }

    public void clickAddTransitionBtn(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        addTransitionBtn.click();
    }

    public void setFromStatusOpen(){
        fromStatusField.clear();
        fromStatusField.sendKeys(" ");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        fromStatusField.sendKeys("Open");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();

    }

    public void setFromStatusToDo(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        fromStatusField.clear();
        fromStatusField.sendKeys(" ");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        fromStatusField.sendKeys("To Do");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();

//        fromStatusField.click();
//        WebDriver driver = DriverFactory.getDriver();
//        driver.findElement(By.xpath("//li[@id=\"to-do-146\"]/a[text() = 'To Do']")).click();
//        driver.findElement(By.xpath("//li[@id='to-do-56']//a[@role='presentation'][normalize-space()='To Do']")).click();
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.DOWN).perform();

//        Select dropdown = new Select(fromStatusField);
//
//        // Select "Open" option by visible text
//        dropdown.selectByVisibleText("To Do");



    }

    public void setFromStatusInProgress(){
//        try {
//            Thread.sleep(15000); // 5000 milliseconds = 5 seconds
//        } catch (InterruptedException e) {
//            // Handle the exception if necessary
//        }
        fromStatusField.clear();
        fromStatusField.sendKeys(" ");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        fromStatusField.sendKeys("In Progress");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();

//        fromStatusField.click();
//        WebDriver driver = DriverFactory.getDriver();
//        driver.findElement(By.xpath("//li[@id='in-progress-58']//a[@role='presentation'][normalize-space()='In Progress']")).click();
    }

    public void setFromStatusResolved(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        fromStatusField.clear();
        fromStatusField.sendKeys(" ");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        fromStatusField.sendKeys("Resolved");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();

//        fromStatusField.click();
//        WebDriver driver = DriverFactory.getDriver();
//        driver.findElement(By.xpath("//li[@id='resolved-65']//a[@role='presentation'][normalize-space()='Resolved']")).click();

    }

    public void setToStatusToDo(){
//        drop_down = self.driver.find_elements_by_css_selector("li.env-data a")
//        for values in  drop_down:
//        if values.text==ENVNAME2:
//        values.click()
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        toStatusField.clear();
        toStatusField.sendKeys(" ");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        toStatusField.sendKeys("To Do");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
//        try {
//            Thread.sleep(7000); // 5000 milliseconds = 5 seconds
//        } catch (InterruptedException e) {
//            // Handle the exception if necessary
//        }
//
//        toStatusField.click();
//        WebDriver driver = DriverFactory.getDriver();
//        driver.findElement(By.xpath("//li[@id=\"to-do-191\"]/a[text() = 'To Do']")).click();

//        Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/form/div[1]/div[1]/div/div[1]/select")));
//
//        // Select "Open" option by visible text
//        dropdown.selectByVisibleText("To Do");

    }

    public void setToStatusInProgress(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        toStatusField.clear();
        toStatusField.sendKeys(" ");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        toStatusField.sendKeys("In Progress");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
//        try {
//            Thread.sleep(7000); // 5000 milliseconds = 5 seconds
//        } catch (InterruptedException e) {
//            // Handle the exception if necessary
//        }

//        toStatusField.click();
//        WebDriver driver = DriverFactory.getDriver();
//        driver.findElement(By.xpath("//li[@id='in-progress-73']//a[@role='presentation'][normalize-space()='In Progress']")).click();
    }

    public void setToStatusResolved(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        toStatusField.clear();
        toStatusField.sendKeys(" ");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        toStatusField.sendKeys("Resolved");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
//        try {
//            Thread.sleep(7000); // 5000 milliseconds = 5 seconds
//        } catch (InterruptedException e) {
//            // Handle the exception if necessary
//        }

//        toStatusField.click();
//        WebDriver driver = DriverFactory.getDriver();
//        driver.findElement(By.xpath("//li[@id='resolved-80']//a[@role='presentation'][normalize-space()='Resolved']")).click();

    }

    public void setToStatusClosed(){
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        toStatusField.clear();
        toStatusField.sendKeys(" ");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        toStatusField.sendKeys("Closed");
        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception if necessary
        }
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
//        try {
//            Thread.sleep(7000); // 5000 milliseconds = 5 seconds
//        } catch (InterruptedException e) {
//            // Handle the exception if necessary
//        }

//        toStatusField.click();
//        WebDriver driver = DriverFactory.getDriver();
//        driver.findElement(By.xpath("//li[@id='resolved-80']//a[@role='presentation'][normalize-space()='Resolved']")).click();
    }

    public void nameTransition1(){
        nameTransitionField.sendKeys("Transition 1");
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void nameTransition2(){
        nameTransitionField.sendKeys("Transition 2");
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void nameTransition3(){
        nameTransitionField.sendKeys("Transition 3");
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void nameTransition4(){
        nameTransitionField.sendKeys("Transition 4");
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void clickTransitionAddBtn(){
//        WebDriver driver = DriverFactory.getDriver();
//        WebDriverWait wait = new WebDriverWait(driver, 30); // Wait for a maximum of 10 seconds
//        wait.until(ExpectedConditions.elementToBeClickable(transitionAddBtn));
//        driver.execute_script("arguments[0].click();", transitionAddBtn);
        transitionAddBtn.click();
    }



}
