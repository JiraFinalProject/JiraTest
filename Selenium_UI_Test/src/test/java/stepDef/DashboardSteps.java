package stepDef;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import page_object_model.DashboardPO;


public class DashboardSteps {
    private final DashboardPO dashboardPO;
    private final WebDriver driver;

    public DashboardSteps() {
        dashboardPO = new DashboardPO();
        driver = DriverFactory.getDriver();
    }

    @And("I click the Administration icon")
    public void i_click_the_administration_icon(){
        dashboardPO.clickAdminIcon();
    }

    @And("I click on Issues")
    public void i_click_on_Issues(){
        dashboardPO.clickIssueOption();
    }
}
