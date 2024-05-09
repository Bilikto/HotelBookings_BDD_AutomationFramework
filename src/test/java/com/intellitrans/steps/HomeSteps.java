package com.intellitrans.steps;

import com.intellitrans.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user open website")
    public void user_open_website() {
        homePage.openWebsite();
    }

    @When("user enter going to destination {string}")
    public void user_enter_going_to_destination(String city) {
        homePage.enterDestination(city);
    }

    @When("user enter travel dates")
    public void user_enter_travel_dates() {
        homePage.enterTravelDates();
    }

    @When("user provides travelers and room")
    public void user_provide_travelers_and_room() {
        homePage.enterTravelers();
    }

    @Then("user click search button")
    public void user_click_search_button() {
        homePage.clickSearchBtn();
    }

}
