package com.mrjunos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TravelocityFlightsResults extends BasePage {

    public TravelocityFlightsResults(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sortDropdown")
    private WebElement sortDropdown;

    //@FindBys(@FindBy(css = "#flight-listing-container li"))
    @FindBys(@FindBy(css = "[class='flight-module segment offer-listing']"))
    private List<WebElement> flightsElements;

    public TravelocitySelectedFlight selectFlights() {
        if (!verifySearchResults()) {
            return null;
        } else {

        }
        return new TravelocitySelectedFlight(getDriver());
    }

    public boolean verifySearchResults() {
        getWait().until(ExpectedConditions.elementToBeClickable(sortDropdown));
        if (flightsElements.size() <= 0) {
            return false;
        } else {
            for (WebElement element : flightsElements) {
                getWait().until(ExpectedConditions.elementToBeClickable(element.findElement(By.cssSelector("[class='btn-secondary btn-action t-select-btn']"))));
                element.findElement(By.cssSelector("[class='btn-secondary btn-action t-select-btn']")).isDisplayed();
                getWait().until(ExpectedConditions.elementToBeClickable(element.findElement(By.cssSelector("css=button.btn-secondary"))));
                getWait().until(ExpectedConditions.elementToBeClickable(element.findElement(By.cssSelector("duration-emphasis"))));
                getWait().until(ExpectedConditions.elementToBeClickable(element.findElement(By.cssSelector("hide-flight-details"))));
            }
            return true;
        }
    }
}
