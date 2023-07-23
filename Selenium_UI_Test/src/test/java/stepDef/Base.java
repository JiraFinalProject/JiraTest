package stepDef;

import drivers.DriverFactory;
import io.cucumber.java.After;

public class Base {
    @After
    public void afterScenario() {
        DriverFactory.teardown();
    }
}