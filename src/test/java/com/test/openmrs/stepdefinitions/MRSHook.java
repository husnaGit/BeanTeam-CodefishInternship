package com.test.openmrs.stepdefinitions;

import com.utils.BrowserUtils;
import com.utils.ConfigReader;
import com.utils.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class MRSHook {

    public WebDriver driver;

    @Before
    public void setUp(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("MRS_url"));
    }

    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotForCucumber(driver,scenario);
        driver.quit();
    }

}
