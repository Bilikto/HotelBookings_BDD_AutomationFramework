package com.intellitrans.pages;

import com.intellitrans.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;

    public BasePage() {
        driver = DriverUtils.getDriver();
        PageFactory.initElements(driver, this);
    }

}
