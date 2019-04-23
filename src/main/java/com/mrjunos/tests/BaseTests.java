package com.mrjunos.tests;

import com.mrjunos.drivers.MyDriver;
import com.mrjunos.pages.TravelocityHomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTests {

    MyDriver myDriver;

    private TravelocityHomePage travelocityHomePage;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser) {
        myDriver = new MyDriver(browser);
        travelocityHomePage = new TravelocityHomePage(myDriver.getDriver());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        travelocityHomePage.dispose();
    }

    public TravelocityHomePage getTravelocityHomePage() {
        return travelocityHomePage;
    }
}
