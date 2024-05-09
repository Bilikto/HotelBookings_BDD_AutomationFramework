package com.intellitrans.steps;

import com.intellitrans.pages.HotelListingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HotelListingSteps {

    HotelListingPage hotelListingPage = new HotelListingPage();

    @Then("verify user is on Hotel listing page")
    public void verify_user_is_on_hotel_listing_page() {
        Assert.assertTrue(hotelListingPage.isHotelListingPageDisplayed());
    }

    @When("user sort by star rating")
    public void user_sort_by_star_rating() {
        hotelListingPage.sortBy("Star rating");
    }

    @Then("print prices over $ {int}")
    public void print_prices_over_$(int price) {
        hotelListingPage.printHotelsWithPriceOver500(price);
    }

}
