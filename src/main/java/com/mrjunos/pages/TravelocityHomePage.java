package com.mrjunos.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TravelocityHomePage extends BasePage{

    public TravelocityHomePage(WebDriver driver) {
        super(driver);
        driver.get("https://www.travelocity.com/");
    }

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement flightTab;

    @FindBy(id = "flight-type-roundtrip-label-hp-flight")
    private WebElement roundTripRadioButton;

    @FindBy(id = "flight-origin-hp-flight")
    private WebElement originFlightInput;

    @FindBy(id = "flight-destination-hp-flight")
    private WebElement destinationFlightInput;

    @FindBy(id = "typeaheadDataPlain")
    private WebElement helpDestinationList;

    @FindBy(css = "#typeaheadDataPlain li:nth-of-type(1)")
    private WebElement firstResultItemList;

    @FindBy(id = "flight-departing-hp-flight")
    private WebElement departingDateInput;

    @FindBy(id = "flight-returning-hp-flight")
    private WebElement returningDateInput;

    @FindBy(xpath = "//*[@id=\"flight-departing-wrapper-hp-flight\"]/div/div/button[1]")
    private WebElement datePickerBackButton;

    @FindBy(xpath = "//*[@id=\"flight-departing-wrapper-hp-flight\"]/div/div/button[2]")
    private WebElement datePickerNextButton;

    @FindBy(xpath = "//*[@id=\"flight-departing-wrapper-hp-flight\"]/div/div/div[1]/button")
    private WebElement datePickerCloseButton;

    @FindBy(how=How.CSS,using="button[data-day='10']")
    private WebElement originDayButton;

    @FindBy(how=How.CSS,using="button[data-day='10']")
    private WebElement destinationDayButton;

    @FindBy(xpath = "//*[@id=\"gcw-flights-form-hp-flight\"]/div[9]/label/button")
    private WebElement flightsSearchSubmitButton;

    public TravelocityFlightsResults searchFlightRoundTrip(String origin, String destination) {
        getWait().until(ExpectedConditions.elementToBeClickable(flightTab));
        flightTab.click();
        getWait().until(ExpectedConditions.elementToBeClickable(roundTripRadioButton));
        roundTripRadioButton.click();
        originFlightInput.click();
        originFlightInput.sendKeys(origin);
        getWait().until(ExpectedConditions.elementToBeClickable(helpDestinationList));
        getWait().until(ExpectedConditions.elementToBeClickable(firstResultItemList));
        firstResultItemList.click();
        destinationFlightInput.click();
        destinationFlightInput.sendKeys(destination);
        getWait().until(ExpectedConditions.elementToBeClickable(helpDestinationList));
        getWait().until(ExpectedConditions.elementToBeClickable(firstResultItemList));
        firstResultItemList.click();
        departingDateInput.click();
        getWait().until(ExpectedConditions.elementToBeClickable(datePickerNextButton));
        datePickerNextButton.click();
        datePickerNextButton.click();
        originDayButton.click();
        flightsSearchSubmitButton.click();
        return new TravelocityFlightsResults(getDriver());
    }
}
