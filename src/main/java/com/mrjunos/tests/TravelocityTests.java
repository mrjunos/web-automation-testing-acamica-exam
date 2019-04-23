package com.mrjunos.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TravelocityTests extends BaseTests {

    @Test
    public void testTravelocityExam1() {
        Assert.assertTrue(getTravelocityHomePage().searchFlightRoundTrip("LAS", "LAX").selectFlights().verifyFlightsAndPricing().verifyWhoIsTraveling());
    }
}
