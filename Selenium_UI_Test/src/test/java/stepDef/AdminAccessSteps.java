package stepDef;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import page_object_model.AdminAccessPO;
import page_object_model.LoginPO;

public class AdminAccessSteps {
    private final AdminAccessPO adminAccessPO;
    private final WebDriver driver;

    public AdminAccessSteps() {
        adminAccessPO = new AdminAccessPO();
        driver = DriverFactory.getDriver();
    }

    @And("I put in {string}")
    public void i_put_in_password(String password){
        adminAccessPO.enterPassword(password);

    }

    @And("I click on confirm button")
    public void i_click_on_confirm_button(){
        adminAccessPO.clickConfirmBtn();
    }
}
