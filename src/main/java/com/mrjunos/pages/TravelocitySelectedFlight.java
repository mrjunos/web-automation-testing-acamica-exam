package com.mrjunos.pages;

import org.openqa.selenium.WebDriver;

public class TravelocitySelectedFlight extends BasePage {

    public TravelocitySelectedFlight(WebDriver driver) {
        super(driver);
    }

    public TravelocityWhoIsTravelingPage verifyFlightsAndPricing() {
        return new TravelocityWhoIsTravelingPage(getDriver());
    }
}
