package com.cydeo.tests.day5_selenium;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimpleDropDown {
    WebDriver driver;

    //
    //TC#4: Verifying “Simple dropdown” and “State selection” dropdown
    //default values
    //1. Open Chrome browser
    @BeforeMethod
    public void setupWebDriver() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dropDown() {
        driver.get("https://practice.cydeo.com/dropdown");
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        WebElement currentDropdown = simpleDropdown.getFirstSelectedOption();

        String actualText = currentDropdown.getText();

        String expectedResult = "Please select an option";

        Assert.assertEquals(actualText, expectedResult);

        Select stateSelection = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        WebElement stateElement = stateSelection.getFirstSelectedOption();

        String actualStateElement = stateElement.getText();
        String expectedStateElement = "Select a State";

        Assert.assertEquals(actualStateElement,expectedStateElement );

    }


    //2. Go to https://practice.cydeo.com/dropdown
    //3. Verify “Simple dropdown” default selected value is correct
    //Expected: “Please select an option”
    //4. Verify “State selection” default selected value is correct
    //Expected: “Select a State”
    //
}
