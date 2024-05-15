package com.intellitrans.pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[contains(@class, 'uitk-layout-grid-item-has-column-start uitk-layout-grid-item-justify-self-end')]")
    List<WebElement> priceBlock;

    @FindBy(xpath = "//div[contains(@class, 'uitk-layout-grid-item-has-column-start-by-medium')]")
    List<WebElement> hotelElementBlock;

    public boolean isHotelListingPageDisplayed() {
        return titleText.isDisplayed() && selectElem.isDisplayed();
    }

    public void sortBy(String opt) {
        Select selectObj = new Select(selectElem);
        selectObj.selectByVisibleText(opt);
    }

    public void printHotelsWithPriceOver500(int price) {
        String hotelName;
        int hotelPrice;

        for(int i = 0; i < hotelElementBlock.size(); i++) {
            try {
                Thread.sleep(800);
                hotelName = hotelElementBlock.get(i).findElements(By.xpath("//h3[contains(@class, 'uitk-layout-grid-item uitk-layout-grid-item-has-row-start')]")).get(i).getText();
                hotelPrice = Integer.parseInt(hotelElementBlock.get(i).findElements(By.xpath("//div[contains(text(), 'The price is $')]")).get(i).getText().replaceAll("[^0-9]", ""));

                if(hotelPrice >= 500) {
                    System.out.println(hotelName + " has price " + hotelPrice);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
