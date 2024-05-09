package com.intellitrans.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@class='uitk-field-input is-hidden empty-placeholder']/following-sibling::button")
    WebElement goingToTab;

    @FindBy(xpath = "//form[@id='lodging_search_form']//input[@id='destination_form_field']")
    WebElement destinationInput;

    @FindBy(xpath = "//form[@id='lodging_search_form']//button[contains(@class, 'has-subtext destination_form_field-result-item-button')]")
    List<WebElement> listOfDestinations;

    @FindBy(xpath = "//input[contains(@value, 'May')]/following-sibling::button")
    WebElement datesTab;

    @FindBy(xpath = "//table[contains(@aria-label, 'May')]/tbody/tr")
    List<WebElement> listOfRows;

    @FindBy(xpath = "//button[contains(@class, 'uitk-button-primary uitk-layout-flex-item')]")
    WebElement doneBtn;

    @FindBy(xpath = "//button[contains(@class, 'uitk-menu-trigger open-room-picker-observer-root')]")
    WebElement travellersTab;

    @FindBy(id = "traveler_selector_done_button")
    WebElement travellersDoneBtn;

    @FindBy(xpath = "//button[@id='search_button']")
    WebElement searchBtn;


    public void openWebsite() {
        driver.get("https://www.hotels.com/");
    }


    public void enterDestination(String city) {
        goingToTab.click();
        destinationInput.sendKeys(city);
        listOfDestinations.get(0).click();
    }

    public void enterTravelDates() {
        datesTab.click();
        for(int i = 0; i < listOfRows.size(); i++) {
            List<WebElement> listOfCells = listOfRows.get(i).findElements(By.tagName("td"));

            for(int j = 0; j < listOfCells.size(); j++) {
                String date = listOfCells.get(j).getText();

                if(date.equalsIgnoreCase("20")) {
                    listOfCells.get(j).click();
                }

                if (date.equalsIgnoreCase("24")) {
                    listOfCells.get(j).click();
                    break;
                }
            }
        }
        doneBtn.click();
    }

    public void enterTravelers() {
        travellersTab.click();
        try {
            Thread.sleep(1500);
            travellersDoneBtn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }
}
