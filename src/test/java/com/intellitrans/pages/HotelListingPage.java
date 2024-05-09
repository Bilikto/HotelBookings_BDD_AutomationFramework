package com.intellitrans.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HotelListingPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(), '300+ properties')]")
    WebElement titleText;

    @FindBy(id = "sort-filter-dropdown-sort")
    WebElement selectElem;

    @FindBy(xpath = "//h3[contains(@class, 'overflow-wrap uitk-layout-grid-item uitk-layout-grid-item-has-row-start')]")
    List<WebElement> hotelNameList;

    @FindBy(xpath = "//div[contains(text(), 'The price is $')]")
    List<WebElement> priceList;

    public boolean isHotelListingPageDisplayed() {
        return titleText.isDisplayed() && selectElem.isDisplayed();
    }

    public void sortBy(String opt) {
        Select selectObj = new Select(selectElem);
        selectObj.selectByVisibleText(opt);
    }

    public void printHotelsWithPriceOver500(int price) {
        int priceValue = 0;

        for(int i = 0; i < priceList.size(); i++) {
            try {
                Thread.sleep(800);
                priceValue = Integer.parseInt(priceList.get(i).getText().replaceAll("[^0-9]", ""));
                if(priceValue > price) {
                    System.out.println("price " + priceValue);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
