package com.intellitrans.steps;

import com.intellitrans.utils.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        DriverUtils.createDriver();
    }


//    @After
    public void cleanUp() {
        DriverUtils.getDriver().quit();
    }


}
