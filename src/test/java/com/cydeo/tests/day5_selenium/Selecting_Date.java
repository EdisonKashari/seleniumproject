package com.cydeo.tests.day5_selenium;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Selecting_Date {
    WebDriver driver;

   @BeforeMethod
    public void setupWebdriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void dropDownTest(){


        Select yearDropDown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropDown.selectByVisibleText("1922");



        Select monthDropDown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropDown.selectByValue("11");

        Select dayDropDown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropDown .selectByIndex(0);


        String yearResult = yearDropDown .getFirstSelectedOption().getText();
        Assert.assertEquals(yearResult,"1922");

        String monthActualResult = monthDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(monthActualResult,"December");

        String dayActualResult = dayDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(dayActualResult,1);

    }




    //TC #6: Selecting date on dropdown and verifying
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Select “December 1st, 1922” and verify it is selected.
    //Select year using  : visible text
    //Select month using   : value attribute
    //Select day using : index number


}
